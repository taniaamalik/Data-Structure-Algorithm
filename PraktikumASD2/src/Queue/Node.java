package Queue;

public class Node {

    Object data;
    Node next, prev;

    Node(Object object) {
        this(object, null, null);
    }

    Node(Object object, Node node, Node node2) {
        data = object;
        next = node;
        prev = node2;
    }

    Object getObject() {
        return data;
    }

    Node getNext() {
        return next;
    }

    Node getPrev() {
        return prev;
    }
}