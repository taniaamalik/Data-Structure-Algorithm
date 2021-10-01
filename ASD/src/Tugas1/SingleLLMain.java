package Tugas1;

public class SingleLLMain {

    public static void main(String[] args) {
        SingleLL s = new SingleLL();
        
        Node n1 = new Node(100);
        Node n2 = new Node(200);
        Node n3 = new Node(300);
        Node n4 = new Node(400);
        
        s.addLast(n1);
        s.addLast(n2);
        s.addLast(n3);
        s.addLast(n4);
        s.cetakSLL("SLL Awal Data =");

        Node n5 = new Node(500);
        Node n6 = new Node(50);
        Node n7 = new Node(250);

        s.addLast(n5);
        s.addFirst(n6);
        s.insertAfter(n2.data, n7);
        s.cetakSLL("SLL Setelah Penambahan Data =");

        s.removeFirst();
        s.removeLast();
        s.remove(n3.data);
        s.cetakSLL("SLL Setelah Peghapusan Data =");

        s.cetakSLL("SLL Data =");
    }

}