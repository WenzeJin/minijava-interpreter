package cn.edu.nju.cs.core;

import cn.edu.nju.cs.env.RuntimeEnv;
import cn.edu.nju.cs.parser.MiniJavaParser;
import cn.edu.nju.cs.parser.MiniJavaParserBaseVisitor;
import cn.edu.nju.cs.value.*;
import cn.edu.nju.cs.value.MiniJavaAny.BasicType;

public class MiniJavaVisitor extends MiniJavaParserBaseVisitor<MiniJavaAny> {
    final RuntimeEnv env;

    public MiniJavaVisitor() {
        env = new RuntimeEnv();
    }

    @Override
    public MiniJavaAny visitCompilationUnit(MiniJavaParser.CompilationUnitContext ctx) {
        return visit(ctx.block());
    }

    @Override
    public MiniJavaAny visitBlock(MiniJavaParser.BlockContext ctx) {
        env.enterBlock();
        var ret = visitChildren(ctx);
        env.exitBlock();
        return ret;
    }

    @Override
    public MiniJavaAny visitBlockStatement(MiniJavaParser.BlockStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public MiniJavaAny visitLocalVariableDeclaration(MiniJavaParser.LocalVariableDeclarationContext ctx) {
        MiniJavaAny value = null;
        String id = null;

        if (ctx.getChildCount() == 2)  {
            // PrimitiveType Identifier
            value = visit(ctx.primitiveType());
            id = ctx.identifier().getText();

        } else if (ctx.getChildCount() == 4) {
            // PrimitiveType Identifier '=' Expression
            value = visit(ctx.expression());
            if (ctx.primitiveType().getText().equals("int")) {
                TypeUtils.isTypes(value, BasicType.INT, BasicType.CHAR);
                value = new MiniJavaAny(BasicType.INT, value.getInt());
            } else if (ctx.primitiveType().getText().equals("char")) {
                TypeUtils.isTypes(value, BasicType.CHAR, BasicType.INT);
                value = new MiniJavaAny(BasicType.CHAR, value.getChar());
            } else if (ctx.primitiveType().getText().equals("boolean")) {
                TypeUtils.isType(value, BasicType.BOOLEAN);
                value = new MiniJavaAny(BasicType.BOOLEAN, value.getBoolean());
            } else if (ctx.primitiveType().getText().equals("string")) {
                TypeUtils.isType(value, BasicType.STRING);
                value = new MiniJavaAny(BasicType.STRING, value.getString());
            }

            id = ctx.identifier().getText();
        }

        if (id == null) {
            return null;
        }

        if (!env.init(id, value)) {
            throw new RuntimeException("Variable " + id + " already defined.");
        }

        return null;
    }

    @Override
    public MiniJavaAny visitStatement(MiniJavaParser.StatementContext ctx) {
        // 处理 block 语句
        if (ctx.block() != null) {
            return visit(ctx.block());
        }

        // 处理表达式语句 `expression;`
        if (ctx.expression() != null) {
            return visit(ctx.expression());
        }

        return null; // 默认返回 null
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
            TypeUtils.isType(value, BasicType.INT);
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
                    TypeUtils.isTypes(value, BasicType.INT, BasicType.CHAR);
                    return value;
                case "-":
                    if (value.isBasicType(BasicType.INT) || value.isBasicType(BasicType.CHAR))
                        return new MiniJavaAny(BasicType.INT, -value.getInt());
                    else
                        throw new RuntimeException("Prefix '-' operation must be applied to int or char.");
                case "~":
                    if (value.isBasicType(BasicType.INT) || value.isBasicType(BasicType.CHAR))
                        return new MiniJavaAny(BasicType.INT, ~value.getInt());
                    else
                        throw new RuntimeException("Prefix '~' operation must be applied to int or char.");
                case "not":
                    TypeUtils.isType(value, BasicType.BOOLEAN);
                    return new MiniJavaAny(BasicType.BOOLEAN, !value.getBoolean());
                case "++":
                    if (value.isBasicType(BasicType.INT) || value.isBasicType(BasicType.CHAR)) {
                        value.increment();
                    } else {
                        throw new RuntimeException("Prefix '++' operation must be applied to int or char.");
                    }
                    return value;
                case "--":
                    if (value.isBasicType(BasicType.INT) || value.isBasicType(BasicType.CHAR)) {
                        value.decrement();
                    } else {
                        throw new RuntimeException("Prefix '--' operation must be applied to int or char.");
                    }
                    return value;
            }

        } else if (ctx.primitiveType() != null) {
            // deal with type cast
            String type = ctx.primitiveType().getText();
            MiniJavaAny value = visit(ctx.expression(0));
            return TypeCast.castTo(value, type);

        } else if (ctx.bop != null) {
            if (ctx.bop.getText().equals("and") || ctx.bop.getText().equals("or")) {
                // short circuit
                MiniJavaAny lv = visit(ctx.expression(0));
                TypeUtils.isType(lv, BasicType.BOOLEAN);
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
                TypeUtils.isType(rv, BasicType.BOOLEAN);
                return new MiniJavaAny(BasicType.BOOLEAN, rv.getValue());

            }

            if (ctx.bop.getText().equals("?")) {
                // conditional expression
                MiniJavaAny cv = visit(ctx.expression(0));
                TypeUtils.isType(cv, BasicType.BOOLEAN);
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
                    lv.assign(rv);
                    return lv.clone();
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

    @Override
    public MiniJavaAny visitLiteral(MiniJavaParser.LiteralContext ctx) {
        if (ctx.DECIMAL_LITERAL() != null) {
            return new MiniJavaAny(BasicType.INT, Integer.parseInt(ctx.getText()));
        } else if (ctx.CHAR_LITERAL() != null) {
            return new MiniJavaAny(BasicType.CHAR, (byte)ctx.getText().charAt(1));
        } else if (ctx.STRING_LITERAL() != null) {
            var lit = ctx.getText();
            return new MiniJavaAny(BasicType.STRING, lit.substring(1, lit.length() - 1));
        } else if (ctx.BOOL_LITERAL() != null) {
            return new MiniJavaAny(BasicType.BOOLEAN, Boolean.parseBoolean(ctx.getText()));
        }

        return null;
    }

    @Override
    public MiniJavaAny visitIdentifier(MiniJavaParser.IdentifierContext ctx) {
        String identifier = ctx.IDENTIFIER().toString();
        return env.lookUp(identifier);
    }

    @Override
    public MiniJavaAny visitPrimitiveType(MiniJavaParser.PrimitiveTypeContext ctx) {
        String typeStr = ctx.getText();
        return switch (typeStr) {
            case "int" -> {
                int value = 0;
                yield new MiniJavaAny(BasicType.INT, value);
            }
            case "char" -> {
                byte c = 0;
                yield new MiniJavaAny(BasicType.CHAR, c);
            }
            case "boolean" -> {
                boolean b = false;
                yield new MiniJavaAny(BasicType.BOOLEAN, b);
            }
            case "string" -> {
                String s = "";
                yield new MiniJavaAny(BasicType.STRING, s);
            }
            default -> null;
        };
    }


}
