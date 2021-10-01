package BAB9_BinaryTree;

import java.util.*;

class Node {

    int data;
    String dt;
    Node nodeKiri;
    Node nodeKanan;

    public Node(int dt) {
        data = dt;
        nodeKiri = nodeKanan = null;
    }

    public void sisipDt(int dtSisip) {
        if (dtSisip < data) {
            if (nodeKiri == null) {
                nodeKiri = new Node(dtSisip);
            } else {
                nodeKiri.sisipDt(dtSisip);
            }
        } else if (dtSisip > data) {
            if (nodeKanan == null) {
                nodeKanan = new Node(dtSisip);
            } else {
                nodeKanan.sisipDt(dtSisip);
            }
        }
    }

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

public class Tree {

    private Node root;
    private int jumSimpul = 0, daun = 0;

    public Tree() {
        root = null;
    }

    public void sisipDtNode(int dtSisip) {
        if (root == null) {
            root = new Node(dtSisip);
        } else {
            root.sisipDt(dtSisip);
        }
    }

    public void sisipDtNode(String dtSisip) {
        if (root == null) {
            root = new Node(dtSisip);
        } else {
            root.sisipDt(dtSisip);
        }
        System.out.print(dtSisip + " ");
    }

    public void preorderTraversal() {
        preorder(root);
    }

    private void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.printf("%d ", node.data);
        preorder(node.nodeKiri);
        preorder(node.nodeKanan);
    }

    public void inorderTraversal() {
        inorder(root);
    }

    private void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.nodeKiri);
        System.out.printf("%d ", node.data);
        inorder(node.nodeKanan);
    }

    public void postorderTraversal() {
        postorder(root);
    }

    private void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.nodeKiri);
        postorder(node.nodeKanan);
        System.out.printf("%d ", node.data);
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

    public static void main(String args[]) {
        Tree Tree = new Tree();
        int nilai;
        Random randomNumber = new Random();
        System.out.println("sisip nilai data berikut : ");
// sisipDt 10 bilangan acak dari 0-99 ke dalam tree
        for (int i = 1; i <= 10; i++) {
            nilai = randomNumber.nextInt(100);
            System.out.print(nilai + " ");
            Tree.sisipDtNode(nilai);
        }
        System.out.println("\nPreorder traversal");
        Tree.preorderTraversal();
        System.out.println("\nInorder traversal");
        Tree.inorderTraversal();
        System.out.println("\nPostorder traversal");
        Tree.postorderTraversal();
        System.out.println();
        System.out.println("===========================");
        Tree bst = new Tree();
        System.out.println("Inputan Kedua : ");
        bst.sisipDtNode("N");
        bst.sisipDtNode("A");
        bst.sisipDtNode("D");
        bst.sisipDtNode("B");
        System.out.println("\nPreorder traversal");
        bst.preorderTraversalString();
        System.out.println("\nInorder traversal");
        bst.inorderTraversalString();
        System.out.println("\nPostorder traversal");
        bst.postorderTraversalString();
        System.out.println();
        System.out.println("Jumlah Simpul      : " + bst.jumSimpul());
        System.out.println("Jumlah Kedalaman   : " + bst.jumSimpul());
        System.out.println("Jumlah Jumlah Daun : " + bst.jumSimpul());
    }
}