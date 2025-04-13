package TorresHanoi;

public class Hanoi {
    private int[][] torres = new int[3][3]; // torres[fila][columna]
    private int movimientos = 0;

    public void torresdehanoi() {
        // Colocar los discos en la torre A (columna 0), desde la base hacia arriba
        torres[0][0] = 1;
        torres[1][0] = 2;
        torres[2][0] = 3;
    }

    private void mostrarTorres() {
        System.out.println("Estado actual:");
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 3; col++) {
                int disco = torres[fila][col];
                System.out.print(" " + (disco == 0 ? "." : disco));
            }
            System.out.println();
        }
        System.out.println("---------");
        System.out.println("  A B C\n");
    }

    private void moverDiscos(int n, int origen, int destino, int auxiliar) {
        if (n == 1) {
            moverUno(origen, destino);
            return;
        }
        moverDiscos(n - 1, origen, auxiliar, destino);
        moverUno(origen, destino);
        moverDiscos(n - 1, auxiliar, destino, origen);
    }

    private void moverUno(int origen, int destino) {
        int disco = sacarDisco(origen);
        ponerDisco(destino, disco);
        movimientos++;
        System.out.println("\nMovimiento " + movimientos + ": Mover disco " + disco + " de " + torreNombre(origen) + " a " + torreNombre(destino));
        mostrarTorres();


    }
    private int sacarDisco(int columna) {
        for (int fila = 2; fila >= 0; fila--) {
            if (torres[fila][columna] != 0) {
                int disco = torres[fila][columna];
                torres[fila][columna] = 0;
                return disco;
            }
        }
        return 0; // no debería ocurrir
    }

    private void ponerDisco(int columna, int disco) {
        for (int fila = 0; fila < 3; fila++) {
            if (torres[fila][columna] == 0) {
                torres[fila][columna] = disco;
                return;
            }
        }
    }
    private String torreNombre(int columna) {
        return switch (columna) {
            case 0 -> "A";
            case 1 -> "B";
            case 2 -> "C";
            default -> "?";
        };
    }

    public void resolver() {
        System.out.println("Estado inicial:");
        mostrarTorres();
        moverDiscos(3, 0, 2, 1); // mover de A(0) a C(2) usando B(1)
        System.out.println("\nHas completado el juego en " + movimientos + " movimientos.");
    }

}

