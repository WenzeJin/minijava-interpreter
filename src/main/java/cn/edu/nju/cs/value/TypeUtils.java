package cn.edu.nju.cs.value;

public class TypeUtils {

    public static boolean isType(MiniJavaAny value, MiniJavaAny.BasicType type) {
        if (value.isBasicType(type)) {
            return true;
        } else {
            throw new RuntimeException("Type mismatch. Requires " + type + ", but got " + value.getType() + ".");
        }
    }

    public static boolean isTypes(MiniJavaAny value, MiniJavaAny.BasicType ... types) {
        for (var type : types) {
            if (value.isBasicType(type)) {
                return true;
            }
        }
        throw new RuntimeException("Type mismatch. Requires " + types + ", but got " + value.getType() + ".");
    }

    public static boolean isSameType(MiniJavaAny value1, MiniJavaAny value2) {
        if (value1.getType().equals(value2.getType())) {
            return true;
        } else {
            throw new RuntimeException("Type mismatch. Requires " + value1.getType() + ", but got " + value2.getType() + ".");
        }
    }
}
