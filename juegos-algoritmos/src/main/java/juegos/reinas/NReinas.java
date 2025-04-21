package juegos.reinas;

import javax.swing.*;
import java.awt.*;

public class NReinas extends JFrame {
    private int soluciones;

    public NReinas() {
        setTitle("Problema de las N Reinas");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Ingrese el número de reinas:");
        JTextField input = new JTextField(5);
        JButton calcularBtn = new JButton("Calcular");
        JTextArea resultado = new JTextArea();
        resultado.setEditable(false);

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(input);
        panel.add(calcularBtn);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(resultado), BorderLayout.CENTER);

        calcularBtn.addActionListener(e -> {
            try {
                int n = Integer.parseInt(input.getText());
                soluciones = 0;
                int[] tablero = new int[n];
                resolver(tablero, 0, n);
                resultado.setText("Número total de soluciones para " + n + " reinas: " + soluciones);
            } catch (NumberFormatException ex) {
                resultado.setText("Por favor ingrese un número válido.");
            }
        });

        setVisible(true);
    }

    private void resolver(int[] tablero, int fila, int n) {
        if (fila == n) {
            soluciones++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (esSeguro(tablero, fila, col)) {
                tablero[fila] = col;
                resolver(tablero, fila + 1, n);
            }
        }
    }

    private boolean esSeguro(int[] tablero, int fila, int col) {
        for (int i = 0; i < fila; i++) {
            if (tablero[i] == col || Math.abs(tablero[i] - col) == Math.abs(i - fila)) {
                return false;
            }
        }
        return true;
    }

    public void jugar() {
        new NReinas();
    }
}
