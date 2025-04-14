package juegos.reinas;

public class NReinas {
    private int n;
    private int[][] tablero;

    public void jugar() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("\n--- Juego: N Reinas ---");
        System.out.print("Ingrese el número de reinas (N): ");
        n = sc.nextInt();
        tablero = new int[n][n];

        if (resolver(0)) {
            mostrarTablero();
        } else {
            System.out.println("No hay solución para N = " + n + "\n");
        }
    }

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

    private boolean esSeguro(int fila, int col) {
        for (int i = 0; i < fila; i++)
            if (tablero[i][col] == 1) return false;

        for (int i = fila - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (tablero[i][j] == 1) return false;

        for (int i = fila - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (tablero[i][j] == 1) return false;

        return true;
    }

    private void mostrarTablero() {
        System.out.println("\nSolución encontrada:");
        for (int[] fila : tablero) {
            for (int celda : fila) {
                System.out.print(celda == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
