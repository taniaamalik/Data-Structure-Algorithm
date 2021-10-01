package Latihan;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("NIM : ");
        String nim = in.nextLine();

        Tree t = new Tree();
        String angka[] = new String[nim.length()];
        for (int i = 0; i < nim.length(); i++) {
            angka[i] = nim.substring(i, i + 1);
            Node n = new Node(angka[i]);
            t.sisipDtNode(angka[i]);
        }
        System.out.println("\nPreorder traversal");
        t.preorderTraversalString();
        System.out.println("\nInorder traversal");
        t.inorderTraversalString();
        System.out.println("\nPostorder traversal");
        t.postorderTraversalString();
        System.out.println();
        System.out.println("Jumlah Simpul      : " + t.jumSimpul());
        System.out.println("Jumlah Kedalaman   : " + t.jumSimpul());
        System.out.println("Jumlah Jumlah Daun : " + t.jumSimpul());
    }
}