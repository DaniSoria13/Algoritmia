package Caballo;

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

}
