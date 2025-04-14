package juegos;

import juegos.hanoi.TorresDeHanoi;
import juegos.reinas.NReinas;
import juegos.caballo.MovimientoCaballo;

public class Main {
    public static void main(String[] args) {
        TorresDeHanoi juegoHanoi = new TorresDeHanoi();
        juegoHanoi.jugar();

        NReinas juegoReinas = new NReinas();
        juegoReinas.jugar();

        MovimientoCaballo juegoCaballo = new MovimientoCaballo();
        juegoCaballo.jugar();
    }
}