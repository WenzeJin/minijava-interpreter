package cn.edu.nju.cs.value;


public class CalcUtils {

    public static MiniJavaAny add(MiniJavaAny a, MiniJavaAny b) {
        if (a.getType() == MiniJavaAny.Type.STRING || b.getType() == MiniJavaAny.Type.STRING) {
            return new MiniJavaAny(MiniJavaAny.Type.STRING, a.getValue().toString() + b.getValue().toString());
        } else  {
            return new MiniJavaAny(MiniJavaAny.Type.INT, a.getInt() + b.getInt());
        }
    }

    public static MiniJavaAny sub(MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.isTypes(a, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        TypeUtils.isTypes(b, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        return new MiniJavaAny(MiniJavaAny.Type.INT, a.getInt() - b.getInt());
    }

    public static MiniJavaAny mul(MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.isTypes(a, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        TypeUtils.isTypes(b, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        return new MiniJavaAny(MiniJavaAny.Type.INT, a.getInt() * b.getInt());
    }

    public static MiniJavaAny div(MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.isTypes(a, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        TypeUtils.isTypes(b, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        return new MiniJavaAny(MiniJavaAny.Type.INT, a.getInt() / b.getInt());
    }

    public static MiniJavaAny mod(MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.isTypes(a, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        TypeUtils.isTypes(b, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        return new MiniJavaAny(MiniJavaAny.Type.INT, a.getInt() % b.getInt());
    }

    public static MiniJavaAny shiftLeft(MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.isTypes(a, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        TypeUtils.isTypes(b, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        return new MiniJavaAny(MiniJavaAny.Type.INT, a.getInt() << b.getInt());
    }

    public static MiniJavaAny shiftRight(MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.isTypes(a, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        TypeUtils.isTypes(b, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        return new MiniJavaAny(MiniJavaAny.Type.INT, a.getInt() >> b.getInt());
    }

    public static MiniJavaAny unsignedShiftRight(MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.isTypes(a, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        TypeUtils.isTypes(b, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        return new MiniJavaAny(MiniJavaAny.Type.INT, a.getInt() >>> b.getInt());
    }

    public static MiniJavaAny leq (MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.isTypes(a, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        TypeUtils.isTypes(b, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        return new MiniJavaAny(MiniJavaAny.Type.BOOLEAN, a.getInt() <= b.getInt());
    }

    public static MiniJavaAny geq (MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.isTypes(a, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        TypeUtils.isTypes(b, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        return new MiniJavaAny(MiniJavaAny.Type.BOOLEAN, a.getInt() >= b.getInt());
    }

    public static MiniJavaAny lt (MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.isTypes(a, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        TypeUtils.isTypes(b, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        return new MiniJavaAny(MiniJavaAny.Type.BOOLEAN, a.getInt() < b.getInt());
    }

    public static MiniJavaAny gt (MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.isTypes(a, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        TypeUtils.isTypes(b, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        return new MiniJavaAny(MiniJavaAny.Type.BOOLEAN, a.getInt() > b.getInt());
    }

    public static MiniJavaAny eq (MiniJavaAny a, MiniJavaAny b) {
        return new MiniJavaAny(MiniJavaAny.Type.BOOLEAN, a.getValue().equals(b.getValue()));
    }

    public static MiniJavaAny neq (MiniJavaAny a, MiniJavaAny b) {
        return new MiniJavaAny(MiniJavaAny.Type.BOOLEAN, !a.getValue().equals(b.getValue()));
    }

    public static MiniJavaAny bitAnd (MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.isTypes(a, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        TypeUtils.isTypes(b, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        return new MiniJavaAny(MiniJavaAny.Type.INT, a.getInt() & b.getInt());
    }

    public static MiniJavaAny bitXor (MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.isTypes(a, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        TypeUtils.isTypes(b, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        return new MiniJavaAny(MiniJavaAny.Type.INT, a.getInt() ^ b.getInt());
    }

    public static MiniJavaAny bitOr (MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.isTypes(a, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        TypeUtils.isTypes(b, MiniJavaAny.Type.INT, MiniJavaAny.Type.CHAR);
        return new MiniJavaAny(MiniJavaAny.Type.INT, a.getInt() | b.getInt());
    }

    public static MiniJavaAny and (MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.isType(a, MiniJavaAny.Type.BOOLEAN);
        TypeUtils.isType(b, MiniJavaAny.Type.BOOLEAN);
        return new MiniJavaAny(MiniJavaAny.Type.BOOLEAN, a.getBoolean() && b.getBoolean());
    }

    public static MiniJavaAny or (MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.isType(a, MiniJavaAny.Type.BOOLEAN);
        TypeUtils.isType(b, MiniJavaAny.Type.BOOLEAN);
        return new MiniJavaAny(MiniJavaAny.Type.BOOLEAN, a.getBoolean() || b.getBoolean());
    }



}
