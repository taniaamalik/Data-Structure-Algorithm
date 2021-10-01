package Tugas1;

public class Node {

    Object data;
    Node pointer;

    Node() {

    }

    Node(Object data) {
        this.data = data;
    }

    Node(Object data, Node pointer) {
        this.data = data;
        this.pointer = pointer;
    }
    
}