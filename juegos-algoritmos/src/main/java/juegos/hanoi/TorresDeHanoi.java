package juegos.hanoi;

public class TorresDeHanoi {
    private int[][] torres;
    private int movimientos;

    public TorresDeHanoi() {
        torres = new int[3][3];
        for (int i = 0; i < 3; i++) {
            torres[0][i] = i + 1;
        }
        movimientos = 0;
    }

    public void jugar() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("\n--- Juego: Torres de Hanoi (3 discos) ---");
        while (!juegoCompleto()) {
            mostrarTorres();
            System.out.print("Seleccione torre origen (0-2): ");
            int origen = sc.nextInt();
            System.out.print("Seleccione torre destino (0-2): ");
            int destino = sc.nextInt();
            if (moverDisco(origen, destino)) {
                movimientos++;
            } else {
                System.out.println("Movimiento no válido.");
            }
        }
        mostrarTorres();
        System.out.println("Juego completado en " + movimientos + " movimientos.\n");
    }

    private boolean moverDisco(int origen, int destino) {
        int discoOrigen = obtenerDiscoSuperior(origen);
        if (discoOrigen == -1) return false;
        int discoDestino = obtenerDiscoSuperior(destino);
        if (discoDestino != -1 && discoDestino < discoOrigen) return false;
        quitarDisco(origen);
        ponerDisco(destino, discoOrigen);
        return true;
    }

    private int obtenerDiscoSuperior(int torre) {
        for (int i = 0; i < 3; i++) {
            if (torres[torre][i] != 0) {
                return torres[torre][i];
            }
        }
        return -1;
    }

    private void quitarDisco(int torre) {
        for (int i = 0; i < 3; i++) {
            if (torres[torre][i] != 0) {
                torres[torre][i] = 0;
                break;
            }
        }
    }

    private void ponerDisco(int torre, int disco) {
        for (int i = 2; i >= 0; i--) {
            if (torres[torre][i] == 0) {
                torres[torre][i] = disco;
                break;
            }
        }
    }

    private boolean juegoCompleto() {
        for (int i = 0; i < 2; i++) {
            if (torres[2][i] == 0) return false;
        }
        return true;
    }

    private void mostrarTorres() {
        System.out.println("\nEstado actual de las torres:");
        for (int fila = 0; fila < 3; fila++) {
            for (int t = 0; t < 3; t++) {
                if (torres[t][fila] == 0) {
                    System.out.print(" | ");
                } else {
                    System.out.print(" " + torres[t][fila] + " ");
                }
            }
            System.out.println();
        }
        System.out.println(" 0   1   2\n");
    }
}