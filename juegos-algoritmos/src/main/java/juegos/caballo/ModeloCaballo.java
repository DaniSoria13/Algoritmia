package juegos.caballo;

/**
 * ModeloCaballo contiene la lógica para calcular los posibles movimientos del caballo
 * en un tablero de ajedrez, usando el algoritmo de backtracking.
 */
public class ModeloCaballo {

    // Posibles movimientos del caballo
    private final int[] movX = {2, 1, -1, -2, -2, -1, 1, 2};
    private final int[] movY = {1, 2, 2, 1, -1, -2, -2, -1};

    /**
     * Método que resuelve el recorrido del caballo desde una posición inicial.
     *
     * @param n      Tamaño del tablero n x n
     * @param startX Fila inicial
     * @param startY Columna inicial
     * @return Un tablero con los pasos del caballo o null si no hay solución
     */
    public int[][] resolverCaballo(int n, int startX, int startY) {
        int[][] tablero = new int[n][n]; // Tablero donde se almacenan los pasos

        // Inicializa el tablero con -1 (sin visitar)
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tablero[i][j] = -1;

        tablero[startX][startY] = 0; // Primer paso en la posición inicial

        if (resolverBacktrack(startX, startY, 1, tablero, n)) {
            return tablero;
        } else {
            return null; // No se encontró solución
        }
    }

    /**
     * Backtracking recursivo para encontrar la solución del recorrido del caballo.
     */
    private boolean resolverBacktrack(int x, int y, int paso, int[][] tablero, int n) {
        if (paso == n * n) {
            return true; // Si se han visitado todos los casilleros, se ha terminado
        }

        // Intenta los 8 posibles movimientos
        for (int i = 0; i < 8; i++) {
            int nextX = x + movX[i];
            int nextY = y + movY[i];

            // Si el movimiento es válido
            if (esValido(nextX, nextY, tablero, n)) {
                tablero[nextX][nextY] = paso; // Marca el paso

                // Continúa con el siguiente paso
                if (resolverBacktrack(nextX, nextY, paso + 1, tablero, n)) {
                    return true;
                }

                // Si no se puede continuar, deshacer el paso
                tablero[nextX][nextY] = -1;
            }
        }

        return false;
    }

    /**
     * Verifica si una posición es válida y no ha sido visitada.
     */
    private boolean esValido(int x, int y, int[][] tablero, int n) {
        return x >= 0 && x < n && y >= 0 && y < n && tablero[x][y] == -1;
    }
}
