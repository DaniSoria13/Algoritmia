package juegos.hanoi;

public class ModeloHanoi {
    public void resolverHanoi(int n, char origen, char auxiliar, char destino, StringBuilder resultado) {
        if (n == 1) {
            resultado.append("Mover disco 1 de ").append(origen).append(" a ").append(destino).append("\n");
            return;
        }

        resolverHanoi(n - 1, origen, destino, auxiliar, resultado);
        resultado.append("Mover disco ").append(n).append(" de ").append(origen).append(" a ").append(destino).append("\n");
        resolverHanoi(n - 1, auxiliar, origen, destino, resultado);
    }
}
