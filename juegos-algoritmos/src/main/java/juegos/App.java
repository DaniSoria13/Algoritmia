package juegos;

import juegos.caballo.MovimientoCaballo;
import juegos.reinas.NReinas;
import juegos.hanoi.TorresDeHanoi;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame ventana = new JFrame("Mi Ventana");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setSize(300, 250);
            ventana.setLayout(new BorderLayout());

            JLabel titulo = new JLabel("Inicio", SwingConstants.CENTER);
            titulo.setFont(new Font("Poppins", Font.BOLD, 20));
            ventana.add(titulo, BorderLayout.NORTH);

            JPanel botones = new JPanel(new GridLayout(3, 1, 10, 10));
            JButton hanoiBtn = new JButton("Torres de Hanoi");
            JButton caballoBtn = new JButton("Caballo");
            JButton reinasBtn = new JButton("Reinas");

            botones.add(hanoiBtn);
            botones.add(caballoBtn);
            botones.add(reinasBtn);
            ventana.add(botones, BorderLayout.CENTER);

            hanoiBtn.addActionListener(e -> new TorresDeHanoi().jugar());
            caballoBtn.addActionListener(e -> new MovimientoCaballo());
            reinasBtn.addActionListener(e -> new NReinas().jugar());

            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}
