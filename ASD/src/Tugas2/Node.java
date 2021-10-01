package Tugas2;

public class Node {

    Object barang, kode;
    Node next, prev;

    Node() {

    }

    Node(Object barang, Object kode) {
        this.barang = barang;
        this.kode = kode;
    }

    Node(Object barang, Object kode, Node next, Node prev) {
        this.barang = barang;
        this.kode = kode;
        this.next = next;
        this.prev = prev;
    }

}