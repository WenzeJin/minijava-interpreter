package cn.edu.nju.cs.value;

import cn.edu.nju.cs.value.MiniJavaAny.BasicType;

public class CalcUtils {

    public static MiniJavaAny add(MiniJavaAny a, MiniJavaAny b) {
        if (a.isBasicType(BasicType.STRING)|| b.isBasicType(BasicType.STRING)) {
            return new MiniJavaAny(BasicType.STRING, a.getString() + b.getString());
        } else {
            TypeUtils.assertNumber(a);
            TypeUtils.assertNumber(b);
            return new MiniJavaAny(BasicType.INT, a.getInt() + b.getInt());
        }
    }

    public static MiniJavaAny sub(MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.assertNumber(a);
        TypeUtils.assertNumber(b);
        return new MiniJavaAny(BasicType.INT, a.getInt() - b.getInt());
    }

    public static MiniJavaAny mul(MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.assertNumber(a);
        TypeUtils.assertNumber(b);
        return new MiniJavaAny(BasicType.INT, a.getInt() * b.getInt());
    }

    public static MiniJavaAny div(MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.assertNumber(a);
        TypeUtils.assertNumber(b);
        return new MiniJavaAny(BasicType.INT, a.getInt() / b.getInt());
    }

    public static MiniJavaAny mod(MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.assertNumber(a);
        TypeUtils.assertNumber(b);
        return new MiniJavaAny(BasicType.INT, a.getInt() % b.getInt());
    }

    public static MiniJavaAny shiftLeft(MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.assertNumber(a);
        TypeUtils.assertNumber(b);
        return new MiniJavaAny(BasicType.INT, a.getInt() << b.getInt());
    }

    public static MiniJavaAny shiftRight(MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.assertNumber(a);
        TypeUtils.assertNumber(b);
        return new MiniJavaAny(BasicType.INT, a.getInt() >> b.getInt());
    }

    public static MiniJavaAny unsignedShiftRight(MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.assertNumber(a);
        TypeUtils.assertNumber(b);
        return new MiniJavaAny(BasicType.INT, a.getInt() >>> b.getInt());
    }

    public static MiniJavaAny leq (MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.assertNumber(a);
        TypeUtils.assertNumber(b);
        return new MiniJavaAny(BasicType.BOOLEAN, a.getInt() <= b.getInt());
    }

    public static MiniJavaAny geq (MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.assertNumber(a);
        TypeUtils.assertNumber(b);
        return new MiniJavaAny(BasicType.BOOLEAN, a.getInt() >= b.getInt());
    }

    public static MiniJavaAny lt (MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.assertNumber(a);
        TypeUtils.assertNumber(b);
        return new MiniJavaAny(BasicType.BOOLEAN, a.getInt() < b.getInt());
    }

    public static MiniJavaAny gt (MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.assertNumber(a);
        TypeUtils.assertNumber(b);
        return new MiniJavaAny(BasicType.BOOLEAN, a.getInt() > b.getInt());
    }

    public static MiniJavaAny eq (MiniJavaAny a, MiniJavaAny b) {
        if (a.isBasicType(BasicType.STRING) && b.isBasicType(BasicType.STRING)) {
            return new MiniJavaAny(BasicType.BOOLEAN, a.getString().equals(b.getString()));
        } if (a.isBasicType(BasicType.BOOLEAN) && b.isBasicType(BasicType.BOOLEAN)) {
            return new MiniJavaAny(BasicType.BOOLEAN, a.getBoolean() == b.getBoolean());
        } else {
            return new MiniJavaAny(BasicType.BOOLEAN, a.getInt() == b.getInt());
        }
    }

    public static MiniJavaAny neq (MiniJavaAny a, MiniJavaAny b) {
        if (a.isBasicType(BasicType.STRING) && b.isBasicType(BasicType.STRING)) {
            return new MiniJavaAny(BasicType.BOOLEAN, !a.getString().equals(b.getString()));
        } if (a.isBasicType(BasicType.BOOLEAN) && b.isBasicType(BasicType.BOOLEAN)) {
            return new MiniJavaAny(BasicType.BOOLEAN, a.getBoolean() != b.getBoolean());
        } else {
            return new MiniJavaAny(BasicType.BOOLEAN, a.getInt() != b.getInt());
        }
    }

    public static MiniJavaAny bitAnd (MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.assertNumber(a);
        TypeUtils.assertNumber(b);
        return new MiniJavaAny(BasicType.INT, a.getInt() & b.getInt());
    }

    public static MiniJavaAny bitXor (MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.assertNumber(a);
        TypeUtils.assertNumber(b);
        return new MiniJavaAny(BasicType.INT, a.getInt() ^ b.getInt());
    }

    public static MiniJavaAny bitOr (MiniJavaAny a, MiniJavaAny b) {
        TypeUtils.assertNumber(a);
        TypeUtils.assertNumber(b);
        return new MiniJavaAny(BasicType.INT, a.getInt() | b.getInt());
    }



}
