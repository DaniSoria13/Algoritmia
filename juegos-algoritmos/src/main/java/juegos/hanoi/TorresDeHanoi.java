package juegos.hanoi;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class TorresDeHanoi extends JFrame {
    private JTextArea areaResultado;
    private JTextField inputOrigen;
    private JTextField inputDestino;
    private JButton moverBtn;

    private Vector<Integer> torreA;
    private Vector<Integer> torreB;
    private Vector<Integer> torreC;

    private int nivelActual = 3;
    private int movimientos = 0;

    public TorresDeHanoi() {
        setTitle("Torres de Hanoi Interactivo");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultado);

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("De torre (A/B/C):"));
        inputOrigen = new JTextField(2);
        controlPanel.add(inputOrigen);
        controlPanel.add(new JLabel("A torre (A/B/C):"));
        inputDestino = new JTextField(2);
        controlPanel.add(inputDestino);
        moverBtn = new JButton("Mover");
        controlPanel.add(moverBtn);

        add(scroll, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        iniciarNivel();

        moverBtn.addActionListener(e -> {
            String origen = inputOrigen.getText().trim().toUpperCase();
            String destino = inputDestino.getText().trim().toUpperCase();
            inputOrigen.setText("");
            inputDestino.setText("");

            if (!esTorreValida(origen) || !esTorreValida(destino)) {
                areaResultado.append("\n❌ Torres válidas: A, B o C.\n");
                return;
            }

            moverDisco(origen, destino);
        });

        setVisible(true);
    }

    private boolean esTorreValida(String letra) {
        return letra.equals("A") || letra.equals("B") || letra.equals("C");
    }

    private void iniciarNivel() {
        areaResultado.setText("");
        areaResultado.append("=== Nivel con " + nivelActual + " discos ===\n");

        torreA = new Vector<>();
        torreB = new Vector<>();
        torreC = new Vector<>();
        movimientos = 0;

        for (int i = nivelActual; i >= 1; i--) {
            torreA.add(i);
        }

        mostrarTorres();
    }

    private void mostrarTorres() {
        areaResultado.append("\nEstado actual:\n");
        areaResultado.append("Torre A: " + torreA + "\n");
        areaResultado.append("Torre B: " + torreB + "\n");
        areaResultado.append("Torre C: " + torreC + "\n");
    }

    private Vector<Integer> obtenerTorre(String letra) {
        switch (letra) {
            case "A": return torreA;
            case "B": return torreB;
            case "C": return torreC;
            default: return null;
        }
    }

    private void moverDisco(String origen, String destino) {
        Vector<Integer> torreOrigen = obtenerTorre(origen);
        Vector<Integer> torreDestino = obtenerTorre(destino);

        if (torreOrigen == null || torreDestino == null) return;

        if (torreOrigen.isEmpty()) {
            areaResultado.append("\n❌ La torre " + origen + " está vacía.\n");
            return;
        }

        int disco = torreOrigen.lastElement();

        if (!torreDestino.isEmpty() && torreDestino.lastElement() < disco) {
            areaResultado.append("\n❌ No puedes colocar un disco grande sobre uno más pequeño.\n");
            return;
        }

        torreOrigen.remove(torreOrigen.size() - 1);
        torreDestino.add(disco);
        movimientos++;
        areaResultado.append("\n✅ Moviste disco " + disco + " de " + origen + " a " + destino + ".\n");

        mostrarTorres();
        verificarVictoria();
    }

    private void verificarVictoria() {
        if (torreB.size() == nivelActual || torreC.size() == nivelActual) {
            areaResultado.append("\n🎉 ¡Nivel completado! 🎉\n");
            areaResultado.append("Has completado el nivel en " + movimientos + " movimientos.\n");

            int opcion = JOptionPane.showOptionDialog(
                    this,
                    "Has completado el nivel en " + movimientos + " movimientos.\n\n¿Deseas pasar al siguiente nivel?",
                    "Nivel Completado",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Sí", "No"},
                    "Sí"
            );

            if (opcion == JOptionPane.YES_OPTION && nivelActual < 7) {
                nivelActual++;
                iniciarNivel();
            } else {
                JOptionPane.showMessageDialog(this, "Gracias por jugar. ¡Hasta luego!");
                dispose();
            }
        }
    }
}
