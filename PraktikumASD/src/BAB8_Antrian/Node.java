package BAB8_Antrian;

public class Node {

    Object data;
    Node next;

    Node(Object object) {
        this(object, null);
    }

    Node(Object object, Node node) {
        data = object;
        next = node;
    }

    Object getObject() {
        return data;
    }

    Node getNext() {
        return next;
    }
}