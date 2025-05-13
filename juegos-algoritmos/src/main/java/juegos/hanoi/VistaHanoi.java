package juegos.hanoi;

import javax.swing.*;
import java.awt.*;

public class VistaHanoi extends JFrame {
    private JTextArea salida;
    private JTextField inputDiscos;
    private JButton btnIniciar;

    public VistaHanoi() {
        setTitle("Torres de Hanoi");
        setSize(400, 400);
        setLayout(new BorderLayout());

        JPanel panelTop = new JPanel();
        panelTop.add(new JLabel("Número de discos:"));
        inputDiscos = new JTextField(5);
        panelTop.add(inputDiscos);
        btnIniciar = new JButton("Iniciar");
        panelTop.add(btnIniciar);

        salida = new JTextArea();
        salida.setEditable(false);

        add(panelTop, BorderLayout.NORTH);
        add(new JScrollPane(salida), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public String getDiscos() {
        return inputDiscos.getText();
    }

    public void setResultado(String texto) {
        salida.setText(texto);
    }

    public JButton getBtnIniciar() {
        return btnIniciar;
    }
}
