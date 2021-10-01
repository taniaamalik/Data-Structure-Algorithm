package Latihan;

public class Kereta {

    private class Node {

        String data;
        Node pointer;
    }

    private Node kepala;
    private Node ekor;

    public void tambahKepala(String data) {
        Node node = new Node();
        node.data = data;

        if (kepala == null) {
            kepala = ekor = node;
            return;
        }

        node.pointer = kepala;
        kepala = node;
    }

    public void tambahEkor(String data) {
        Node node = new Node();
        node.data = data;

        if (kepala == null) {
            kepala = ekor = node;
            return;
        }

        ekor.pointer = node;
        ekor = node;
    }

    public boolean cariGerbong(String data) {
        Node node = kepala;

        while (node != null) {
            if (node.data.equals(data)) {
                return true;
            }
            node = node.pointer;
        }

        return false;
    }

    public void cetakGerbong() {
        Node node = kepala;

        while (node != null) {
            System.out.print(node.data + " => ");
            node = node.pointer;
        }
    }

    public static void main(String[] args) {
        Kereta kereta = new Kereta();
        kereta.tambahKepala("data gerbong 2");
        kereta.tambahKepala("data gerbong 3");
        kereta.tambahKepala("data gerbong 4");
        kereta.tambahEkor("data gerbong 1");
        kereta.cetakGerbong();
    }

}