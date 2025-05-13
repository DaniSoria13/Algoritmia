package juegos.caballo;

import javax.swing.*;
import java.awt.*;

/**
 * VistaCaballo proporciona la interfaz gráfica para que el usuario
 * introduzca el tamaño del tablero y la posición inicial del caballo.
 */
public class VistaCaballo extends JFrame {
    private JTextField campoTamaño;
    private JTextField campoFila;
    private JTextField campoColumna;
    private JButton btnIniciar;
    private JTextArea areaResultado;

    public VistaCaballo() {
        setTitle("Recorrido del Caballo");
        setSize(500, 500);
        setLayout(new BorderLayout());

        // Panel superior con campos de entrada
        JPanel panelSuperior = new JPanel();
        panelSuperior.add(new JLabel("Tamaño del tablero:"));
        campoTamaño = new JTextField(5);
        panelSuperior.add(campoTamaño);

        panelSuperior.add(new JLabel("Fila inicial:"));
        campoFila = new JTextField(5);
        panelSuperior.add(campoFila);

        panelSuperior.add(new JLabel("Columna inicial:"));
        campoColumna = new JTextField(5);
        panelSuperior.add(campoColumna);

        btnIniciar = new JButton("Iniciar");
        panelSuperior.add(btnIniciar);

        // Área de texto para mostrar la solución
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);

        add(panelSuperior, BorderLayout.NORTH);
        add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    // Getters para los valores introducidos
    public String getTamaño() { return campoTamaño.getText(); }
    public String getFila() { return campoFila.getText(); }
    public String getColumna() { return campoColumna.getText(); }
    public JButton getBtnIniciar() { return btnIniciar; }
    public void mostrarResultado(String texto) {
        areaResultado.setText(texto);
    }
}
