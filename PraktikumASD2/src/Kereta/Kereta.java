package Kereta;

public class Kereta {

    private Node head;
    private Node tail;

    void tambahKepala(String data) {
        Node nodeBaru = new Node();
        nodeBaru.data = data;
        if (head == null) {
            head = tail = nodeBaru;
        }
        nodeBaru.pointer = head;
        head = nodeBaru;
    }

    void tambahEkor(String data) {
        Node nodeBaru = new Node();
        nodeBaru.data = data;
        if (tail == null) {
            tail = head = nodeBaru;
        }
        tail.pointer = nodeBaru;
        tail = nodeBaru;
    }

    boolean findGerbong(String data) {
        Node nodeBaru = head;
        while (nodeBaru != null) {
            if (nodeBaru.data.equalsIgnoreCase(data)) {
                return true;
            }
            nodeBaru = nodeBaru.pointer;
        }
        return false;
    }

    void cetakGerbong() {
        Node nodeBaru = head;
        while (nodeBaru != null) {
            System.out.print(nodeBaru.data + " => ");
            nodeBaru = nodeBaru.pointer;
        }
    }
}