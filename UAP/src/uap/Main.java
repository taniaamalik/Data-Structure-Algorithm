package uap;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BubbleSort bs = new BubbleSort();
        boolean x = true;
        do {
            System.out.print("Masukkan nama pegawai baru : ");
            bs.buatNode(System.currentTimeMillis(), in.nextLine());
            System.out.print("Ingin memasukkan data lagi? (y/n) ");
            String pil = in.nextLine();
            bs.bubbleSort();
            if (pil.equals("n")) {
                x = false;
            }
        } while (x == true);
    }
}