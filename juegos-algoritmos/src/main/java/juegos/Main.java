package juegos;

import juegos.hanoi.ControladorHanoi;
import juegos.hanoi.ModeloHanoi;
import juegos.hanoi.VistaHanoi;
import juegos.caballo.ControladorCaballo;
import juegos.caballo.ModeloCaballo;
import juegos.caballo.VistaCaballo;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame ventana = new JFrame("Menú de Juegos");
            ventana.setSize(400, 300);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setLayout(new GridLayout(3, 1, 10, 10));

            JButton btnCaballo = new JButton("Juego del Caballo");
            JButton btnHanoi = new JButton("Torres de Hanoi");
            JButton btnSalir = new JButton("Salir");

            btnCaballo.addActionListener(e -> {
                ModeloCaballo modelo = new ModeloCaballo();
                VistaCaballo vista = new VistaCaballo();
                new ControladorCaballo(modelo, vista);
            });

            btnHanoi.addActionListener(e -> {
                ModeloHanoi modelo = new ModeloHanoi();
                VistaHanoi vista = new VistaHanoi();
                new ControladorHanoi(modelo, vista);
            });

            btnSalir.addActionListener(e -> System.exit(0));

            ventana.add(btnCaballo);
            ventana.add(btnHanoi);
            ventana.add(btnSalir);

            ventana.setLocationRelativeTo(null); // Centra la ventana
            ventana.setVisible(true);
        });
    }
}
