package juegos.hanoi;

/**
 * ModeloHanoi se encarga de la lógica del juego de las Torres de Hanoi.
 * Contiene el algoritmo recursivo que resuelve el problema.
 */
public class ModeloHanoi {

    /**
     * Método recursivo que resuelve las Torres de Hanoi
     */
    public void resolverHanoi(int n, char origen, char auxiliar, char destino, StringBuilder resultado) {
        if (n == 1) {
            // Caso base: mover un solo disco directamente al destino
            resultado.append("Mover disco 1 de ").append(origen).append(" a ").append(destino).append("\n");
            return;
        }

        // Mueve n-1 discos al auxiliar
        resolverHanoi(n - 1, origen, destino, auxiliar, resultado);

        // Mueve el disco más grande al destino
        resultado.append("Mover disco ").append(n).append(" de ").append(origen).append(" a ").append(destino).append("\n");

        // Mueve los n-1 discos del auxiliar al destino
        resolverHanoi(n - 1, auxiliar, origen, destino, resultado);
    }
}
