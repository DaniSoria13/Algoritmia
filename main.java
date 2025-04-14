// src/Main.java

import hanoi.TorresDeHanoi;
import reinas.NReinas;
import caballo.CaballoTeclado;

import java.util.Scanner;

public class main {
    public static <TorresHanoi> void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione un problema:");
        System.out.println("1. Torres de Hanoi");
        System.out.println("2. N Reinas");
        System.out.println("3. Movimientos del Caballo en teclado numérico");
        System.out.print("Opción: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("\nResolviendo Torres de Hanoi con 3 discos:");
                TorresHanoi hanoi = new TorresHanoi();
                TorresDeHanoi.resolver();
                break;
            case 2:
                System.out.print("Ingrese el número de reinas (N): ");
                int nReinas = sc.nextInt();
                Object NReinas = null;
                NReinas reinas = new NReinas(null);
                if (!reinas.resolver()) {
                    System.out.println("No hay solución.");
                }
                break;
            case 3:
                System.out.print("Ingrese la cantidad de movimientos del caballo: ");
                int pasos = sc.nextInt();
                CaballoTeclado caballo = new CaballoTeclado();
                int total = caballo.contarMovimientos(pasos);
                System.out.println("Total de movimientos válidos para " + pasos + " paso(s): " + total);
                break;
            default:

                System.out.println("Opción inválida.");
        }

        sc.close();
    }
}
