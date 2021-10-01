package Latihan;

public class Node {

    String dt;
    Node nodeKiri;
    Node nodeKanan;

    public Node(String dt) {
        this.dt = dt;
        nodeKiri = nodeKanan = null;
    }

    public void sisipDt(String dtSisip) {
        if (dtSisip.compareToIgnoreCase(dt) < 0) {
            if (nodeKiri == null) {
                nodeKiri = new Node(dtSisip);
            } else {
                nodeKiri.sisipDt(dtSisip);
            }
        } else if (dtSisip.compareToIgnoreCase(dt) > 0) {
            if (nodeKanan == null) {
                nodeKanan = new Node(dtSisip);
            } else {
                nodeKanan.sisipDt(dtSisip);
            }
        }
    }
}