package cn.edu.nju.cs.env;

import java.util.HashMap;
import java.util.Map;

import cn.edu.nju.cs.value.MiniJavaAny;
import cn.edu.nju.cs.value.TypeCast;

public class BuiltInMethod implements MethodBody {
    
    private static final Map<MethodSignature, MethodBody> buildInMethodsRegistry = new HashMap<>();

    private final MiniJavaMethodImpl function;

    public BuiltInMethod(MiniJavaMethodImpl function) {
        this.function = function;
    }

    public MiniJavaMethodImpl getFunction() {
        return function;
    }

    public static void initialize() {
        PrintImpl.initialize();
        PrintlnImpl.initialize();
    }

    public static Map<MethodSignature, MethodBody> getBuildInMethodsRegistry() {
        return buildInMethodsRegistry;
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

    public static class PrintImpl implements MiniJavaMethodImpl {

        static void initialize() {
            MethodSignature methodSignature = new MethodSignature("print", "void", new String[] { "void" });
            BuiltInMethod method = new BuiltInMethod(new PrintImpl());
            buildInMethodsRegistry.put(methodSignature, method);
        }

        private String[] parameterTypes = { "void" }; //void means any type

        @Override
        public String[] getParameterTypes() {
            return parameterTypes;
        }

        @Override
        public MiniJavaAny apply(RuntimeEnv env, MiniJavaAny... args) {
            MiniJavaAny arg = args[0];
            System.out.print(arg.getString());
            return null;
        }
    }

    public static class PrintlnImpl implements MiniJavaMethodImpl {

        static void initialize() {
            MethodSignature methodSignature = new MethodSignature("println", "void", new String[] { "void" });
            BuiltInMethod method = new BuiltInMethod(new PrintlnImpl());
            buildInMethodsRegistry.put(methodSignature, method);
        }

        private String[] parameterTypes = { "void" }; //void means any type

        @Override
        public String[] getParameterTypes() {
            return parameterTypes;
        }

        @Override
        public MiniJavaAny apply(RuntimeEnv env, MiniJavaAny... args) {
            MiniJavaAny arg = args[0];
            System.out.print(arg.getString() + "\n");
            return null;
        }
    }
    
    
}
