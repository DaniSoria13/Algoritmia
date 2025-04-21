package juegos.caballo;

import javax.swing.*;
import java.awt.*;

public class MovimientoCaballo extends JFrame {
    private int[][] tablero;
    private int n;
    private int totalSecuencias;

    public MovimientoCaballo() {
        setTitle("Movimiento del Caballo");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Ingrese el tamaño del tablero (N x N) y número de movimientos:");
        JTextField inputN = new JTextField(5);
        JTextField inputMovs = new JTextField(5);
        JButton calcularBtn = new JButton("Calcular");
        JTextArea resultado = new JTextArea();
        resultado.setEditable(false);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Tamaño N:"));
        inputPanel.add(inputN);
        inputPanel.add(new JLabel("Movimientos:"));
        inputPanel.add(inputMovs);
        inputPanel.add(calcularBtn);

        add(label, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(new JScrollPane(resultado), BorderLayout.SOUTH);

        calcularBtn.addActionListener(e -> {
            try {
                n = Integer.parseInt(inputN.getText());
                int movimientos = Integer.parseInt(inputMovs.getText());
                tablero = new int[n][n];
                totalSecuencias = 0;

                for (int fila = 0; fila < n; fila++) {
                    for (int col = 0; col < n; col++) {
                        totalSecuencias += contarMovimientos(fila, col, movimientos);
                    }
                }

                resultado.setText("Total de secuencias válidas: " + totalSecuencias);
            } catch (NumberFormatException ex) {
                resultado.setText("Por favor ingrese valores válidos.");
            }
        });

        setVisible(true);
    }

    private int contarMovimientos(int fila, int col, int movimientos) {
        if (fila < 0 || col < 0 || fila >= n || col >= n) return 0;
        if (movimientos == 0) return 1;

        int total = 0;
        int[][] movimientosCaballo = {
                {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
                {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
        };

        for (int[] mov : movimientosCaballo) {
            total += contarMovimientos(fila + mov[0], col + mov[1], movimientos - 1);
        }

        return total;
    }
}
