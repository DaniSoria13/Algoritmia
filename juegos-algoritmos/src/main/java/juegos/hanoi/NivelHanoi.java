package juegos.hanoi;

public class NivelHanoi {
    private int nivel;

    public NivelHanoi(int nivel) {
        if (nivel < 1 || nivel > 5) {
            this.nivel = 1;
        } else {
            this.nivel = nivel;
        }
    }

    public int getNumeroDiscos() {
        return 2 + nivel; // Nivel 1 = 3 discos, Nivel 2 = 4, ..., Nivel 5 = 7
    }
}
