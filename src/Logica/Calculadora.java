package Logica;

public class Calculadora {
    private int operando1;
    private int operando2;
    private String resultadoBinario;
    private int resultadoDecimal;

    public void setOperando1(int operando1) {
        this.operando1 = operando1;
    }

    public void setOperando2(int operando2) {
        this.operando2 = operando2;
    }

    public void sumar() throws ArithmeticException {
        resultadoDecimal = Operaciones.add(operando1, operando2);
        resultadoBinario = Operaciones.toBinaryString(resultadoDecimal, Operaciones.BITS);
    }

    public void restar() throws ArithmeticException {
        resultadoDecimal = Operaciones.subtract(operando1, operando2);
        resultadoBinario = Operaciones.toBinaryString(resultadoDecimal, Operaciones.BITS);
    }

    public void multiplicar() {
        long resultado = Operaciones.multiply(operando1, operando2);
        resultadoBinario = Long.toBinaryString(resultado);
        resultadoDecimal = (int) resultado;  // Simplificación para propósitos de este ejemplo
    }

    public void dividir() {
        int[] resultado = Operaciones.divide(operando1, operando2);
        resultadoDecimal = resultado[0];
        resultadoBinario = Operaciones.toBinaryString(resultadoDecimal, Operaciones.BITS);
    }

    public void desplazarIzquierda() {
        resultadoDecimal = Operaciones.leftShift(operando1);
        resultadoBinario = Operaciones.toBinaryString(resultadoDecimal, Operaciones.BITS);
    }

    public void desplazarDerecha() {
        resultadoDecimal = Operaciones.rightShift(operando1);
        resultadoBinario = Operaciones.toBinaryString(resultadoDecimal, Operaciones.BITS);
    }

    public void extensionDeCeros() {
        resultadoDecimal = Operaciones.zeroExtend(operando1, Operaciones.BITS);
        resultadoBinario = Operaciones.toBinaryString(resultadoDecimal, Operaciones.BITS);
    }

    public void extensionDeSigno() {
        resultadoDecimal = Operaciones.signExtend(operando1, Operaciones.BITS);
        resultadoBinario = Operaciones.toBinaryString(resultadoDecimal, Operaciones.BITS);
    }

    public String getResultadoBinario() {
        return resultadoBinario;
    }

    public int getResultadoDecimal() {
        return resultadoDecimal;
    }
}
