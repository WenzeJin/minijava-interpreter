package cn.edu.nju.cs.value;

import cn.edu.nju.cs.throwables.TypeError;

/**
 * Utility class for type checking and validation of MiniJavaAny values.
 * Provides methods to verify if a value matches a specific type, if two values
 * have the same type, and if a value is of a numeric type.
 *
 * <p>Methods in this class throw {@link RuntimeException} when type mismatches
 * occur, providing detailed error messages for debugging purposes.</p>
 *
 * <ul>
 *   <li>{@link #isBasicType(MiniJavaAny, MiniJavaAny.BasicType)}: Checks if a value matches a specified basic type.</li>
 *   <li>{@link #isSameType(MiniJavaAny, MiniJavaAny)}: Verifies if two values have the same type.</li>
 *   <li>{@link #assertNumber(MiniJavaAny)}: Ensures a value is of a numeric type (int or char).</li>
 * </ul>
 */
public class TypeUtils {

    /**
     * Checks if the given value is of the specified basic type.
     * If the value matches the specified type, the method returns true.
     * Otherwise, it throws a RuntimeException indicating a type mismatch.
     *
     * @param value The value to be checked.
     * @param type The expected basic type of the value.
     * @return true if the value is of the specified basic type.
     * @throws TypeError if the value's type does not match the specified type.
     */
    public static boolean isBasicType(MiniJavaAny value, MiniJavaAny.BasicType type) {
        if (value.isBasicType(type)) {
            return true;
        } else {
            throw new TypeError("Type mismatch. Requires " + type + ", but got " + value.getType() + ".");
        }
    }

    /**
     * Checks if two MiniJavaAny values have the same type.
     *
     * @param value1 The first MiniJavaAny value to compare.
     * @param value2 The second MiniJavaAny value to compare.
     * @return {@code true} if both values have the same type.
     * @throws TypeError if the types of the two values do not match.
     *         The exception message includes the expected type and the actual type.
     */
    public static boolean isSameType(MiniJavaAny value1, MiniJavaAny value2) {
        if (value1.getType().equals(value2.getType())) {
            return true;
        } else {
            throw new TypeError(
                    "Type mismatch. Requires " + value1.getType() + ", but got " + value2.getType() + ".");
        }
    }
    
    /**
     * Asserts that the given value is of a numeric type (int or char).
     * If the value is not a number, this method throws a {@link RuntimeException}
     * with a descriptive error message indicating the type mismatch.
     *
     * @param value the {@link MiniJavaAny} value to be checked
     * @throws TypeError if the value is not a number
     */
    public static void assertNumber(MiniJavaAny value) {
        if (!value.isNumber()) {
            throw new TypeError("Type mismatch. Requires number (int / char), but got " + value.getType() + ".");
        }
    }

    public static void assertArray(MiniJavaAny value) {
        if (!value.isArray()) {
            throw new TypeError("Type mismatch. Requires array, but got " + value.getType() + ".");
        }
    }

    private static boolean inCharRange(int value) {
        return Byte.MIN_VALUE <= value && value <= Byte.MAX_VALUE;
    }

    public static boolean canCastIntToChar(MiniJavaAny value) {
        return value.isBasicType(MiniJavaAny.BasicType.INT) && inCharRange(value.getInt()) && value.isLiteral();
    }

    public static boolean canCastImplicit(String from, String to) {
        if (from.equals(to)) {
            return true;
        }
        if (from.equals("char") && to.equals("int")) {
            return true;
        }
        if (from.equals("null")) {
            String[] types = { "int", "char", "boolean", "string" };
            for (var type : types) {
                if (type.equals(to)) {
                    return false;
                }
            }
            return true;
        }
        if (to.equals("void")) {
            // void means any type
            return true;
        }
        return false;
    }
}
