package juegos;

import javax.swing.*;
import java.awt.*;
import juegos.hanoi.*;
import juegos.caballo.*;
import juegos.reinas.*;

/**
 * Clase principal que muestra un menú con botones
 * para acceder a los tres juegos disponibles:
 * - Torres de Hanoi
 * - Caballo
 * - N Reinas
 */
public class Main extends JFrame {

    public Main() {
        setTitle("Juegos de Lógica - MVC");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana
        setLayout(new GridLayout(3, 1, 10, 10)); // Distribución en filas

        // Botón para Torres de Hanoi
        JButton btnHanoi = new JButton("Torres de Hanoi");
        btnHanoi.addActionListener(e -> {
            ModeloHanoi modeloHanoi = new ModeloHanoi();
            VistaHanoi vistaHanoi = new VistaHanoi();
            new ControladorHanoi(modeloHanoi, vistaHanoi);
        });

        // Botón para el juego del Caballo
        JButton btnCaballo = new JButton("Juego del Caballo");
        btnCaballo.addActionListener(e -> {
            ModeloCaballo modeloCaballo = new ModeloCaballo();
            VistaCaballo vistaCaballo = new VistaCaballo();
            new ControladorCaballo(modeloCaballo, vistaCaballo);
        });

        // Botón para N Reinas
        JButton btnReinas = new JButton("N Reinas");
        btnReinas.addActionListener(e -> {
            ControladorNReinas controlador = new ControladorNReinas();
            controlador.iniciarJuego();
        });

        // Añadir botones al frame
        add(btnHanoi);
        add(btnCaballo);
        add(btnReinas);

        setVisible(true);
    }

    public static void main(String[] args) {
        // Ejecuta la aplicación en el hilo de eventos de Swing
        SwingUtilities.invokeLater(Main::new);
    }
}
