package juegos;

import juegos.hanoi.TorresDeHanoi;
import juegos.reinas.NReinas;
import juegos.caballo.MovimientoCaballo;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Juegos ---");
            System.out.println("1. Torres de Hanoi");
            System.out.println("2. N Reinas");
            System.out.println("3. Movimiento del Caballo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    TorresDeHanoi juegoHanoi = new TorresDeHanoi();
                    juegoHanoi.jugar();
                }
                case 2 -> {
                    NReinas juegoReinas = new NReinas();
                    juegoReinas.jugar();
                }
                case 3 -> {
                    MovimientoCaballo juegoCaballo = new MovimientoCaballo();
                    juegoCaballo.jugar();
                }
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }
}