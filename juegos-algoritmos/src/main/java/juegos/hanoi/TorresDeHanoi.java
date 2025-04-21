package juegos.hanoi;

import javax.swing.*;
import java.awt.*;

public class TorresDeHanoi extends JFrame {
    private JTextArea areaResultado;
    private int movimientos;

    public TorresDeHanoi() {
        setTitle("Torres de Hanoi");
        setSize(400, 300); // Tamaño de la ventana
        setLocationRelativeTo(null); // Centra la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra la ventana sin cerrar la aplicación
        setLayout(new BorderLayout()); // Diseño de la ventana

        JLabel label = new JLabel("Número de discos:");
        JTextField input = new JTextField(5); // Campo para ingresar el número de discos
        JButton resolverBtn = new JButton("Resolver");
        areaResultado = new JTextArea();
        areaResultado.setEditable(false); // El área de texto no se puede editar directamente

        // Panel de entrada para el número de discos
        JPanel inputPanel = new JPanel();
        inputPanel.add(label);
        inputPanel.add(input);
        inputPanel.add(resolverBtn);

        add(inputPanel, BorderLayout.NORTH); // Añade el panel con los campos de entrada en la parte superior
        add(new JScrollPane(areaResultado), BorderLayout.CENTER); // Añade el área de texto para mostrar el resultado

        // Acción al presionar el botón de resolver
        resolverBtn.addActionListener(e -> {
            try {
                int n = Integer.parseInt(input.getText()); // Convierte el número de discos
                movimientos = 0; // Reinicia el contador de movimientos
                areaResultado.setText(""); // Limpia el área de texto
                hanoi(n, 'A', 'C', 'B'); // Resuelve el problema de las Torres de Hanoi
                areaResultado.append("\nMovimientos totales: " + movimientos); // Muestra el total de movimientos
            } catch (NumberFormatException ex) {
                areaResultado.setText("Por favor ingrese un número válido.");
            }
        });

        setVisible(true); // Muestra la ventana
    }

    // Función recursiva para resolver el problema de las Torres de Hanoi
    private void hanoi(int n, char origen, char destino, char auxiliar) {
        if (n == 1) {
            areaResultado.append("Mover disco 1 de " + origen + " a " + destino + "\n");
            movimientos++; // Incrementa el contador de movimientos
            return;
        }
        hanoi(n - 1, origen, auxiliar, destino); // Mueve los discos restantes
        areaResultado.append("Mover disco " + n + " de " + origen + " a " + destino + "\n");
        movimientos++; // Incrementa el contador de movimientos
        hanoi(n - 1, auxiliar, destino, origen); // Mueve los discos restantes
    }

    public void jugar() {
        new TorresDeHanoi(); // Abre el juego de Torres de Hanoi
    }
}
