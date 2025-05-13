package juegos.reinas;

import javax.swing.*;
import java.awt.*;

/**
 * Vista del problema de N Reinas que muestra gráficamente el tablero.
 */
public class VistaNReinas extends JFrame {
    private JPanel panel;

    /**
     * Constructor que recibe un tablero de solución para visualizarlo.
     * @param tablero matriz con 1 para reinas y 0 para casillas vacías
     */
    public VistaNReinas(int[][] tablero) {
        setTitle("N Reinas");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Creamos un panel con GridLayout del tamaño del tablero
        panel = new JPanel(new GridLayout(tablero.length, tablero.length));
        getContentPane().add(panel);

        // Llamamos al método para mostrar el tablero
        dibujarTablero(tablero);

        setVisible(true);
    }

    /**
     * Dibuja el tablero con casillas y coloca reinas (Q) donde hay un 1.
     */
    private void dibujarTablero(int[][] tablero) {
        panel.removeAll();
        int n = tablero.length;

        for (int fila = 0; fila < n; fila++) {
            for (int col = 0; col < n; col++) {
                JButton celda = new JButton();
                celda.setFont(new Font("Arial", Font.BOLD, 20));
                celda.setEnabled(false);

                // Si hay una reina, mostramos "Q"
                if (tablero[fila][col] == 1) {
                    celda.setText("Q");
                    celda.setBackground(Color.YELLOW);
                } else {
                    // Coloreamos estilo ajedrez
                    celda.setBackground((fila + col) % 2 == 0 ? Color.WHITE : Color.GRAY);
                }

                panel.add(celda);
            }
        }

        revalidate();
        repaint();
    }
}
