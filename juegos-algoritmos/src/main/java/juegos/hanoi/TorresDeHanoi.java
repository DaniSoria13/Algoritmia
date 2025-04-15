package juegos.hanoi;

public class TorresDeHanoi {
    private int[][] torres;  // Usamos un arreglo bidimensional para las torres
    private int movimientos;

    public void jugar() {
        // Usamos una forma de entrada sencilla sin Scanner y sin excepciones complejas
        System.out.println("--- Torres de Hanoi ---");
        System.out.print("Selecciona nivel (1-5): ");
        int nivel = 1;

        NivelHanoi config = new NivelHanoi(nivel);
        int numDiscos = config.getNumeroDiscos();
        movimientos = 0;
        inicializarTorres(numDiscos);

        // Ejecutar el juego mientras no se hayan movido todos los discos a la torre C
        while (torres[2].length != numDiscos) {
            mostrarTorres();
            System.out.print("Mover de (A, B, C): ");
            String desdeLetra = System.console().readLine().toUpperCase();
            System.out.print("Mover a (A, B, C): ");
            String hastaLetra = System.console().readLine().toUpperCase();

            int desde = letraATorre(desdeLetra);
            int hasta = letraATorre(hastaLetra);

            if (desde == -1 || hasta == -1) {
                System.out.println("Torre inválida. Intenta de nuevo.");
                continue;
            }

            if (torres[desde].length == 0) {
                System.out.println("No hay discos en la torre " + desdeLetra);
                continue;
            }

            int disco = torres[desde][torres[desde].length - 1];
            if (torres[hasta].length > 0 && torres[hasta][torres[hasta].length - 1] < disco) {
                System.out.println("No puedes poner un disco grande sobre uno pequeño.");
                continue;
            }

            // Mover disco de una torre a otra
            torres[hasta] = agregarDisco(torres[hasta], disco);
            torres[desde] = quitarDisco(torres[desde]);
            movimientos++;
        }

        mostrarTorres();
        System.out.println("¡Has completado el juego en " + movimientos + " movimientos!");
    }

    private void inicializarTorres(int numDiscos) {
        torres = new int[3][]; // 3 torres
        for (int i = 0; i < 3; i++) {
            torres[i] = new int[0];  // Inicializamos las torres vacías
        }

        // Colocamos los discos en la torre A (índice 0)
        for (int i = numDiscos; i >= 1; i--) {
            torres[0] = agregarDisco(torres[0], i);
        }
    }

    private int letraATorre(String letra) {
        switch (letra) {
            case "A": return 0;
            case "B": return 1;
            case "C": return 2;
            default: return -1;
        }
    }

    private int[] agregarDisco(int[] torre, int disco) {
        // Creamos un nuevo array para agregar el disco
        int[] nuevaTorre = new int[torre.length + 1];
        System.arraycopy(torre, 0, nuevaTorre, 0, torre.length);
        nuevaTorre[torre.length] = disco;
        return nuevaTorre;
    }

    private int[] quitarDisco(int[] torre) {
        // Si la torre no está vacía, eliminamos el disco superior
        if (torre.length > 0) {
            int[] nuevaTorre = new int[torre.length - 1];
            System.arraycopy(torre, 0, nuevaTorre, 0, nuevaTorre.length);
            return nuevaTorre;
        }
        return torre;  // Si está vacía, no hacemos nada
    }

    private void mostrarTorres() {
        System.out.println("\nEstado actual de las torres:");
        for (int i = 0; i < 3; i++) {
            char torre = (char) ('A' + i);
            System.out.print("Torre " + torre + ": ");
            for (int disco : torres[i]) {
                System.out.print(disco + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------");
    }
}