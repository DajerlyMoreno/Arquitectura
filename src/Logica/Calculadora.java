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

    public int operadorADecimal(String op1) {
        return Operaciones.fromBinaryString(op1);
    }

    public String operadorABinario(int num) {
        return Operaciones.toBinaryString(num, Operaciones.BITS);
    }

    public String operadorAB(String num){
        return Operaciones.toBinaryS(num, Operaciones.BITS);
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
        resultadoBinario = String.format("%32s", Long.toBinaryString(resultado)).replace(' ', '0');
        resultadoDecimal = (int) resultado;  // Simplificación para propósitos de este ejemplo
    }

    public void dividir() {
        int[] resultado = Operaciones.divide(operando1, operando2);
        resultadoDecimal = resultado[0];
        resultadoBinario = Operaciones.toBinaryString(resultadoDecimal, Operaciones.BITS);
    }

    public void desplazarIzquierda() {
        resultadoDecimal = Operaciones.leftShift(resultadoDecimal);
        resultadoBinario = Operaciones.toBinaryString(resultadoDecimal, Operaciones.BITS);
    }

    public void desplazarDerecha() {
        resultadoDecimal = Operaciones.rightShift(resultadoDecimal);
        resultadoBinario = Operaciones.toBinaryString(resultadoDecimal, Operaciones.BITS);
    }

    public void extensionDeCeros() {
        operando1 = Operaciones.zeroExtend(operando1, Operaciones.BITS);
        operando2 = Operaciones.zeroExtend(operando2, Operaciones.BITS);
    }

    public void extensionDeSigno() {
        operando1 = Operaciones.signExtend(operando1, Operaciones.BITS);
        operando2 = Operaciones.signExtend(operando2, Operaciones.BITS);
    }

    public String getResultadoBinario() {
        return resultadoBinario;
    }

    public int getResultadoDecimal() {
        return resultadoDecimal;
    }

    public int getOperando1() {
        return operando1;
    }

    public int getOperando2() {
        return operando2;
    }
}