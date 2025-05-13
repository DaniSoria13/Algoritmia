package juegos.hanoi;

public class ControladorHanoi {
    private ModeloHanoi modelo;
    private VistaHanoi vista;

    public ControladorHanoi(ModeloHanoi modelo, VistaHanoi vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.getBtnIniciar().addActionListener(e -> {
            try {
                int discos = Integer.parseInt(vista.getDiscos());
                StringBuilder resultado = new StringBuilder();
                modelo.resolverHanoi(discos, 'A', 'B', 'C', resultado);
                vista.setResultado(resultado.toString());
            } catch (NumberFormatException ex) {
                vista.setResultado("Introduce un número válido.");
            }
        });
    }
}
