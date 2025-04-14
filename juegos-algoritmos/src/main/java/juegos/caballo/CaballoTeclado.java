package juegos.caballo;

public class CaballoTeclado {

    // Mapa de movimientos posibles desde cada número
    private static final int[][] movimientos = {
            {4, 6},     // 0
            {6, 8},     // 1
            {7, 9},     // 2
            {4, 8},     // 3
            {0, 3, 9},  // 4
            {},         // 5 (sin movimientos)
            {0, 1, 7},  // 6
            {2, 6},     // 7
            {1, 3},     // 8
            {2, 4}      // 9
    };

    public int contarMovimientos(int n) {
        // dp[i][j] representa la cantidad de formas de llegar al número j con i movimientos
        int[][] dp = new int[n + 1][10];

        // Inicializar: con 0 movimientos hay una forma de estar en cada dígito
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int paso = 1; paso <= n; paso++) {
            for (int num = 0; num <= 9; num++) {
                dp[paso][num] = 0; // Reiniciar
                for (int next : movimientos[num]) {
                    dp[paso][num] += dp[paso - 1][next];
                }
            }
        }

        int total = 0;
        for (int i = 0; i < 10; i++) {
            total += dp[n][i];
        }

        return total;
    }
}