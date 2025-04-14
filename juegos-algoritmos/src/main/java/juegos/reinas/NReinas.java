package juegos.reinas;

public class NReinas {

    private int N;
    private int[][] tablero;

    public NReinas(Object nReinas) {
    }

    public void nReinas(int n) {
        this.N = n;
        tablero = new int[N][N];
    }
    public boolean resolver() {
        return resolverUtil(0);
    }

    private boolean resolverUtil(int col) {
        if (col >= N) {
            imprimirTablero();
            return true;
        }

        boolean res = false;
        for (int i = 0; i < N; i++) {
            if (esSeguro(i, col)) {
                tablero[i][col] = 1;
                res = resolverUtil(col + 1) || res;
                tablero[i][col] = 0;
            }
        }
        return res;
    }

    private boolean esSeguro(int fila, int col) {
        for (int i = 0; i < col; i++)
            if (tablero[fila][i] == 1)
                return false;

        for (int i = fila, j = col; i >= 0 && j >= 0; i--, j--)
            if (tablero[i][j] == 1)
                return false;

        for (int i = fila, j = col; i < N && j >= 0; i++, j--)
            if (tablero[i][j] == 1)
                return false;

        return true;
    }
    private void imprimirTablero() {
        for (int[] fila : tablero) {
            for (int celda : fila) {
                System.out.print((celda == 1 ? "Q " : ". "));
            }
            System.out.println();
        }
        System.out.println();
    }
}
