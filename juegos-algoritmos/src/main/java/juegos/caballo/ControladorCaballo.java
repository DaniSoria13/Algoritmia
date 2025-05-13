package juegos.caballo;

import javax.swing.*;

public class ControladorCaballo {
    private ModeloCaballo modelo;
    private VistaCaballo vista;
    private int tamaño;

    public ControladorCaballo(ModeloCaballo modelo, VistaCaballo vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.getBtnCrear().addActionListener(e -> {
            try {
                tamaño = Integer.parseInt(vista.getTamaño());
                if (tamaño <= 0) throw new NumberFormatException();
                vista.construirTablero(tamaño, this);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vista, "Introduce un número válido para el tamaño.");
            }
        });
    }

    public void empezarDesde(int fila, int columna) {
        int[][] resultado = modelo.resolverCaballo(tamaño, fila, columna);
        if (resultado != null) {
            vista.mostrarRecorrido(resultado);
        } else {
            JOptionPane.showMessageDialog(vista, "No se pudo encontrar un recorrido.");
        }
    }
}
