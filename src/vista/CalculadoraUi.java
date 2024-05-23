package vista;

import javax.swing.*;

import Logica.Calculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraUi {
    private JFrame frame;
    private JTextField textOperando1;
    private JTextField textOperando2;
    private JTextField textResultadoDecimal;
    private JTextField textResultadoBinario;
    private Calculadora calculadora;

    public JFrame getFrame() {
        return frame;
    }

    public CalculadoraUi() {
        calculadora = new Calculadora();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Calculadora Básica");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblOperando1 = new JLabel("Operando 1");
        lblOperando1.setBounds(10, 11, 86, 14);
        frame.getContentPane().add(lblOperando1);

        textOperando1 = new JTextField();
        textOperando1.setBounds(106, 8, 86, 20);
        frame.getContentPane().add(textOperando1);
        textOperando1.setColumns(10);

        JLabel lblOperando2 = new JLabel("Operando 2");
        lblOperando2.setBounds(10, 36, 86, 14);
        frame.getContentPane().add(lblOperando2);

        textOperando2 = new JTextField();
        textOperando2.setBounds(106, 33, 86, 20);
        frame.getContentPane().add(textOperando2);
        textOperando2.setColumns(10);

        JLabel lblResultadoDecimal = new JLabel("Resultado Decimal");
        lblResultadoDecimal.setBounds(10, 86, 113, 14);
        frame.getContentPane().add(lblResultadoDecimal);

        textResultadoDecimal = new JTextField();
        textResultadoDecimal.setBounds(133, 83, 86, 20);
        frame.getContentPane().add(textResultadoDecimal);
        textResultadoDecimal.setColumns(10);

        JLabel lblResultadoBinario = new JLabel("Resultado Binario");
        lblResultadoBinario.setBounds(10, 111, 113, 14);
        frame.getContentPane().add(lblResultadoBinario);

        textResultadoBinario = new JTextField();
        textResultadoBinario.setBounds(133, 108, 161, 20);
        frame.getContentPane().add(textResultadoBinario);
        textResultadoBinario.setColumns(10);

        JButton btnSumar = new JButton("Sumar");
        btnSumar.setBounds(202, 7, 89, 23);
        btnSumar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("sumar");
            }
        });
        frame.getContentPane().add(btnSumar);

        JButton btnRestar = new JButton("Restar");
        btnRestar.setBounds(202, 32, 89, 23);
        btnRestar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("restar");
            }
        });
        frame.getContentPane().add(btnRestar);

        JButton btnMultiplicar = new JButton("Multiplicar");
        btnMultiplicar.setBounds(301, 7, 123, 23);
        btnMultiplicar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("multiplicar");
            }
        });
        frame.getContentPane().add(btnMultiplicar);

        JButton btnDividir = new JButton("Dividir");
        btnDividir.setBounds(301, 32, 123, 23);
        btnDividir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("dividir");
            }
        });
        frame.getContentPane().add(btnDividir);

        JButton btnDesplazarIzq = new JButton("Desplazar Izq");
        btnDesplazarIzq.setBounds(10, 136, 150, 23);
        btnDesplazarIzq.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("desplazarIzquierda");
            }
        });
        frame.getContentPane().add(btnDesplazarIzq);

        JButton btnDesplazarDer = new JButton("Desplazar Der");
        btnDesplazarDer.setBounds(170, 136, 150, 23);
        btnDesplazarDer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("desplazarDerecha");
            }
        });
        frame.getContentPane().add(btnDesplazarDer);
    }

    private void realizarOperacion(String operacion) {
        try {
            int operando1 = Integer.parseInt(textOperando1.getText());
            int operando2 = Integer.parseInt(textOperando2.getText());
            calculadora.setOperando1(operando1);
            calculadora.setOperando2(operando2);

            switch (operacion) {
                case "sumar":
                    calculadora.sumar();
                    break;
                case "restar":
                    calculadora.restar();
                    break;
                case "multiplicar":
                    calculadora.multiplicar();
                    break;
                case "dividir":
                    calculadora.dividir();
                    break;
                case "desplazarIzquierda":
                    calculadora.desplazarIzquierda();
                    break;
                case "desplazarDerecha":
                    calculadora.desplazarDerecha();
                    break;
            }

            textResultadoDecimal.setText(String.valueOf(calculadora.getResultadoDecimal()));
            textResultadoBinario.setText(calculadora.getResultadoBinario());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Por favor, ingrese números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
