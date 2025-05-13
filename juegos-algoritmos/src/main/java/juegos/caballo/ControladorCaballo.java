package juegos.caballo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ControladorCaballo gestiona la comunicación entre el modelo y la vista
 * para ejecutar la simulación del recorrido del caballo.
 */
public class ControladorCaballo {

    private ModeloCaballo modelo;
    private VistaCaballo vista;

    public ControladorCaballo(ModeloCaballo modelo, VistaCaballo vista) {
        this.modelo = modelo;
        this.vista = vista;

        // Listener para el botón "Iniciar"
        vista.getBtnIniciar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSimulacion();
            }
        });
    }

    /**
     * Ejecuta la simulación del recorrido del caballo desde la posición inicial.
     */
    private void iniciarSimulacion() {
        try {
            int tamaño = Integer.parseInt(vista.getTamaño());
            int fila = Integer.parseInt(vista.getFila());
            int columna = Integer.parseInt(vista.getColumna());

            // Valida que la posición inicial esté dentro del tablero
            if (fila < 0 || fila >= tamaño || columna < 0 || columna >= tamaño) {
                vista.mostrarResultado("La posición inicial está fuera del tablero.");
                return;
            }

            int[][] resultado = modelo.resolverCaballo(tamaño, fila, columna);

            if (resultado == null) {
                vista.mostrarResultado("No se encontró solución.");
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < tamaño; i++) {
                    for (int j = 0; j < tamaño; j++) {
                        sb.append(String.format("%2d ", resultado[i][j]));
                    }
                    sb.append("\n");
                }
                vista.mostrarResultado(sb.toString());
            }

        } catch (NumberFormatException ex) {
            vista.mostrarResultado("Por favor, introduce valores numéricos válidos.");
        }
    }
}
