package juegos;

import javax.swing.*;
import java.awt.*;
import juegos.caballo.MovimientoCaballo;
import juegos.hanoi.TorresDeHanoi;
import juegos.reinas.NReinas;

public class App extends JFrame {

    public App() {
        setTitle("Juegos de Algoritmia");
        setSize(500, 300); // Establece el tamaño de la ventana principal
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        setLayout(new BorderLayout()); // Establece el layout de la ventana

        // Panel con botones para cada juego
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(4, 1)); // Organiza los botones en una columna

        JButton botonCaballo = new JButton("Juego del Caballo");
        JButton botonReinas = new JButton("Problema de las N Reinas");
        JButton botonTorres = new JButton("Torres de Hanoi");
        JButton salirBtn = new JButton("Salir");

        menuPanel.add(botonCaballo); // Añade el botón del caballo
        menuPanel.add(botonReinas); // Añade el botón del problema de las N Reinas
        menuPanel.add(botonTorres); // Añade el botón de las Torres de Hanoi
        menuPanel.add(salirBtn); // Añade el botón de salir

        add(menuPanel, BorderLayout.CENTER); // Añade el panel con botones a la ventana

        // Acción cuando el usuario elige el Juego del Caballo
        botonCaballo.addActionListener(e -> {
            new MovimientoCaballo(); // Abre el juego del Caballo
            setVisible(false); // Oculta la ventana principal
        });

        // Acción cuando el usuario elige el problema de las N Reinas
        botonReinas.addActionListener(e -> {
            new NReinas(); // Abre el juego de las N Reinas
            setVisible(false); // Oculta la ventana principal
        });

        // Acción cuando el usuario elige las Torres de Hanoi
        botonTorres.addActionListener(e -> {
            new TorresDeHanoi(); // Abre el juego de las Torres de Hanoi
            setVisible(false); // Oculta la ventana principal
        });

        // Acción cuando el usuario elige salir
        salirBtn.addActionListener(e -> System.exit(0)); // Cierra la aplicación

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App().setVisible(true)); // Llama al método principal
    }
}
