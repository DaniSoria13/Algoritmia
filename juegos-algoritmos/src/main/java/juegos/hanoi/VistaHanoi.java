package juegos.hanoi;

import javax.swing.*;
import java.awt.*;

/**
 * VistaHanoi representa la interfaz gráfica del juego Torres de Hanoi.
 * Permite al usuario introducir el número de discos y ver la simulación.
 */
public class VistaHanoi extends JFrame {
    private JTextArea salida;         // Área de texto para mostrar los movimientos
    private JTextField inputDiscos;   // Campo de texto para introducir el número de discos
    private JButton btnIniciar;       // Botón para iniciar la simulación

    public VistaHanoi() {
        setTitle("Torres de Hanoi");
        setSize(400, 400);
        setLayout(new BorderLayout());

        // Panel superior con el input y el botón
        JPanel panelTop = new JPanel();
        panelTop.add(new JLabel("Número de discos:"));
        inputDiscos = new JTextField(5);
        panelTop.add(inputDiscos);
        btnIniciar = new JButton("Iniciar");
        panelTop.add(btnIniciar);

        // Área de salida donde se mostrará la simulación
        salida = new JTextArea();
        salida.setEditable(false);  // No se puede editar el texto generado

        // Agrega los componentes a la ventana
        add(panelTop, BorderLayout.NORTH);
        add(new JScrollPane(salida), BorderLayout.CENTER);

        // Configuración de cierre
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);  // Muestra la ventana
    }

    // Devuelve el texto introducido en el campo de discos
    public String getDiscos() {
        return inputDiscos.getText();
    }

    // Muestra los resultados en el área de texto
    public void setResultado(String texto) {
        salida.setText(texto);
    }

    // Devuelve el botón para poder asignarle eventos desde el controlador
    public JButton getBtnIniciar() {
        return btnIniciar;
    }
}
