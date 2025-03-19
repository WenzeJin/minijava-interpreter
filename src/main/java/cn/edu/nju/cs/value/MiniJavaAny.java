package cn.edu.nju.cs.value;


public class MiniJavaAny implements Cloneable {

    public enum Type {
        INT, CHAR, BOOLEAN, STRING
    }

    Type type;
    Object value;
    boolean isVariable;

    public MiniJavaAny(Type type, Object value) {
        this.type = type;
        this.value = value;
        this.isVariable = false;
    }

    public Type getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public int getInt() {
        if (type == Type.INT) {
            return (int) value;
        } else if (type == Type.CHAR) {
            return (byte) value;
        } else {
            throw new RuntimeException("Cannot convert " + value + " to int.");
        }
    }

    public byte getChar() {
        if (type == Type.INT) {
            return (byte) (int) value;
        } else if (type == Type.CHAR) {
            return (byte) value;
        } else {
            throw new RuntimeException("Cannot convert " + value + " to char.");
        }
    }

    public boolean getBoolean() {
        if (type == Type.BOOLEAN) {
            return (boolean) value;
        } else {
            throw new RuntimeException("Cannot convert " + value + " to boolean.");
        }
    }

    public String getString() {
        if (type == Type.STRING) {
            return (String) value;
        } else if (type == Type.CHAR) {
            return String.valueOf((char) (byte) value);
        } else {
            return String.valueOf(value);
        }
    }

    public void setValue(Object value) {
        if (value.getClass() != this.value.getClass()) {
            throw new RuntimeException("Cannot assign value of different type.");
        }
        this.value = value;
    }

    public void setIntVal(int value) {
        if (type == Type.INT) {
            this.value = value;
        } else if (type == Type.CHAR) {
            this.value = (byte) value;
        }
    }

    public void assign(MiniJavaAny other) {
        if (other.type == Type.STRING && this.type == Type.STRING) {
            value = other.value;
        } else if (other.type == Type.BOOLEAN && this.type == Type.BOOLEAN) {
            value = other.value;
        } else if ((other.type == Type.INT || other.type == Type.CHAR)
        && (type == Type.INT || type == Type.CHAR)) {
            setIntVal(other.getInt());
        }
    }

    public void increment() {
        if (type == Type.INT) {
            value = (int) value + 1;
        } else if (type == Type.CHAR) {
            value = (byte)((byte) value + 1);
        } else {
            throw new RuntimeException("Cannot increment " + type);
        }
    }

    public void decrement() {
        if (type == Type.INT) {
            value = (int) value - 1;
        } else if (type == Type.CHAR) {
            value = (byte)((byte) value - 1);
        } else {
            throw new RuntimeException("Cannot decrement " + type);
        }
    }

    public void setVariable() {
        isVariable = true;
    }

    public boolean isVariable() {
        return isVariable;
    }

    @Override
    public String toString() {
        String typeStr = type.toString().toLowerCase();
        Object value = type == Type.CHAR ? (char)(byte) this.value : this.value;
        return "(" + typeStr + ") " + value;
    }

    @Override
    public int hashCode() {
        return type.hashCode() + value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MiniJavaAny other) {
            if (this == other) {
                return true;
            }
            return type.equals(other.type) && value.equals(other.value);
        }
        return false;
    }

    @Override
    public MiniJavaAny clone() {
        return new MiniJavaAny(type, value);
    }

}
