package cn.edu.nju.cs.value;

public class TypeCast {

    public static MiniJavaAny castTo(MiniJavaAny src, String type) {
        MiniJavaAny.Type t = switch (type) {
            case "int"      -> MiniJavaAny.Type.INT;
            case "char"     -> MiniJavaAny.Type.CHAR;
            case "boolean"  -> MiniJavaAny.Type.BOOLEAN;
            case "string"   -> MiniJavaAny.Type.STRING;
            default         -> throw new RuntimeException("Unknown type.");
        };

        return castTo(src, t);
    }

    public static MiniJavaAny castTo(MiniJavaAny src, MiniJavaAny.Type type) {
        return switch (src.type) {
            case INT    -> switch (type) {
                case INT    -> new MiniJavaAny(MiniJavaAny.Type.INT, src.value);
                case CHAR   -> new MiniJavaAny(MiniJavaAny.Type.CHAR, src.getChar());
                default     -> throw new RuntimeException("Cannot cast int to " + type);
            };
            case CHAR   -> switch (type) {
                case INT    -> new MiniJavaAny(MiniJavaAny.Type.INT, src.getInt());
                case CHAR   -> new MiniJavaAny(MiniJavaAny.Type.CHAR, src.value);
                default     -> throw new RuntimeException("Cannot cast char to " + type);
            };
            case BOOLEAN    -> throw new RuntimeException("Cannot cast boolean to " + type);
            case STRING     -> throw new RuntimeException("Cannot cast string to " + type);
            default         -> throw new RuntimeException("Unknown type.");
        };
    }

}
