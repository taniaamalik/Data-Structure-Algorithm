package Tugas1;

public class SingleLL {
    Node head, tail;
    int size = 0;

    boolean isEmpty() {
        return (size == 0);
    }

    void addFirst(Node input) {
        if (isEmpty()) {
            head = tail = input;
        } else {
            input.pointer = head;
            head = input;
        }
        size++;
    }

    void addLast(Node input) {
        if (isEmpty()) {
            head = tail = input;
        } else {
            tail.pointer = input;
            tail = input;
        }
        size++;
    }

    void insertAfter(Object key, Node input) {
        Node temp = head;
        do {
            if (temp.data == key) {
                input.pointer = temp.pointer;
                temp.pointer = input;
                size++;
                break;
            }
            temp = temp.pointer;
        } while (temp != null);
    }

    void removeFirst() {
        Node temp = head;
        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                temp = temp.pointer;
                head = temp;
                temp = null;
            }
            size--;
        } else {
            System.out.println("Data kosong!");
        }
    }

    void removeLast() {
        Node temp = head;
        if (!isEmpty()) {
            if (tail == head) {
                head = tail = null;
            } else {
                while (temp.pointer != tail) {
                    temp = temp.pointer;
                }
                temp.pointer = null;
                tail = temp;
                temp = null;
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
                if (temp.pointer.data == key) {
                    temp.pointer = temp.pointer.pointer;
                    if (temp.pointer == null) {
                        tail = temp;
                    }
                    break;
                } else if ((temp.data == key) && (temp == head)) {
                    this.removeFirst();
                    break;
                }
                temp = temp.pointer;
            }
        } else {
            System.out.println("Data kosong!");
        }
        size--;
    }

    void cetakSLL(String kata) {
        System.out.println(kata);
        Node c = head;
        while (c != null) {
            System.out.print(c.data + " ");
            c = c.pointer;
        }
        System.out.println();
        System.out.println();
    }
    
}