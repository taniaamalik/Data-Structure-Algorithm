package BAB7_Stack;

public class Node {

    Object data;
    Node next;
    Node prev;

    public Node(Object data) {
        this.data = data;
    }

    Object getObject() {
        return data;
    }

    Node getNext() {
        return next;
    }
}