package Tugas2;

public class CircularDLL {

    Node head, tail;
    int size = 0;

    boolean isEmpty() {
        return (size == 0);
    }

    void addFirst(Node input) {
        if (isEmpty()) {
            input.next = input.prev = input;
            head = input;
            tail = head;
        } else {
            input.next = head;
            input.prev = tail;
            head.prev = input;
            tail.next = input;
            head = input;
        }
        size++;
    }

    void addLast(Node input) {
        if (isEmpty()) {
            input.next = input.prev = input;
            head = input;
            tail = head;
        } else {
            input.prev = tail;
            input.next = head;
            tail.next = input;
            head.prev = input;
            tail = input;
        }
        size++;
    }

    void insertAfter(Object key, Node input) {
        Node temp = head;
        do {
            if (temp.barang == key) {
                input.prev = temp;
                input.next = temp.next;
                temp.next.prev = input;
                temp.next = input;
                head.prev = tail;
                tail.next = head;
                size++;
                break;
            }
            temp = temp.next;
        } while (temp != null);
    }

    void insertBefore(Object key, Node input) {
        Node temp = head;
        while (temp != null) {
            if (temp.barang == key) {
                if (temp == head) {
                    this.addFirst(input);
                    size++;
                    break;
                } else {
                    input.prev = temp.prev;
                    input.next = temp;
                    temp.prev.next = input;
                    temp.prev = input;
                    head.prev = tail;
                    tail.next = head;
                    size++;
                    break;
                }
            }
            temp = temp.next;
        }
    }

    void removeFirst() {
        Node temp = head;
        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                head.next.prev = null;
                head = temp.next;
                head.prev = tail;
                tail.next = head;
            }
            size--;
        } else {
            System.out.println("Data kosong!");
        }
    }

    void removeLast() {
        Node temp = tail;
        if (!isEmpty()) {
            if (tail == head) {
                head = tail = null;
            } else {
                tail.prev.next = null;
                tail = temp.prev;
                tail.next = head;
                head.prev = tail;
            }
            size--;
        } else {
            System.out.println("Data kosong!");
        }
    }

    void remove(Object key) {
        Node temp = head;
        if (!isEmpty()) {
            while (temp != null) {
                if (temp.barang == key) {
                    if (temp == head) {
                        this.removeFirst();
                        size--;
                        break;
                    } else {
                        if (temp.next == null) {
                            tail = temp.prev;
                            tail.next = head;
                            head.prev = tail;
                        } else {
                            temp.prev.next = temp.next;
                            temp.next.prev = temp.prev;
                            tail.next = head;
                            head.prev = tail;
                        }
                        size--;
                        break;
                    }
                }
                temp = temp.next;
            }
        } else {
            System.out.println("Data kosong!");
        }
        size--;
    }

    void cetakCircularDLL(String kata) {
        System.out.println(kata);
        Node p = head;
        while(p != tail) {
            System.out.println(p.barang + " - " + p.kode);
            p = p.next;
        }if (p==tail){
            System.out.println(tail.barang + " - " + tail.kode);
        }
        System.out.println();
    }
}