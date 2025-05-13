package juegos.hanoi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ControladorHanoi gestiona la interacción entre la Vista y el Modelo.
 * Escucha los eventos del usuario y llama al modelo para resolver el juego.
 */
public class ControladorHanoi {
    private ModeloHanoi modelo;
    private VistaHanoi vista;

    /**
     * Constructor del controlador. Conecta modelo y vista, y añade los listeners.
     */
    public ControladorHanoi(ModeloHanoi modelo, VistaHanoi vista) {
        this.modelo = modelo;
        this.vista = vista;

        // Añadir un listener al botón "Iniciar"
        this.vista.getBtnIniciar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSimulacion();
            }
        });
    }

    /**
     * Lógica que se ejecuta cuando se pulsa el botón "Iniciar".
     * Toma el número de discos, resuelve el problema y muestra los pasos.
     */
    private void iniciarSimulacion() {
        try {
            // Intenta convertir el texto en un número
            int discos = Integer.parseInt(vista.getDiscos());
            StringBuilder resultado = new StringBuilder();

            // Llama al modelo para resolver el problema
            modelo.resolverHanoi(discos, 'A', 'B', 'C', resultado);

            // Muestra el resultado en la vista
            vista.setResultado(resultado.toString());

        } catch (NumberFormatException ex) {
            // Si el usuario no introduce un número válido, mostrar mensaje de error
            vista.setResultado("Por favor, introduce un número válido.");
        }
    }
}
