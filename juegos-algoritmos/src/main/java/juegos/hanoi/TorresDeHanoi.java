package juegos.hanoi;

import javax.swing.*;
import java.awt.*;

public class TorresDeHanoi extends JFrame {
    private JTextArea areaResultado;
    private int movimientos;

    public TorresDeHanoi() {
        setTitle("Torres de Hanoi");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Número de discos:");
        JTextField input = new JTextField(5);
        JButton resolverBtn = new JButton("Resolver");
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);

        JPanel inputPanel = new JPanel();
        inputPanel.add(label);
        inputPanel.add(input);
        inputPanel.add(resolverBtn);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        resolverBtn.addActionListener(e -> {
            try {
                int n = Integer.parseInt(input.getText());
                movimientos = 0;
                areaResultado.setText(""); // limpiar
                hanoi(n, 'A', 'C', 'B');
                areaResultado.append("\nMovimientos totales: " + movimientos);
            } catch (NumberFormatException ex) {
                areaResultado.setText("Por favor ingrese un número válido.");
            }
        });

        setVisible(true);
    }

    private void hanoi(int n, char origen, char destino, char auxiliar) {
        if (n == 1) {
            areaResultado.append("Mover disco 1 de " + origen + " a " + destino + "\n");
            movimientos++;
            return;
        }
        hanoi(n - 1, origen, auxiliar, destino);
        areaResultado.append("Mover disco " + n + " de " + origen + " a " + destino + "\n");
        movimientos++;
        hanoi(n - 1, auxiliar, destino, origen);
    }

    public void jugar() {
        new TorresDeHanoi();
    }
}
