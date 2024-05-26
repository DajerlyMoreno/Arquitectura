package vista;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import Logica.Calculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CalculadoraUi {
    private JFrame frame;
    private JTextField textOperando1;
    private JTextField textOperando2;
    private JTextField textResultadoDecimal;
    private JTextField textResultadoBinario;
    private Calculadora calculadora;
    private JComboBox<String> comboBoxModo;

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
        frame.setLocationRelativeTo(null);

        

        JLabel lblOperando1 = new JLabel("Operando 1");
        lblOperando1.setBounds(10, 40, 86, 14);
        frame.getContentPane().add(lblOperando1);

        textOperando1 = new JTextField();
        textOperando1.setBounds(106, 37, 86, 20);
        frame.getContentPane().add(textOperando1);
        textOperando1.setColumns(10);

        JLabel lblOperando2 = new JLabel("Operando 2");
        lblOperando2.setBounds(10, 65, 86, 14);
        frame.getContentPane().add(lblOperando2);

        textOperando2 = new JTextField();
        textOperando2.setBounds(106, 62, 86, 20);
        frame.getContentPane().add(textOperando2);
        textOperando2.setColumns(10);

        JLabel lblResultadoDecimal = new JLabel("Resultado Decimal");
        lblResultadoDecimal.setBounds(10, 115, 113, 14);
        frame.getContentPane().add(lblResultadoDecimal);

        textResultadoDecimal = new JTextField();
        textResultadoDecimal.setBounds(133, 112, 86, 20);
        frame.getContentPane().add(textResultadoDecimal);
        textResultadoDecimal.setColumns(10);

        JLabel lblResultadoBinario = new JLabel("Resultado Binario");
        lblResultadoBinario.setBounds(10, 140, 113, 14);
        frame.getContentPane().add(lblResultadoBinario);

        textResultadoBinario = new JTextField();
        textResultadoBinario.setBounds(133, 137, 161, 20);
        frame.getContentPane().add(textResultadoBinario);
        textResultadoBinario.setColumns(10);

        JLabel lblModo = new JLabel("Modo de Entrada");
        lblModo.setBounds(10, 11, 113, 14);
        frame.getContentPane().add(lblModo);

        comboBoxModo = new JComboBox<>(new String[]{"Decimal", "Binario"});
        comboBoxModo.setBounds(133, 8, 113, 22);
        comboBoxModo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedMode = (String) e.getItem();
                    setDocumentFilter(selectedMode.equals("Binario"));
                }
            }
        });
        frame.getContentPane().add(comboBoxModo);

        JButton btnSumar = new JButton("Sumar");
        btnSumar.setBounds(202, 36, 89, 23);
        btnSumar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("sumar");
            }
        });
        frame.getContentPane().add(btnSumar);

        JButton btnRestar = new JButton("Restar");
        btnRestar.setBounds(202, 61, 89, 23);
        btnRestar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("restar");
            }
        });
        frame.getContentPane().add(btnRestar);

        JButton btnMultiplicar = new JButton("Multiplicar");
        btnMultiplicar.setBounds(301, 36, 123, 23);
        btnMultiplicar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("multiplicar");
            }
        });
        frame.getContentPane().add(btnMultiplicar);

        JButton btnDividir = new JButton("Dividir");
        btnDividir.setBounds(301, 61, 123, 23);
        btnDividir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("dividir");
            }
        });
        frame.getContentPane().add(btnDividir);

        JButton btnDesplazarIzq = new JButton("Desplazar Izq");
        btnDesplazarIzq.setBounds(10, 165, 150, 23);
        btnDesplazarIzq.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("desplazarIzquierda");
            }
        });
        frame.getContentPane().add(btnDesplazarIzq);

        JButton btnDesplazarDer = new JButton("Desplazar Der");
        btnDesplazarDer.setBounds(170, 165, 150, 23);
        btnDesplazarDer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("desplazarDerecha");
            }
        });
        frame.getContentPane().add(btnDesplazarDer);

        JButton btnExtenderCeros = new JButton("Extensión de Ceros");
        btnExtenderCeros.setBounds(10, 200, 150, 23);
        btnExtenderCeros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("extensionDeCeros");
            }
        });
        frame.getContentPane().add(btnExtenderCeros);

        JButton btnExtenderSigno = new JButton("Extensión de Signo");
        btnExtenderSigno.setBounds(170, 200, 150, 23);
        btnExtenderSigno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("extensionDeSigno");
            }
        });
        frame.getContentPane().add(btnExtenderSigno);
    }

    private void setDocumentFilter(boolean isBinary) {
        DocumentFilter filter = isBinary ? new BinaryDocumentFilter() : new DecimalDocumentFilter();
        ((AbstractDocument) textOperando1.getDocument()).setDocumentFilter(filter);
        ((AbstractDocument) textOperando2.getDocument()).setDocumentFilter(filter);
    }

    private void realizarOperacion(String operacion) {
        try {
            int operando1 = comboBoxModo.getSelectedItem().equals("Binario") ? Integer.parseInt(textOperando1.getText(), 2) : Integer.parseInt(textOperando1.getText());
            int operando2 = 0;
            if (!operacion.equals("extensionDeCeros") && !operacion.equals("extensionDeSigno")) {
                operando2 = comboBoxModo.getSelectedItem().equals("Binario") ? Integer.parseInt(textOperando2.getText(), 2) : Integer.parseInt(textOperando2.getText());
            }
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
                case "extensionDeCeros":
                    calculadora.extensionDeCeros();
                    break;
                case "extensionDeSigno":
                    calculadora.extensionDeSigno();
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

    class BinaryDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
            if (string != null && string.matches("[01]+")) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws BadLocationException {
            if (text != null && text.matches("[01]+")) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }

    class DecimalDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
            if (string != null && string.matches("\\d+")) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws BadLocationException {
            if (text != null && text.matches("\\d+")) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }
}
