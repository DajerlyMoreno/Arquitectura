package Logica;

public class Operaciones {
    public static final int BITS = 16;
    public static final int MAX_VALUE = (1 << (BITS - 1)) - 1;
    public static final int MIN_VALUE = -(1 << (BITS - 1));

    public static String toBinaryString(int value, int bits) {
        String binary = Integer.toBinaryString(value);
        if (value >= 0) {
            return String.format("%" + bits + "s", binary).replace(' ', '0');
        } else {
            return binary.substring(binary.length() - bits);
        }
    }

    public static int fromBinaryString(String binary) {
        return (int) Long.parseLong(binary, 2);
    }

    public static int add(int a, int b) throws ArithmeticException {
        int result = a + b;
        if (result > MAX_VALUE || result < MIN_VALUE) {
            throw new ArithmeticException("Overflow");
        }
        return result;
    }

    public static int subtract(int a, int b) throws ArithmeticException {
        int result = a - b;
        if (result > MAX_VALUE || result < MIN_VALUE) {
            throw new ArithmeticException("Overflow");
        }
        return result;
    }

    public static long multiply(int a, int b) {
        return (long) a * b;
    }

    public static int[] divide(int a, int b) {
        int quotient = a / b;
        int remainder = a % b;
        return new int[] { quotient, remainder };
    }

    public static int leftShift(int a) {
        return a << 1;
    }

    public static int rightShift(int a) {
        return a >> 1;
    }

    public static int zeroExtend(int a, int bits) {
        return a & ((1 << bits) - 1);
    }

    public static int signExtend(int a, int bits) {
        int signBit = 1 << (bits - 1);
        return (a & (signBit - 1)) - (a & signBit);
    }
}
