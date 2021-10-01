package Tugas2;

public class CircularDLLMain {
    public static void main(String[] args) {
        CircularDLL d = new CircularDLL();

        Node n1 = new Node("Pulpen","B001");
        Node n2 = new Node("Pensil","B002");
        Node n3 = new Node("Penggaris","B003");
        Node n4 = new Node("Buku","B004");

        d.addLast(n1);
        d.addLast(n2);
        d.addLast(n3);
        d.addLast(n4);
        d.cetakCircularDLL("CircularDLL Awal Data =");

        Node n5 = new Node("Rautan","B005");
        Node n6 = new Node("Selotip","B006");
        Node n7 = new Node("Gunting","B007");
        Node n8 = new Node("Spidol","B008");

        d.addLast(n5);
        d.addFirst(n6);
        d.insertAfter(n3.barang, n7);
        d.insertBefore(n5.barang, n8);
        d.cetakCircularDLL("CircularDLL Setelah Penambahan Data =");

        d.removeFirst();
        d.removeLast();
        d.remove(n2.barang);
        d.cetakCircularDLL("CircularDLL Setelah Peghapusan Data =");

        d.cetakCircularDLL("CircularDLL Data =");
    }
}