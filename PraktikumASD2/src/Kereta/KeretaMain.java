package Kereta;

public class KeretaMain {

    public static void main(String[] args) {
        Kereta k = new Kereta();
        k.tambahKepala("data gerbong 2");
        k.tambahKepala("data gerbong 3");
        k.tambahKepala("data gerbong 4");
        k.tambahEkor("data gerbong 1");
        k.cetakGerbong();
    }
}