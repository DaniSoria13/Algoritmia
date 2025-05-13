package juegos.caballo;

public class ModeloCaballo {
    private final int[] movX = {2, 1, -1, -2, -2, -1, 1, 2};
    private final int[] movY = {1, 2, 2, 1, -1, -2, -2, -1};

    public int[][] resolverCaballo(int n, int startX, int startY) {
        int[][] tablero = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tablero[i][j] = -1;

        tablero[startX][startY] = 0;

        if (resolverBacktrack(startX, startY, 1, tablero, n)) {
            return tablero;
        } else {
            return null;
        }
    }

    private boolean resolverBacktrack(int x, int y, int paso, int[][] tablero, int n) {
        if (paso == n * n) return true;

        for (int i = 0; i < 8; i++) {
            int nextX = x + movX[i];
            int nextY = y + movY[i];

            if (esValido(nextX, nextY, tablero, n)) {
                tablero[nextX][nextY] = paso;

                if (resolverBacktrack(nextX, nextY, paso + 1, tablero, n)) return true;

                tablero[nextX][nextY] = -1;
            }
        }
        return false;
    }

    private boolean esValido(int x, int y, int[][] tablero, int n) {
        return x >= 0 && x < n && y >= 0 && y < n && tablero[x][y] == -1;
    }
}
