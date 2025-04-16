package juegos.caballo;

public class MovimientoCaballo {
    private int[][] movimientosValidos = {
            {4, 6},    // 0
            {6, 8},    // 1
            {7, 9},    // 2
            {4, 8},    // 3
            {3, 9, 0}, // 4
            {},        // 5
            {1, 7, 0}, // 6
            {2, 6},    // 7
            {1, 3},    // 8
            {2, 4}     // 9
    };

    public void jugar() {
        java.util.Scanner sc = new java.util.Scanner(System.in); // Inicializamos el scanner para poder leer la entrada del usuario
        System.out.println("\n--- Juego: Movimientos del Caballo ---");
        System.out.print("Ingrese la cantidad de movimientos: ");
        int movimientos = sc.nextInt(); // Registramos la cantidad de movimientos que el usuario desea realizar

        int total = 0;
        for (int i = 0; i <= 9; i++) { //  Mediante un bucle recorremos todas las posiciones del tablero
            total += contarMovimientos(i, movimientos);
        }

        System.out.println("Total de secuencias válidas: " + total + "\n");
    }

    private int contarMovimientos(int posicion, int movimientos) {
        if (movimientos == 0) return 1;
        int total = 0;
        for (int destino : movimientosValidos[posicion]) {
            total += contarMovimientos(destino, movimientos - 1);
        }
        return total;
    }
}
