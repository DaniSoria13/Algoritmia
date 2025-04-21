package juegos.reinas;

import javax.swing.*;
import java.awt.*;

public class NReinas extends JFrame {
    private int soluciones; // Variable para contar las soluciones

    public NReinas() {
        setTitle("Problema de las N Reinas");
        setSize(400, 250); // Tamaño de la ventana
        setLocationRelativeTo(null); // Centra la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra la ventana al cerrar
        setLayout(new BorderLayout()); // Establece el diseño principal

        JLabel label = new JLabel("Ingrese el número de reinas:");
        JTextField input = new JTextField(5); // Campo de texto para el número de reinas
        JButton calcularBtn = new JButton("Calcular");
        JTextArea resultado = new JTextArea(); // Área de texto para mostrar el resultado
        resultado.setEditable(false); // No se puede editar directamente

        // Panel para organizar los elementos de entrada
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(input);
        panel.add(calcularBtn);

        // Agrega los componentes al layout principal
        add(panel, BorderLayout.NORTH); // Panel superior
        add(new JScrollPane(resultado), BorderLayout.CENTER); // Área central con scroll

        // Acción al presionar el botón "Calcular"
        calcularBtn.addActionListener(e -> {
            try {
                int n = Integer.parseInt(input.getText()); // Lee el número ingresado
                soluciones = 0; // Reinicia el contador
                int[] tablero = new int[n]; // Cada índice representa una fila, y su valor representa la columna
                resolverNReinas(tablero, 0, n); // Comienza la recursión
                resultado.setText("Número de soluciones encontradas: " + soluciones); // Muestra el resultado
            } catch (NumberFormatException ex) {
                resultado.setText("Por favor ingrese un número válido.");
            }
        });

        setVisible(true); // Muestra la ventana
    }

    // Algoritmo recursivo para resolver el problema de N Reinas
    private void resolverNReinas(int[] tablero, int fila, int n) {
        if (fila == n) {
            soluciones++; // Si se llega al final, es una solución válida
            return;
        }

        for (int col = 0; col < n; col++) {
            if (esValido(tablero, fila, col)) {
                tablero[fila] = col; // Coloca una reina
                resolverNReinas(tablero, fila + 1, n); // Llama recursivamente para la siguiente fila
            }
        }
    }

    // Verifica si es seguro colocar una reina en esa posición
    private boolean esValido(int[] tablero, int fila, int col) {
        for (int i = 0; i < fila; i++) {
            if (tablero[i] == col || // Misma columna
                    tablero[i] - i == col - fila || // Misma diagonal izquierda
                    tablero[i] + i == col + fila) { // Misma diagonal derecha
                return false;
            }
        }
        return true;
    }
}
