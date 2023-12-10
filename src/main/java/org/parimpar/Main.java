package org.parimpar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JTextField numeroField;
    private JTextArea resultadoArea;

    public Main() {
        super("Tabuada");

        JPanel panel = new JPanel();
        JLabel numeroLabel = new JLabel("Digite um número:");
        numeroField = new JTextField(10);
        JButton calcularButton = new JButton("Calcular");
        resultadoArea = new JTextArea(10, 20);
        resultadoArea.setEditable(false);

        panel.add(numeroLabel);
        panel.add(numeroField);
        panel.add(calcularButton);

        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularTabuada();
            }
        });

        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        panel.add(scrollPane);

        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calcularTabuada() {
        try {
            int numero = Integer.parseInt(numeroField.getText());
            resultadoArea.setText("Tabuada do " + numero + ":\n");

            for (int i = 1; i <= 10; i++) {
                int resultado = numero * i;
                resultadoArea.append(numero + " x " + i + " = " + resultado + "\n");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um número válido.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}
