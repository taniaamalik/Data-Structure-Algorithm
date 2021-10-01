package BAB10_AVLTree;

import java.util.Random;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        AVLTree avl = new AVLTree();
        Random randomNumber = new Random();
        int pilih, nilai;
        int n1 = 1;
        int n2 = 1;
        int node = 2;
        do {
            System.out.println("********************************");
            System.out.println("0. Keluar");
            System.out.println("1. Masukkan Data");
            System.out.println("2. Hapus Data");
            System.out.println("3. Cari Data");
            System.out.print("Masukkan Pilihan Anda : ");
            pilih = in.nextInt();
            System.out.println("********************************");
            switch (pilih) {
                case 1:
                    System.out.print("Masukkan level node: ");
                    int level = in.nextInt();
                    if (level == 0) {
                        node = 1;
                    }
                    for (int i = 1; i < level; i++) {
                        int n3 = n1 + n2;
                        n1 = n2;
                        n2 = n3;
                        node = n3 + node;
                    }
                    System.out.println("================================");
                    System.out.println("Jumlah minimal node: " + node);
                    System.out.println("Urutan nilai node yang mungkin: ");
                    for (int i = 0; i < node; i++) {
                        nilai = randomNumber.nextInt(100);
                        avl.akar = avl.insert(avl.akar, nilai);
                    }
                    System.out.println(">Preorder Result");
                    avl.preOrder(avl.akar);
                    System.out.println("\n>Inorder Result");
                    avl.inOrder(avl.akar);
                    System.out.println("\n================================");
                    break;
                case 2:
                    System.out.print("Masukkan Data : ");
                    avl.delete(in.nextInt());
                    System.out.println("================================");
                    System.out.println(">Preorder Result");
                    avl.preOrder(avl.akar);
                    System.out.println("\n>Inorder Result");
                    avl.inOrder(avl.akar);
                    System.out.println("\n================================");
                    break;
                case 3:
                    System.out.print("Masukkan Data : ");
                    avl.Find(avl.akar, in.nextInt());
                    System.out.println("================================");
                    break;
            }
        } while (pilih != 0);
    }
}