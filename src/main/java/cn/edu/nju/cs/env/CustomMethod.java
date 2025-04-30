package cn.edu.nju.cs.env;

import cn.edu.nju.cs.parser.MiniJavaParser;
import cn.edu.nju.cs.throwables.Return;
import cn.edu.nju.cs.value.MiniJavaAny;
import cn.edu.nju.cs.value.TypeCast;
import cn.edu.nju.cs.value.TypeUtils;
import cn.edu.nju.cs.core.Interpreter;
import cn.edu.nju.cs.throwables.*;

public class CustomMethod implements MethodBody {

    final MethodSignature methodSignature;
    final MiniJavaParser.BlockContext mothodBody;
    final String[] parameterNames;

    public CustomMethod(MethodSignature methodSignature, String[] parameterNames, MiniJavaParser.BlockContext mothodBody) {
        this.methodSignature = methodSignature;
        this.mothodBody = mothodBody;
        this.parameterNames = parameterNames;
    }

    public MiniJavaParser.BlockContext getMothodBody() {
        return mothodBody;
    }

    public MethodSignature getMethodSignature() {
        return methodSignature;
    }

    @Override
    public MiniJavaAny invoke(RuntimeEnv env, MiniJavaAny[] args) {
        // 1. enter scope
        env.enterFunction(methodSignature.getMethodName());
        // 2. prepare parameters
        String[] parameterTypes = methodSignature.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            String parameterName = parameterNames[i];
            String parameterType = parameterTypes[i];
            MiniJavaAny arg = args[i];
            if (!arg.getType().equals(parameterType)) {
                arg = TypeCast.castTo(arg, parameterType);
            }
            env.init(parameterName, arg);
        }
        
        // 3. execute method body
        MiniJavaAny returnValue = null;
        try {
            new Interpreter(env).visit(mothodBody);
        } catch (Return ret) {
            returnValue = ret.getReturnValue();
        }
        
        // 4. exit scope
        env.exitFunction();

        // 5. check return type
        String returnType = methodSignature.getReturnType();
        if (returnValue == null) {
            if (returnType.equals("void")) {
                return null;
            } else {
                throw new TypeError("Method " + methodSignature.getMethodName() + " should return " + returnType + ", but returns nothing");
            }
        }
        if (returnType.equals(returnValue.getType())) {
            return returnValue;
        } else if (TypeUtils.canCastImplicit(returnValue.getType(), returnType)) {
            return TypeCast.castTo(returnValue, returnType);
        } else {
            throw new TypeError(returnValue.getType(), returnType, "when returning from method " + methodSignature.getMethodName());
        }
    }

}
