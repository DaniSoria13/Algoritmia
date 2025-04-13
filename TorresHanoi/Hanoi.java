package TorresHanoi;

public class Hanoi {
    public void resolver(int n, char origen, char auxiliar, char destino) {
        if (n == 1) {
            System.out.println("Mover disco 1 de " + origen + " a " + destino);
            return;
        }
        resolver(n - 1, origen, destino, auxiliar);
        System.out.println("Mover disco " + n + " de " + origen + " a " + destino);
        resolver(n - 1, auxiliar, origen, destino);
    }
}
