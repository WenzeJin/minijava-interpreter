package cn.edu.nju.cs.env;

import cn.edu.nju.cs.value.TypeUtils;

public class MethodSignature {

    final private String methodName;
    final private String returnType;
    final private String[] parameterTypes;

    public MethodSignature(String methodName, String returnType, String[] parameterTypes) {
        this.methodName = methodName;
        this.returnType = returnType;
        this.parameterTypes = parameterTypes;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getReturnType() {
        return returnType;
    }

    public String[] getParameterTypes() {
        return parameterTypes;
    }


    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        MethodSignature that = (MethodSignature) obj;

        if (!methodName.equals(that.methodName))
            return false;
        if (!returnType.equals(that.returnType))
            return false;
        if (parameterTypes.length != that.parameterTypes.length)
            return false;

        for (int i = 0; i < parameterTypes.length; i++) {
            if (!parameterTypes[i].equals(that.parameterTypes[i])) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Checks if this method signature can be called with the given method signature.
     * 
     * @param other the other method signature to compare with
     * @return 0 if the method signatures are identical, positive integer (cost) if the other method signature can be called with this one by implicit casting, -1 if they are incompatible
     */
    public int canBeCalled(MethodSignature other) {
        int cost = 0;
        if (!this.methodName.equals(other.methodName)) {
            return -1;
        }
        if (this.parameterTypes.length != other.parameterTypes.length) {
            return -1;
        }
        for (int i = 0; i < this.parameterTypes.length; i++) {
            if (this.parameterTypes[i].equals(other.parameterTypes[i])) {
                continue;
            } else if (TypeUtils.canCastImplicit(other.parameterTypes[i], this.parameterTypes[i])) {
                cost++;
            } else {
                return -1;
            }
        }
        return cost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(returnType).append(" ").append(methodName).append("(");
        for (int i = 0; i < parameterTypes.length; i++) {
            sb.append(parameterTypes[i]);
            if (i < parameterTypes.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = methodName.hashCode();
        result = 31 * result + returnType.hashCode();
        for (String paramType : parameterTypes) {
            result = 31 * result + paramType.hashCode();
        }
        return result;
    }

}
