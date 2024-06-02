package Logica;

public class Operaciones {
    public static final int BITS = 16;
    public static final int MAX_VALUE = (1 << (BITS - 1)) - 1;
    public static final int MIN_VALUE = -(1 << (BITS - 1));

    public static String toBinaryString(int num, int bits) {
        String binario = Integer.toBinaryString(num);
        if (num >= 0) {
            // Si el número es positivo, añadir ceros a la izquierda
            while (binario.length() < bits) {
                binario = "0" + binario;
            }
        } else {
            // Si el número es negativo, añadir unos a la izquierda para completar el tamaño de bits
            binario = binario.substring(binario.length() - bits);
        }
        return binario;
    }
    

    public static int fromBinaryString(String binary) {
        if (binary.charAt(0) == '1') { 
            return -((1 << (binary.length() - 1)) - Integer.parseInt(binary.substring(1), 2));
        } else {  
            return Integer.parseInt(binary, 2);
        }
    }
    

    public static int add(int a, int b) throws ArithmeticException {
        int result = a + b;
        if (result > MAX_VALUE || result < MIN_VALUE) {
            throw new ArithmeticException("Sobreflujo  " + MAX_VALUE + MIN_VALUE);
        }
        return result;
    }

    public static int subtract(int a, int b) throws ArithmeticException {
        int result = a - b;
        if (result > MAX_VALUE || result < MIN_VALUE) {
            throw new ArithmeticException("Sobreflujo");
        }
        return result;
    }

    public static long multiply(int a, int b) {
        return (long) a * b;
    }

    public static int[] divide(int a, int b) {
        int quotient = a / b;
        int remainder = a % b;
        return new int[]{quotient, remainder};
    }

    public static int leftShift(int a) {
        return a << 1;
    }

    public static int rightShift(int a) {
        return a >> 1;
    }

    public static int zeroExtend(int num, int bits) {
        return num << bits; 
    }

    public static int signExtend(int num, int bits) {
        return num & ((1 << bits) - 1); 
    }
}
