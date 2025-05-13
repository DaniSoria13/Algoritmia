package juegos.reinas;

/**
 * Clase que contiene la lógica del problema de N Reinas.
 */
public class ModeloNReinas {
    private int n;
    private int[][] tablero;

    public ModeloNReinas(int n) {
        this.n = n;
        tablero = new int[n][n];
    }

    // Intenta resolver el problema desde la primera fila
    public boolean resolver() {
        return resolver(0);
    }

    // Devuelve el tablero con la solución
    public int[][] getTablero() {
        return tablero;
    }

    // Método recursivo que intenta colocar reinas fila por fila
    private boolean resolver(int fila) {
        if (fila == n) return true;

        for (int col = 0; col < n; col++) {
            if (esSeguro(fila, col)) {
                tablero[fila][col] = 1;
                if (resolver(fila + 1)) return true;
                tablero[fila][col] = 0;
            }
        }
        return false;
    }

    // Verifica si una reina puede colocarse en una posición segura
    private boolean esSeguro(int fila, int col) {
        for (int i = 0; i < fila; i++)
            if (tablero[i][col] == 1) return false;

        for (int i = fila - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (tablero[i][j] == 1) return false;

        for (int i = fila - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (tablero[i][j] == 1) return false;

        return true;
    }
}
