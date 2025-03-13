package cn.edu.nju.cs.value;

public class TypeUtils {

    public static boolean isType(MiniJavaAny value, MiniJavaAny.Type type) {
        if (value.getType() == type) {
            return true;
        } else {
            throw new RuntimeException("Type mismatch. Requires " + type + ", but got " + value.getType() + ".");
        }
    }

    public static boolean isTypes(MiniJavaAny value, MiniJavaAny.Type ... types) {
        for (MiniJavaAny.Type type : types) {
            if (value.getType() == type) {
                return true;
            }
        }
        throw new RuntimeException("Type mismatch. Requires " + types + ", but got " + value.getType() + ".");
    }

    public static boolean isSameType(MiniJavaAny value1, MiniJavaAny value2) {
        if (value1.getType() == value2.getType()) {
            return true;
        } else {
            throw new RuntimeException("Type mismatch. Requires " + value1.getType() + ", but got " + value2.getType() + ".");
        }
    }
}
