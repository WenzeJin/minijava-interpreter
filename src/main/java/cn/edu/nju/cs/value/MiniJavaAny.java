package cn.edu.nju.cs.value;

import java.util.List;

public class MiniJavaAny implements Cloneable {

    public enum BasicType {
        INT, CHAR, BOOLEAN, STRING, NULL
    }

    String type;
    Object value;
    boolean isVariable;
    boolean isLiteral;

    public MiniJavaAny(String type, Object value) {
        this.type = type;
        this.value = value;
        this.isVariable = false;
        this.isLiteral = false;
    }

    public MiniJavaAny(BasicType type, Object value) {
        this.type = type.toString().toLowerCase();
        this.value = value;
        this.isVariable = false;
        this.isLiteral = false;
    }

    public MiniJavaAny(MiniJavaAny other) {
        this.type = other.type;
        this.value = other.value;
        this.isVariable = false;
        this.isLiteral = false;
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
        if (value == null) {
            return "null";
        } else if (type.equals("string")) {
            return (String) value;
        } else if (type.equals("char")) {
            return String.valueOf((char) (byte) value);
        } else if (type.equals("int")) {
            return String.valueOf((int) value);
        } else if (type.equals("boolean")) {
            return String.valueOf((boolean) value);
        } else if (type.equals("null")) {
            return "null";
        } else if (type.endsWith("[]")) {
            assert value instanceof List;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (Object obj : (List<?>) value) {
                if (obj instanceof MiniJavaAny) {
                    sb.append(((MiniJavaAny) obj).getString()).append(", ");
                } else {
                    assert false : "Invalid type in array: " + obj.getClass();
                }
            }
            if (sb.length() > 1) {
                sb.setLength(sb.length() - 2); // Remove last comma and space
            }
            sb.append("]");
            return sb.toString();
        } else {
            throw new RuntimeException("Cannot convert " + value + " to string.");
        }
    }

    /* Check basic type */

    public boolean isBasicType(BasicType type) {
        return this.type.equals(type.toString().toLowerCase());
    }

    public boolean isBasicType() {
        return isBasicType(BasicType.INT) || isBasicType(BasicType.CHAR) || isBasicType(BasicType.BOOLEAN)
                || isBasicType(BasicType.STRING);
    }

    public boolean isArray() {
        return type.endsWith("[]");
    }

    public boolean isNumber() {
        return isBasicType(BasicType.INT) || isBasicType(BasicType.CHAR);
    }

    public boolean isNull() {
        return isBasicType(BasicType.NULL);
    }


    /* Set values */

    public void initializeDefaultValue() {
        if (type.equals("int")) {
            value = 0;
        } else if (type.equals("char")) {
            value = (byte) 0;
        } else if (type.equals("boolean")) {
            value = false;
        } else if (type.equals("string")) {
            value = "";
        } else if (type.equals("null")) {
            value = null;
        } else {
            value = null;
        }
    }

    public void setValue(Object value) {
        if (this.value != null && value != null && value.getClass() != this.value.getClass()) {
            throw new RuntimeException("Cannot assign value of different type.");
        }
        this.value = value;
    }

    public void assign(MiniJavaAny other) {
        if (other.type.equals("string") && other.type.equals("string")) {
            value = other.getString();
        } else if (other.type.equals("boolean") && this.type.equals("boolean")) {
            value = other.getBoolean();
        } else if ((other.type.equals("int") || other.type.equals("char")) && type.equals("int")) {
            value = other.getInt();
        } else if ((other.type.equals("int") || other.type.equals("char")) && type.equals("char")) {
            value = other.getChar();
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

    public void setLiteral() {
        isLiteral = true;
    }

    public boolean isLiteral() {
        return isLiteral;
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
        return new MiniJavaAny(this);
    }

}
