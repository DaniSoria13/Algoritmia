package TorresHanoi;

public class Hanoi {
    private int[][] torres = new int[3][3]; // torres[fila][columna]
    private int movimientos = 0;

    public void torresdehanoi() {
        // Colocar los discos en la torre A (columna 0), desde la base hacia arriba
        torres[0][0] = 3;
        torres[1][0] = 2;
        torres[2][0] = 1;
    }


}
