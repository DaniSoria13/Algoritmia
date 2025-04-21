package juegos.caballo;

import javax.swing.*;
import java.awt.*;

public class MovimientoCaballo extends JFrame {
    private int[][] tablero;
    private int n;
    private int totalSecuencias;

    public MovimientoCaballo() {
        setTitle("Movimiento del Caballo");
        setSize(400, 200); // Tamaño de la ventana del juego
        setLocationRelativeTo(null); // Centra la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra la ventana sin cerrar la aplicación
        setLayout(new BorderLayout()); // Diseño de la ventana

        JLabel label = new JLabel("Ingrese el tamaño del tablero (N x N) y número de movimientos:");
        JTextField inputN = new JTextField(5); // Campo para ingresar el tamaño N
        JTextField inputMovs = new JTextField(5); // Campo para ingresar el número de movimientos
        JButton calcularBtn = new JButton("Calcular");
        JTextArea resultado = new JTextArea();
        resultado.setEditable(false); // El área de texto no se puede editar directamente

        // Panel para los campos de entrada
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Tamaño N:"));
        inputPanel.add(inputN);
        inputPanel.add(new JLabel("Movimientos:"));
        inputPanel.add(inputMovs);
        inputPanel.add(calcularBtn);

        add(label, BorderLayout.NORTH); // Añade la etiqueta de la parte superior
        add(inputPanel, BorderLayout.CENTER); // Añade los campos de entrada en el centro
        add(new JScrollPane(resultado), BorderLayout.SOUTH); // Añade el área de texto de resultados en la parte inferior

        // Acción para calcular los movimientos
        calcularBtn.addActionListener(e -> {
            try {
                n = Integer.parseInt(inputN.getText()); // Convierte el valor de tamaño N
                int movimientos = Integer.parseInt(inputMovs.getText()); // Convierte el número de movimientos
                tablero = new int[n][n]; // Crea el tablero
                totalSecuencias = 0; // Reinicia el contador de secuencias válidas

                // Recorre cada celda del tablero
                for (int fila = 0; fila < n; fila++) {
                    for (int col = 0; col < n; col++) {
                        totalSecuencias += contarMovimientos(fila, col, movimientos); // Cuenta los movimientos desde esa celda
                    }
                }

                // Muestra el resultado en el área de texto
                resultado.setText("Total de secuencias válidas: " + totalSecuencias);
            } catch (NumberFormatException ex) {
                resultado.setText("Por favor ingrese valores válidos.");
            }
        });

        setVisible(true); // Muestra la ventana
    }

    // Función recursiva para contar los movimientos del caballo
    private int contarMovimientos(int fila, int col, int movimientos) {
        if (fila < 0 || col < 0 || fila >= n || col >= n) return 0; // Verifica si la celda es válida
        if (movimientos == 0) return 1; // Si no quedan movimientos, es una secuencia válida

        int total = 0;
        int[][] movimientosCaballo = {
                {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
                {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
        };

        // Recursión para contar los movimientos del caballo
        for (int[] mov : movimientosCaballo) {
            total += contarMovimientos(fila + mov[0], col + mov[1], movimientos - 1);
        }

        return total; // Devuelve el total de secuencias válidas
    }
}
