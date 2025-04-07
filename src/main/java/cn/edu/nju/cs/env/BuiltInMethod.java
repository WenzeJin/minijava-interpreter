package cn.edu.nju.cs.env;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nju.cs.throwables.AssertionError;
import cn.edu.nju.cs.throwables.NullPointerError;
import cn.edu.nju.cs.value.MiniJavaAny;
import cn.edu.nju.cs.value.TypeCast;
import cn.edu.nju.cs.value.MiniJavaAny.BasicType;

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
        ArrayLengthImpl.initialize();
        StringLengthImpl.initialize();
        AssertImpl.initialize();
        ToCharArrayImpl.initialize();
        ToStringImpl.initialize();
        ATOIImpl.initialize();
        ITOAImpl.initialize();
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
            if (!arg.getType().equals(parameterType)) {
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
            MethodSignature methodSignature2 = new MethodSignature("println", "void", new String[0]);
            BuiltInMethod method2 = new BuiltInMethod(new PrintlnImpl());
            ((PrintlnImpl)method2.function).parameterTypes = new String[0];
            buildInMethodsRegistry.put(methodSignature2, method2);
        }

        private String[] parameterTypes = { "void" }; //void means any type

        @Override
        public String[] getParameterTypes() {
            return parameterTypes;
        }

        @Override
        public MiniJavaAny apply(RuntimeEnv env, MiniJavaAny... args) {
            if (args.length == 0) {
                System.out.println();
                return null;
            }

            MiniJavaAny arg = args[0];
            System.out.print(arg.getString() + "\n");
            return null;
        }
    }
    
    public static class ArrayLengthImpl implements MiniJavaMethodImpl {

        static void initialize() {
            MethodSignature methodSignature = new MethodSignature("length", "int", new String[] { "[]" });
            BuiltInMethod method = new BuiltInMethod(new ArrayLengthImpl());
            buildInMethodsRegistry.put(methodSignature, method);
        }

        private String[] parameterTypes = { "[]" };

        @Override
        public String[] getParameterTypes() {
            return parameterTypes;
        }

        @Override
        public MiniJavaAny apply(RuntimeEnv env, MiniJavaAny... args) {
            MiniJavaAny arg = args[0];
            if (arg.isArray()) {
                Object array = arg.getValue();
                if (array == null) {
                    throw new NullPointerError("Invoke length on null");
                }
                if (array instanceof List<?>) {
                    return new MiniJavaAny(MiniJavaAny.BasicType.INT, ((List<?>) array).size());
                }
            }
            throw new RuntimeException("Cannot get length of " + arg.getType());
        }
    }
    
    public static class StringLengthImpl implements MiniJavaMethodImpl {

        static void initialize() {
            MethodSignature methodSignature = new MethodSignature("length", "int", new String[] { "string" });
            BuiltInMethod method = new BuiltInMethod(new StringLengthImpl());
            buildInMethodsRegistry.put(methodSignature, method);
        }

        private String[] parameterTypes = { "string" };

        @Override
        public String[] getParameterTypes() {
            return parameterTypes;
        }

        @Override
        public MiniJavaAny apply(RuntimeEnv env, MiniJavaAny... args) {
            MiniJavaAny arg = args[0];
            if (arg.isBasicType(BasicType.STRING)) {
                String string = arg.getString();
                return new MiniJavaAny(MiniJavaAny.BasicType.INT, string.length());
            }
            throw new RuntimeException("Cannot get length of " + arg.getType());
        }
    }
    
    public static class AssertImpl implements MiniJavaMethodImpl {

        static void initialize() {
            MethodSignature methodSignature = new MethodSignature("assert", "void", new String[] { "boolean" });
            BuiltInMethod method = new BuiltInMethod(new AssertImpl());
            buildInMethodsRegistry.put(methodSignature, method);
        }

        private String[] parameterTypes = { "boolean" };

        @Override
        public String[] getParameterTypes() {
            return parameterTypes;
        }

        @Override
        public MiniJavaAny apply(RuntimeEnv env, MiniJavaAny... args) {
            MiniJavaAny arg = args[0];
            if (arg.isBasicType(MiniJavaAny.BasicType.BOOLEAN)) {
                if (!arg.getBoolean()) {
                    throw new AssertionError("Assertion failed");
                }
                return null;
            }
            throw new RuntimeException("Cannot assert " + arg.getType());
        }
    }

    public static class ToCharArrayImpl implements MiniJavaMethodImpl {

        static void initialize() {
            MethodSignature methodSignature = new MethodSignature("to_char_array", "char[]", new String[] { "string" });
            BuiltInMethod method = new BuiltInMethod(new ToCharArrayImpl());
            buildInMethodsRegistry.put(methodSignature, method);
        }

        private String[] parameterTypes = { "string" };

        @Override
        public String[] getParameterTypes() {
            return parameterTypes;
        }

        @Override
        public MiniJavaAny apply(RuntimeEnv env, MiniJavaAny... args) {
            MiniJavaAny arg = args[0];
            if (arg.isBasicType(MiniJavaAny.BasicType.STRING)) {
                String str = arg.getString();
                char[] charArray = str.toCharArray();
                List<MiniJavaAny> charArrayWrapper = new ArrayList<>();
                for (int i = 0; i < charArray.length; i++) {
                    charArrayWrapper.add(new MiniJavaAny(MiniJavaAny.BasicType.CHAR, (byte) charArray[i]));
                }
                return new MiniJavaAny("char[]", charArrayWrapper);
            }
            throw new RuntimeException("Cannot convert " + arg.getType() + " to char array");
        }
    }
    
    public static class ToStringImpl implements MiniJavaMethodImpl {

        static void initialize() {
            MethodSignature methodSignature = new MethodSignature("to_string", "string", new String[] { "char[]" });
            BuiltInMethod method = new BuiltInMethod(new ToStringImpl());
            buildInMethodsRegistry.put(methodSignature, method);
        }

        private String[] parameterTypes = { "char[]" };

        @Override
        public String[] getParameterTypes() {
            return parameterTypes;
        }

        @Override
        public MiniJavaAny apply(RuntimeEnv env, MiniJavaAny... args) {
            MiniJavaAny arg = args[0];
            if (arg.isArray()) {
                Object array = arg.getValue();
                if (array == null) {
                    throw new NullPointerError("Invoke to_string on null");
                }
                if (array instanceof List<?>) {
                    List<?> list = (List<?>) array;
                    StringBuilder sb = new StringBuilder();
                    for (Object obj : list) {
                        if (obj instanceof MiniJavaAny) {
                            MiniJavaAny charObj = (MiniJavaAny) obj;
                            if (charObj.isBasicType(MiniJavaAny.BasicType.CHAR)) {
                                sb.append((char) charObj.getChar());
                            } else {
                                throw new RuntimeException("Invalid type in char array: " + charObj.getType());
                            }
                        } else {
                            throw new RuntimeException("Invalid type in char array: " + obj.getClass());
                        }
                    }
                    return new MiniJavaAny(MiniJavaAny.BasicType.STRING, sb.toString());
                }
            }
            throw new RuntimeException("Cannot convert " + arg.getType() + " to string");
        }
    }

    public static class ATOIImpl implements MiniJavaMethodImpl {

        static void initialize() {
            MethodSignature methodSignature = new MethodSignature("atoi", "int", new String[] { "string" });
            BuiltInMethod method = new BuiltInMethod(new ATOIImpl());
            buildInMethodsRegistry.put(methodSignature, method);
        }

        private String[] parameterTypes = { "string" };

        @Override
        public String[] getParameterTypes() {
            return parameterTypes;
        }

        @Override
        public MiniJavaAny apply(RuntimeEnv env, MiniJavaAny... args) {
            MiniJavaAny arg = args[0];
            if (arg.isBasicType(MiniJavaAny.BasicType.STRING)) {
                String str = arg.getString();
                try {
                    int intValue = Integer.parseInt(str);
                    return new MiniJavaAny(MiniJavaAny.BasicType.INT, intValue);
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Cannot convert " + str + " to int");
                }
            }
            throw new RuntimeException("Cannot convert " + arg.getType() + " to int");
        }
    }

    public static class ITOAImpl implements MiniJavaMethodImpl {

        static void initialize() {
            MethodSignature methodSignature = new MethodSignature("itoa", "string", new String[] { "int" });
            BuiltInMethod method = new BuiltInMethod(new ITOAImpl());
            buildInMethodsRegistry.put(methodSignature, method);
        }

        private String[] parameterTypes = { "int" };

        @Override
        public String[] getParameterTypes() {
            return parameterTypes;
        }

        @Override
        public MiniJavaAny apply(RuntimeEnv env, MiniJavaAny... args) {
            MiniJavaAny arg = args[0];
            if (arg.isBasicType(MiniJavaAny.BasicType.INT)) {
                int intValue = arg.getInt();
                return new MiniJavaAny(MiniJavaAny.BasicType.STRING, String.valueOf(intValue));
            }
            throw new RuntimeException("Cannot convert " + arg.getType() + " to string");
        }
    }
}
