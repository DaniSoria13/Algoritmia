package Reinas;

public class NReinas {

    private int N;
    private int[][] tablero;

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
}
