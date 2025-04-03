package cn.edu.nju.cs.env;

import cn.edu.nju.cs.value.MiniJavaAny;
import cn.edu.nju.cs.value.TypeCast;

public class BuiltInMethod implements MethodBody{
    
    private final MiniJavaMethodImpl function;

    public BuiltInMethod(MiniJavaMethodImpl function) {
        this.function = function;
    }

    @Override
    public MiniJavaAny invoke(RuntimeEnv env, MiniJavaAny[] args) {
        // prepare the parameters
        String[] parameterTypes = function.getParameterTypes();
        MiniJavaAny[] parameters = new MiniJavaAny[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            String parameterType = parameterTypes[i];
            MiniJavaAny arg = args[i];
            if (arg.getType() != parameterType) {
                arg = TypeCast.castTo(arg, parameterType);
            }
            parameters[i] = arg;
        }
        // invoke the function
        env.enterFunction(function.getClass().getSimpleName());
        MiniJavaAny result = function.apply(env, parameters);
        env.exitFunction();
        return result;
    }
}
