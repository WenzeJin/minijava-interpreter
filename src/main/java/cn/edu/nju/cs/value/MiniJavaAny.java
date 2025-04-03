package cn.edu.nju.cs.value;


public class MiniJavaAny implements Cloneable {

    public enum BasicType {
        INT, CHAR, BOOLEAN, STRING, NULL
    }

    String type;
    Object value;
    boolean isVariable;

    public MiniJavaAny(String type, Object value) {
        this.type = type;
        this.value = value;
        this.isVariable = false;
    }

    public MiniJavaAny(BasicType type, Object value) {
        this.type = type.toString().toLowerCase();
        this.value = value;
        this.isVariable = false;
    }

    public String getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    /* Get values of basic types */

    public int getInt() {
        if (type.equals("int")) {
            return (int) value;
        } else if (type.equals("char")) {
            return (byte) value;
        } else {
            throw new RuntimeException("Cannot convert " + value + " to int.");
        }
    }

    public byte getChar() {
        if (type.equals("int")) {
            return (byte) (int) value;
        } else if (type.equals("char")) {
            return (byte) value;
        } else {
            throw new RuntimeException("Cannot convert " + value + " to char.");
        }
    }

    public boolean getBoolean() {
        if (type.equals("boolean")) {
            return (boolean) value;
        } else {
            throw new RuntimeException("Cannot convert " + value + " to boolean.");
        }
    }

    public String getString() {
        if (type.equals("string")) {
            return (String) value;
        } else if (type.equals("char")) {
            return String.valueOf((char) (byte) value);
        } else {
            return String.valueOf(value);
        }
    }

    /* Check basic type */

    public boolean isBasicType(BasicType type) {
        return this.type.equals(type.toString().toLowerCase());
    }

    public boolean isNumber() {
        return isBasicType(BasicType.INT) || isBasicType(BasicType.CHAR);
    }

    public boolean isNull() {
        return isBasicType(BasicType.NULL);
    }
    

    /* Set values */

    public void setValue(Object value) {
        if (value.getClass() != this.value.getClass()) {
            throw new RuntimeException("Cannot assign value of different type.");
        }
        this.value = value;
    }

    public void setIntVal(int value) {
        if (type.equals("int")) {
            this.value = value;
        } else if (type.equals("char")) {
            this.value = (byte) value;
        }
    }

    public void assign(MiniJavaAny other) {
        if (other.type.equals("string") && other.type.equals("string")) {
            value = other.value;
        } else if (other.type.equals("boolean") && this.type.equals("boolean")) {
            value = other.value;
        } else if ((other.type.equals("int") || other.type.equals("char"))
                && (type.equals("int")|| type.equals("char"))) {
            setIntVal(other.getInt());
        } else {
            setValue(other.getValue());
        }
    }

    public void increment() {
        if (type.equals("int")) {
            value = (int) value + 1;
        } else if (type.equals("char")) {
            value = (byte)((byte) value + 1);
        } else {
            throw new RuntimeException("Cannot increment " + type);
        }
    }

    public void decrement() {
        if (type.equals("int")) {
            value = (int) value - 1;
        } else if (type.equals("char")) {
            value = (byte) ((byte) value - 1);
        } else {
            throw new RuntimeException("Cannot decrement " + type);
        }
    }
    
    /*
     Methods to make this value a variable.
     A variable is a value that can be changed.
     A variable is stored in the environment.
     */

    public void setVariable() {
        isVariable = true;
    }

    public boolean isVariable() {
        return isVariable;
    }


    /* Override methods */

    @Override
    public String toString() {
        String typeStr = type.toString().toLowerCase();
        Object value = type.equals("char") ? (char)(byte) this.value : this.value;
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
