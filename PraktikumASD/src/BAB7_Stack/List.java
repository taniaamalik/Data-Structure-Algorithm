package BAB7_Stack;

public class List {

    private Node head;
    private Node tail;
    private String nama;

    public List() {
        this("list");
    }

    public List(String namaList) {
        nama = namaList;
        head = tail = null;
    }

    public void move() {
        if (!isEmpty()) {
            head = head.next;
            tail = tail.next;
        }
    }

    public void addFirst(Object data) {
        Node baru = new Node(data);
        if (isEmpty()) {
            head = tail = baru;
        } else {
            baru.next = head;
            head.prev = baru;
            baru.prev = tail;
            head = baru;
        }
        head.prev = tail;
        tail.next = head;
    }

    public void addLast(Object data) {
        Node baru = new Node(data);
        if (isEmpty()) {
            head = tail = baru;
        } else {
            baru.next = head;
            tail.next = baru;
            baru.prev = tail;
            tail = baru;
        }
        head.prev = tail;
        tail.next = head;
    }

    public Object removeFirst() {
        Object itemDihapus = null;
        if (!isEmpty()) {
            itemDihapus = head.data;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
                head.prev = tail;
            }
            return itemDihapus;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void cetak() {
        if (isEmpty()) {
            System.out.printf("%s Kosong\n", nama);
            return;
        }
        System.out.printf("Queue %s adalah : ", nama);
        Node pointer = head;
        while (pointer.next != head) {
            System.out.printf("%s -> ", pointer.data);
            pointer = pointer.next;
        }
        System.out.printf("%s ", tail.data);
        System.out.println("\n");
    }

    public Node getHead() {
        return head;
    }
}