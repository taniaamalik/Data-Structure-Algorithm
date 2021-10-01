package BAB8_Antrian;

public class Node2 {

    Object data;
    Node2 next, prev;

    Node2(Object object) {
        this(object, null, null);
    }

    Node2(Object object, Node2 node, Node2 node2) {
        data = object;
        next = node;
        prev = node2;
    }

    Object getObject() {
        return data;
    }

    Node2 getNext() {
        return next;
    }

    Node2 getPrev() {
        return prev;
    }
}