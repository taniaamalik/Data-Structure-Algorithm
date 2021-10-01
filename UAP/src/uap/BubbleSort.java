package uap;

public class BubbleSort {

    private Node head;
    private Node tail;
    private int count = 0;

    public void buatNode(Long x, String dt) {
        Node nodeBaru = new Node();
        nodeBaru.data = dt;
        nodeBaru.nim = x;
        if (head == null) {
            head = nodeBaru;
        } else {
            tail.next = nodeBaru;
        }
        tail = nodeBaru;
        count++;
    }

    public void bubbleSort() {
        for (int i = 0; i < count - 1; i++) {
            Node before = head;
            Node after = head.next;
            String temp;
            long temp2;
            for (int j = i; j < count; j++) {
                if (after != null) {
                    if (before.data.compareTo(after.data) > 0) {
                        temp = before.data;
                        temp2 = before.nim;
                        before.data = after.data;
                        before.nim = after.nim;
                        after.data = temp;
                        after.nim = temp2;
                    }
                    before = before.next;
                    after = after.next;
                }
            }
        }
        this.cetak();
    }

    public void cetak() {
        Node n = head;
        while (n != tail.next) {
            System.out.print(n.nim + " : " + n.data);
            n = n.next;
            System.out.println();
        }
    }
}