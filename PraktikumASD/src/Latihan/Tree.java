package Latihan;

import java.util.*;

public class Tree {
    
    private Node root;
    private int jumSimpul = 0, daun = 0;

    public Tree() {
        root = null;
    }
    
    public void sisipDtNode(String dtSisip) {
        if (root == null) {
            root = new Node(dtSisip);
        } else {
            root.sisipDt(dtSisip);
        }
        System.out.print(dtSisip + " ");
    }

    public void preorderTraversalString() {
        preorderString(root);
    }

    private void preorderString(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.dt + " ");
        preorderString(node.nodeKiri);
        preorderString(node.nodeKanan);

    }

    public void inorderTraversalString() {
        inorderString(root);
    }

    private void inorderString(Node node) {
        if (node == null) {
            return;
        }
        inorderString(node.nodeKiri);
        System.out.print(node.dt + " ");
        inorderString(node.nodeKanan);
    }

    public void postorderTraversalString() {
        postorderString(root);
    }

    private void postorderString(Node node) {
        if (node == null) {
            return;
        }
        postorderString(node.nodeKiri);
        postorderString(node.nodeKanan);
        System.out.print(node.dt + " ");
    }

    public int jumSimpul() {
        jumSimpul(root);
        return jumSimpul;
    }

    private void jumSimpul(Node node) {
        if (node == null) {
            return;
        }
        jumSimpul(node.nodeKiri);
        jumSimpul(node.nodeKanan);
        if (node.nodeKanan != null || node.nodeKiri != null) {
            jumSimpul++;
        }
    }

    private int kedalaman(Node t) {
        if (t == null) {
            return -1;
        } else {
            return 1 + Math.max(kedalaman(t.nodeKiri), kedalaman(t.nodeKanan));
        }
    }

    public int kedalaman() {
        return kedalaman(root);
    }

    public int kedalaman(Tree tree) {
        return tree.kedalaman() + 1;
    }

    private int jumDaun(Node t) {
        if (t != null) {
            if ((t.nodeKiri == null) && (t.nodeKanan == null)) {
                return 1;
            } else {
                return jumDaun(t.nodeKiri) + jumDaun(t.nodeKanan);
            }
        }
        return 0;
    }

    public int jumDaun() {
        return jumDaun(root);
    }

}