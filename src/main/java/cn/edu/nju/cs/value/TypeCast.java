package cn.edu.nju.cs.value;

import cn.edu.nju.cs.value.MiniJavaAny.BasicType;

public class TypeCast {

    public static MiniJavaAny castTo(MiniJavaAny src, String type) {
        BasicType t = switch (type) {
            case "int"      -> BasicType.INT;
            case "char"     -> BasicType.CHAR;
            case "boolean"  -> BasicType.BOOLEAN;
            case "string"   -> BasicType.STRING;
            default         -> throw new RuntimeException("Unknown type.");
        };

        return castTo(src, t);
    }

    public static MiniJavaAny castTo(MiniJavaAny src, BasicType type) {
        return switch (src.getType()) {
            case "int"    -> switch (type) {
                case INT    -> new MiniJavaAny(BasicType.INT, src.value);
                case CHAR   -> new MiniJavaAny(BasicType.CHAR, src.getChar());
                default     -> throw new RuntimeException("Cannot cast int to " + type);
            };
            case "char"   -> switch (type) {
                case INT    -> new MiniJavaAny(BasicType.INT, src.getInt());
                case CHAR   -> new MiniJavaAny(BasicType.CHAR, src.value);
                default     -> throw new RuntimeException("Cannot cast char to " + type);
            };
            case "boolean"  -> throw new RuntimeException("Cannot cast boolean to " + type);
            case "string"   -> throw new RuntimeException("Cannot cast string to " + type);
            default         -> throw new RuntimeException("Unknown type.");
        };
    }

}
