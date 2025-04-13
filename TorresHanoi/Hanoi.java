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
}

}
