package cn.edu.nju.cs.core;

import cn.edu.nju.cs.env.MethodSignature;
import cn.edu.nju.cs.env.CustomMethod;
import cn.edu.nju.cs.env.MethodBody;
import cn.edu.nju.cs.env.RuntimeEnv;
import cn.edu.nju.cs.parser.MiniJavaParser;
import cn.edu.nju.cs.parser.MiniJavaParserBaseVisitor;
import cn.edu.nju.cs.value.*;
import cn.edu.nju.cs.value.MiniJavaAny.BasicType;
import cn.edu.nju.cs.throwables.*;

public class Interpreter extends MiniJavaParserBaseVisitor<MiniJavaAny> {
    final RuntimeEnv env;

    public Interpreter() {
        super();
        env = new RuntimeEnv();
        env.registerBuiltInMethod();
    }

    public Interpreter(RuntimeEnv env) {
        // 继承环境
        super();
        this.env = env;
    }

    @Override
    public MiniJavaAny visitCompilationUnit(MiniJavaParser.CompilationUnitContext ctx) {
        visitChildren(ctx);
        MethodSignature mainSignature = new MethodSignature("main", "int", new String[0]);
        MethodBody mainEntry = env.getMethod(mainSignature);
        if (mainEntry == null) {
            throw new RuntimeException("No main method found.");
        }
        assert mainEntry instanceof CustomMethod;
        MiniJavaAny ret = mainEntry.invoke(env, new MiniJavaAny[0]);
        System.out.println("Process exits with the code " + ret.getInt() + ".");
        return null;
    }

    @Override
    public MiniJavaAny visitMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx) {
        /*
         * methodDeclaration
         * : (typeType | VOID) identifier formalParameters methodBody = block;
         * 
         * formalParameters
         * : '(' formalParameterList? ')'
         * 
         * formalParameterList
         * : formalParameter (',' formalParameter)*
         * 
         * formalParameter
         * : typeType identifier
         * 
         */
        String methodName = ctx.identifier().getText();
        String returnType = ctx.typeType() != null ? ctx.typeType().getText() : "void";
        var formalParameterList = ctx.formalParameters().formalParameterList();
        
        String[] parameterType = formalParameterList != null ? 
                formalParameterList.formalParameter().stream()
                        .map(p -> p.typeType().getText())
                        .toArray(String[]::new)
                : new String[0];
        String[] parameterName = formalParameterList != null ?
                formalParameterList.formalParameter().stream()
                        .map(p -> p.identifier().getText())
                        .toArray(String[]::new)
                : new String[0];
        var methodBodyContext = ctx.methodBody;
        var methodSignature = new MethodSignature(methodName, returnType, parameterType);
        var methodBody = new CustomMethod(methodSignature, parameterName, methodBodyContext);
        env.registerMethod(methodSignature, methodBody);
        return null;
    }

    @Override
    public MiniJavaAny visitBlock(MiniJavaParser.BlockContext ctx) {
        boolean newScope = false;
        if (!env.isCreatedNewScope()) {
            env.enterBlock();
            newScope = true;
        } else {
            env.useNewScope();
        }
        var ret = visitChildren(ctx);
        if (newScope) {
            env.exitBlock();
        }
        return ret;
    }

    @Override
    public MiniJavaAny visitBlockStatement(MiniJavaParser.BlockStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public MiniJavaAny visitLocalVariableDeclaration(MiniJavaParser.LocalVariableDeclarationContext ctx) {
        /**
         * localVariableDeclaration
         * : VAR identifier '=' expression
         * | typeType variableDeclarator
         * ;
         * 
         * variableDeclarator
         * : identifier ('=' expression)?
         * ;
         */
        if (ctx.VAR() != null) {
            // VAR identifier '=' expression
            MiniJavaAny value = visit(ctx.expression());
            String identifier = ctx.identifier().getText();
            if (value.isLiteral() && value.isBasicType(BasicType.CHAR)) {
                // we will make it int when its a char literal
                value = new MiniJavaAny(BasicType.INT, value.getInt());
            }
            if (!env.init(identifier, value)) {
                throw new RuntimeException("Variable " + identifier + " already exists.");
            }
        } else {
            // typeType variableDeclarator
            MiniJavaAny prototype = visit(ctx.typeType());
            var variableDeclarator = ctx.variableDeclarator();
            String identifier = variableDeclarator.identifier().getText();
            if (variableDeclarator.variableInitializer() != null) {
                // variableDeclarator '=' expression
                MiniJavaAny value = visit(variableDeclarator.variableInitializer());
                if (!value.getType().equals(prototype.getType())
                        && !TypeUtils.canCastImplicit(value.getType(), prototype.getType())) {
                    // wrong type initialization and cannot cast implicitly
                    throw new TypeError("Variable " + identifier + " cannot be initialized with type " + value.getType()
                            + ", expected " + prototype.getType());
                } else if (!value.getType().equals(prototype.getType()) && TypeUtils.canCastImplicit(value.getType(), prototype.getType())) {
                    // cast implicitly
                    value = TypeCast.castTo(value, prototype.getType());
                }
                if (!env.init(identifier, value)) {
                    throw new RuntimeException("Variable " + identifier + " already exists.");
                }
            } else {
                // variableDeclarator
                prototype.initializeDefaultValue();
                if (!env.init(identifier, prototype)) {
                    throw new RuntimeException("Variable " + identifier + " already exists.");
                }
            }
        }
        return null;
    }

    @Override
    public MiniJavaAny visitStatement(MiniJavaParser.StatementContext ctx) {
        /*
        statement
        : block
        | IF parExpression statement (ELSE statement)?
        | FOR '(' forControl ')' statement
        | WHILE parExpression statement
        | RETURN expression? ';'
        | BREAK ';'
        | CONTINUE ';'
        | SEMI
        | expression ';'
        ;
         */

        // deal with block
        if (ctx.block() != null) {
            return visit(ctx.block());
        }

        // deal with expression
        if (ctx.expression() != null && ctx.getChildCount() == 2) {
            return visit(ctx.expression());
        }

        // deal with BREAK
        if (ctx.BREAK() != null) {
            // 处理 break 语句
            throw new Break();
        }

        // deal with CONTINUE
        if (ctx.CONTINUE() != null) {
            // 处理 continue 语句
            throw new Continue();
        }

        // deal with IF
        if (ctx.IF() != null) {
            // 处理 if 语句
            MiniJavaAny condition = visit(ctx.parExpression().expression());
            TypeUtils.isBasicType(condition, BasicType.BOOLEAN);
            if (condition.getBoolean()) {
                return visit(ctx.statement(0));
            } else if (ctx.ELSE() != null) {
                return visit(ctx.statement(1));
            }
        }

        // deal with WHILE
        if (ctx.WHILE() != null) {
            // 处理 while 语句
            while (true) {
                MiniJavaAny condition = visit(ctx.parExpression().expression());
                TypeUtils.isBasicType(condition, BasicType.BOOLEAN);
                if (!condition.getBoolean()) {
                    break;
                }
                try {
                    visit(ctx.statement(0));
                } catch (Continue e) {
                    // continue
                } catch (Break e) {
                    // break
                    break;
                }
            }
        }

        // deal with FOR
        if (ctx.FOR() != null) {
            // 处理 for 语句
            /*
             * forControl
             * : forInit? ';' expression? ';' forUpdate?
             */
            var forInit = ctx.forControl().forInit();
            var expression = ctx.forControl().expression();
            var forUpdate = ctx.forControl().forUpdate;
            if (forInit != null) {
                visitChildren(forInit);
            }
            while (true) {
                if (expression != null) {
                    MiniJavaAny condition = visit(expression);
                    TypeUtils.isBasicType(condition, BasicType.BOOLEAN);
                    if (!condition.getBoolean()) {
                        break;
                    }
                }
                try {
                    visit(ctx.statement(0));
                } catch (Continue e) {
                    // continue
                } catch (Break e) {
                    // break
                    break;
                }
                if (forUpdate != null) {
                    visit(forUpdate);
                }
            }
        }

        // deal with RETURN
        if (ctx.RETURN() != null) {
            // 处理 return 语句
            if (ctx.expression() != null) {
                MiniJavaAny value = visit(ctx.expression());
                throw new Return(value);
            } else {
                throw new Return(null);
            }
        }

        return null; // 默认返回 null
    }

    @Override
    public MiniJavaAny visitMethodCall(MiniJavaParser.MethodCallContext ctx) {
        /*
         * methodCall
         * : identifier arguments
         * ;
         */
        String methodName = ctx.identifier().getText();
        var args = ctx.arguments().expressionList();
        MethodBody methodBody = null;
        MethodSignature signature = null;
        MiniJavaAny[] argValues = null;
        if (args == null) {
            // returnType is not important here
            signature = new MethodSignature(methodName, "void", new String[0]);
            methodBody = env.getMethod(signature);
            argValues = new MiniJavaAny[0];
        } else {
            argValues = new MiniJavaAny[args.expression().size()];
            for (int i = 0; i < args.expression().size(); i++) {
                // pass values, not references
                argValues[i] = new MiniJavaAny(visit(args.expression(i)));
            }
            String[] parameterTypes = new String[argValues.length];
            for (int i = 0; i < argValues.length; i++) {
                parameterTypes[i] = argValues[i].getType();
            }
            signature = new MethodSignature(methodName, "void", parameterTypes);
            methodBody = env.getMethod(signature);
        }
        if (methodBody == null) {
            throw new RuntimeException("Method " + signature + " not found.");
        }
        return methodBody.invoke(env, argValues);
    }

    @Override
    public MiniJavaAny visitExpression(MiniJavaParser.ExpressionContext ctx) {

        if (ctx.primary() != null) {
            // visit primary
            return visit(ctx.primary());

        } else if (ctx.postfix != null) {
            // deal with postfix
            MiniJavaAny value = visit(ctx.expression(0));
            if (!value.isVariable()) {
                throw new RuntimeException("Postfix operation must be applied to a variable.");
            }
            TypeUtils.isBasicType(value, BasicType.INT);
            MiniJavaAny oldValue = value.clone();
            if (ctx.postfix.getText().equals("++")) {
                value.increment();
            } else if (ctx.postfix.getText().equals("--")) {
                value.decrement();
            }
            return oldValue;

        } else if (ctx.prefix != null) {
            // deal with prefix
            MiniJavaAny value = visit(ctx.expression(0));
            switch (ctx.prefix.getText()) {
                case "+":
                    TypeUtils.assertNumber(value);
                    return value;
                case "-":
                    TypeUtils.assertNumber(value);
                    return new MiniJavaAny(BasicType.INT, -value.getInt());
                case "~":
                    TypeUtils.assertNumber(value);
                    return new MiniJavaAny(BasicType.INT, ~value.getInt());
                case "not":
                    TypeUtils.isBasicType(value, BasicType.BOOLEAN);
                    return new MiniJavaAny(BasicType.BOOLEAN, !value.getBoolean());
                case "++":
                    if (value.isBasicType(BasicType.INT) || value.isBasicType(BasicType.CHAR)) {
                        value.increment();
                    } else {
                        throw new TypeError("Prefix '++' operation must be applied to int or char.");
                    }
                    return value;
                case "--":
                    if (value.isBasicType(BasicType.INT) || value.isBasicType(BasicType.CHAR)) {
                        value.decrement();
                    } else {
                        throw new TypeError("Prefix '--' operation must be applied to int or char.");
                    }
                    return value;
            }

        } else if (ctx.typeType() != null) {
            String type = ctx.typeType().getText();
            MiniJavaAny value = visit(ctx.expression(0));
            return TypeCast.castTo(value, type);
        } else if (ctx.bop != null) {
            if (ctx.bop.getText().equals("and") || ctx.bop.getText().equals("or")) {
                // short circuit
                MiniJavaAny lv = visit(ctx.expression(0));
                TypeUtils.isBasicType(lv, BasicType.BOOLEAN);
                if (ctx.bop.getText().equals("and")) {
                    if (!lv.getBoolean()) {
                        return new MiniJavaAny(BasicType.BOOLEAN, false);
                    }
                } else {
                    if (lv.getBoolean()) {
                        return new MiniJavaAny(BasicType.BOOLEAN, true);
                    }
                }
                MiniJavaAny rv = visit(ctx.expression(1));
                TypeUtils.isBasicType(rv, BasicType.BOOLEAN);
                return new MiniJavaAny(BasicType.BOOLEAN, rv.getValue());

            }

            if (ctx.bop.getText().equals("?")) {
                // conditional expression
                MiniJavaAny cv = visit(ctx.expression(0));
                TypeUtils.isBasicType(cv, BasicType.BOOLEAN);
                if ((boolean) cv.getValue()) {
                    return visit(ctx.expression(1));
                } else {
                    return visit(ctx.expression(2));
                }

            }

            // deal with bop
            MiniJavaAny lv = visit(ctx.expression(0));
            MiniJavaAny rv = visit(ctx.expression(1));

            switch (ctx.bop.getText()) {
                case "=":
                    if (!lv.isVariable()) {
                        throw new RuntimeException("Left value of = must be a variable.");
                    } else if (lv.getType().equals(rv.getType())) {
                        lv.assign(rv);
                    } else if (TypeUtils.canCastImplicit(rv.getType(), lv.getType())) {
                        // cast implicitly
                        rv = TypeCast.castTo(rv, lv.getType());
                        lv.assign(rv);
                        return lv.clone();
                    } else {
                        throw new TypeError("Cannot assign " + rv.getType() + " to " + lv.getType());
                    }
                case "*":
                    return CalcUtils.mul(lv, rv);
                case "/":
                    return CalcUtils.div(lv, rv);
                case "%":
                    return CalcUtils.mod(lv, rv);
                case "+":
                    return CalcUtils.add(lv, rv);
                case "-":
                    return CalcUtils.sub(lv, rv);
                case "<<":
                    return CalcUtils.shiftLeft(lv, rv);
                case ">>":
                    return CalcUtils.shiftRight(lv, rv);
                case ">>>":
                    return CalcUtils.unsignedShiftRight(lv, rv);
                case "<":
                    return CalcUtils.lt(lv, rv);
                case ">":
                    return CalcUtils.gt(lv, rv);
                case "<=":
                    return CalcUtils.leq(lv, rv);
                case ">=":
                    return CalcUtils.geq(lv, rv);
                case "==":
                    return CalcUtils.eq(lv, rv);
                case "!=":
                    return CalcUtils.neq(lv, rv);
                case "&":
                    return CalcUtils.bitAnd(lv, rv);
                case "^":
                    return CalcUtils.bitXor(lv, rv);
                case "|":
                    return CalcUtils.bitOr(lv, rv);
                case "+=":
                    if (!lv.isVariable()) {
                        throw new RuntimeException("Left value of += must be a variable.");
                    }
                    lv.assign(CalcUtils.add(lv, rv));
                    return lv.clone();
                case "-=":
                    if (!lv.isVariable()) {
                        throw new RuntimeException("Left value of -= must be  a variable.");
                    }
                    lv.assign(CalcUtils.sub(lv, rv));
                    return lv.clone();
                case "*=":
                    if (!lv.isVariable()) {
                        throw new RuntimeException("Left value of *= must be  a variable.");
                    }
                    lv.assign(CalcUtils.mul(lv, rv));
                    return lv.clone();
                case "/=":
                    if (!lv.isVariable()) {
                        throw new RuntimeException("Left value of /= must be  a variable.");
                    }
                    lv.assign(CalcUtils.div(lv, rv));
                    return lv.clone();
                case "%=":
                    if (!lv.isVariable()) {
                        throw new RuntimeException("Left value of %= must be  a variable.");
                    }
                    lv.assign(CalcUtils.mod(lv, rv));
                    return lv.clone();
                case "<<=":
                    if (!lv.isVariable()) {
                        throw new RuntimeException("Left value of <<= must be  a variable.");
                    }
                    lv.assign(CalcUtils.shiftLeft(lv, rv));
                    return lv.clone();
                case ">>=":
                    if (!lv.isVariable()) {
                        throw new RuntimeException("Left value of >>= must be  a variable.");
                    }
                    lv.assign(CalcUtils.shiftRight(lv, rv));
                    return lv.clone();
                case ">>>=":
                    if (!lv.isVariable()) {
                        throw new RuntimeException("Left value of >>>= must be  a variable.");
                    }
                    lv.assign(CalcUtils.unsignedShiftRight(lv, rv));
                    return lv.clone();
                case "&=":
                    if (!lv.isVariable()) {
                        throw new RuntimeException("Left value of &= must be  a variable.");
                    }
                    lv.assign(CalcUtils.bitAnd(lv, rv));
                    return lv.clone();
                case "^=":
                    if (!lv.isVariable()) {
                        throw new RuntimeException("Left value of ^= must be  a variable.");
                    }
                    lv.assign(CalcUtils.bitXor(lv, rv));
                    return lv.clone();
                case "|=":
                    if (!lv.isVariable()) {
                        throw new RuntimeException("Left value of |= must be  a variable.");
                    }
                    lv.assign(CalcUtils.bitOr(lv, rv));
                    return lv.clone();
                default:
                    throw new RuntimeException("Unknown binary operator.");
            }
        } else if (ctx.methodCall() != null) {
            return visitMethodCall(ctx.methodCall());
        } else {
            throw new RuntimeException("Unknown expression.");
        }

        return null;
    }

    @Override
    public MiniJavaAny visitPrimary(MiniJavaParser.PrimaryContext ctx) {
        if (ctx.getChildCount() == 3) {
            // '(' expression ')'
            return visit(ctx.expression());
        } else {
            return visitChildren(ctx);
        }
    }

    private boolean inCharRange(int val) {
        return Byte.MIN_VALUE <= val && val <= Byte.MAX_VALUE;
    }

    @Override
    public MiniJavaAny visitLiteral(MiniJavaParser.LiteralContext ctx) {
        MiniJavaAny value = null;
        if (ctx.DECIMAL_LITERAL() != null) {
            int val = Integer.parseInt(ctx.getText());
            if (inCharRange(val)) {
                value = new MiniJavaAny(BasicType.CHAR, (byte) Integer.parseInt(ctx.getText()));
            } else {
                value = new MiniJavaAny(BasicType.INT, Integer.parseInt(ctx.getText()));
            }
        } else if (ctx.CHAR_LITERAL() != null) {
            value = new MiniJavaAny(BasicType.CHAR, (byte)ctx.getText().charAt(1));
        } else if (ctx.STRING_LITERAL() != null) {
            var lit = ctx.getText();
            value = new MiniJavaAny(BasicType.STRING, lit.substring(1, lit.length() - 1));
        } else if (ctx.BOOL_LITERAL() != null) {
            value = new MiniJavaAny(BasicType.BOOLEAN, Boolean.parseBoolean(ctx.getText()));
        } else if (ctx.NULL_LITERAL() != null) {
            value = new MiniJavaAny(BasicType.NULL, null);
        }
        if (value != null) {
            value.setLiteral();
            return value;
        }
        return null;
    }

    @Override
    public MiniJavaAny visitIdentifier(MiniJavaParser.IdentifierContext ctx) {
        String identifier = ctx.IDENTIFIER().toString();
        return env.lookUp(identifier);
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
    @Override
    public MiniJavaAny visitTypeType(MiniJavaParser.TypeTypeContext ctx) {
        return new MiniJavaAny(ctx.getText(), null);
    }


}
