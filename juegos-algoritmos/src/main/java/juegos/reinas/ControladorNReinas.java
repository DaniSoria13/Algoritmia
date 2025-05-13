package juegos.reinas;

import javax.swing.*;

/**
 * Controlador del juego N Reinas. Maneja la interacción inicial y la lógica principal.
 */
public class ControladorNReinas {
    public void iniciarJuego() {
        // Pedimos al usuario el valor de N
        String input = JOptionPane.showInputDialog("Ingrese el número de reinas (N):");
        int n;
        try {
            n = Integer.parseInt(input);
            if (n <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número inválido. Debe ser mayor a 0.");
            return;
        }

        // Creamos el modelo y tratamos de resolver el problema
        ModeloNReinas modelo = new ModeloNReinas(n);
        if (modelo.resolver()) {
            // Si hay solución, la mostramos con la vista
            new VistaNReinas(modelo.getTablero());
        } else {
            JOptionPane.showMessageDialog(null, "No hay solución para N = " + n);
        }
    }
}
