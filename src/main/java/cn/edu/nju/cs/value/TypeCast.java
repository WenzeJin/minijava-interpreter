package cn.edu.nju.cs.value;

import cn.edu.nju.cs.throwables.TypeError;
import cn.edu.nju.cs.value.MiniJavaAny.BasicType;

public class TypeCast {
    public static boolean isBasicType(String type) {
        return type.equals("int") || type.equals("char") || type.equals("boolean") || type.equals("string");
    }

    public static boolean isReferenceType(String type) {
        return !isBasicType(type) && !type.equals("null");
    }

    public static MiniJavaAny castTo(MiniJavaAny src, String type) {
        MiniJavaAny res = null;
        if (type.equals("void")) {
            // void means any type so we don't need to do anything
            return new MiniJavaAny(src);
        }
        if (type.equals("[]")) {
            // [] means array type
            if (src.isArray()) {
                return new MiniJavaAny(src);
            } else {
                throw new TypeError("Cannot cast " + src.getType() + " to array type.");
            }
        }
        switch (src.getType()) {
            case "int":
                switch (type) {
                    case "int" -> res = new MiniJavaAny(BasicType.INT, src.value);
                    case "char" -> res = new MiniJavaAny(BasicType.CHAR, src.getChar());
                    default -> throw new TypeError("Cannot cast int to " + type);
                }
                break;
            case "char":
                switch (type) {
                    case "int" -> res = new MiniJavaAny(BasicType.INT, src.getInt());
                    case "char" -> res = new MiniJavaAny(BasicType.CHAR, src.value);
                    default -> throw new TypeError("Cannot cast char to " + type);
                }
                break;
            case "boolean":
                throw new TypeError("Cannot cast boolean to " + type);
            case "string":
                throw new TypeError("Cannot cast string to " + type);
            case "null":
                if (isReferenceType(type)) {
                    res = new MiniJavaAny(type, null);
                } else {
                    throw new TypeError("Cannot cast null to " + type);
                }
                break;
        }

        return res;
    }

}
