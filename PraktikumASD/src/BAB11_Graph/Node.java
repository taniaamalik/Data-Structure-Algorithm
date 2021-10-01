package BAB11_Graph;

public class Node {

    private int data;
    private Node next;
    private int jarak;

    public Node(int dt, Node n) {
        data = dt;
        next = n;
    }

    public Node(int dt, Node n, int jrk) {
        this(dt, n);
        jarak = jrk;
    }

    public int getDt() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public int getJarak() {
        return jarak;
    }
}