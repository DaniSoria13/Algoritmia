package juegos.caballo;

import javax.swing.*;
import java.awt.*;

public class VistaCaballo extends JFrame {
    private JTextField campoTamaño;
    private JButton btnCrear;
    private JPanel panelTablero;
    private JButton[][] botones;

    public VistaCaballo() {
        setTitle("Recorrido del Caballo");
        setSize(600, 650);
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel();
        panelSuperior.add(new JLabel("Tamaño del tablero:"));
        campoTamaño = new JTextField(5);
        btnCrear = new JButton("Crear tablero");
        panelSuperior.add(campoTamaño);
        panelSuperior.add(btnCrear);

        add(panelSuperior, BorderLayout.NORTH);

        panelTablero = new JPanel();
        add(panelTablero, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void construirTablero(int n, ControladorCaballo controlador) {
        panelTablero.removeAll();
        panelTablero.setLayout(new GridLayout(n, n));
        botones = new JButton[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                JButton boton = new JButton();
                boton.setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.GRAY);
                boton.setOpaque(true);
                boton.setFont(new Font("Arial", Font.BOLD, 16));
                int finalI = i;
                int finalJ = j;
                boton.addActionListener(e -> controlador.empezarDesde(finalI, finalJ));
                botones[i][j] = boton;
                panelTablero.add(boton);
            }
        }

        revalidate();
        repaint();
    }

    public String getTamaño() {
        return campoTamaño.getText();
    }

    public JButton getBtnCrear() {
        return btnCrear;
    }

    public void mostrarRecorrido(int[][] recorrido) {
        for (int i = 0; i < recorrido.length; i++) {
            for (int j = 0; j < recorrido.length; j++) {
                botones[i][j].setText(recorrido[i][j] >= 0 ? String.valueOf(recorrido[i][j]) : "");
            }
        }
    }
}
