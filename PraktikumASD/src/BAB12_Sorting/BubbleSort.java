package BAB12_Sorting;

public class BubbleSort {

    private Node head;
    private Node tail;
    private int count = 0;

    public void buatNode(int dt) {
        Node nodeBaru = new Node();
        nodeBaru.data = dt;
        if (head == null) {
            head = nodeBaru;
        } else {
            tail.next = nodeBaru;
        }
        tail = nodeBaru;
        count++;
    }

    public void bubbleSort() {
        System.out.println("Urutan awal :");
        this.cetak(null);
        for (int i = 0; i < count - 1; i++) {
            System.out.println("Langkah " + (i + 1) + ":");
            Node before = head;
            Node after = head.next;
            int temp;
            while (after != null) {
                if (before.data > after.data) {
                    temp = before.data;
                    before.data = after.data;
                    after.data = temp;
                }
                this.cetak(after.next);
                before = before.next;
                after = after.next;
            }
        }
    }

    public void cetak(Node dt) {
        Node n = head;
        while (n != dt) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}