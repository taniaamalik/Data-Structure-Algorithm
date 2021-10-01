package OOP;

import java.util.Scanner;

public class BukuMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Buku[] bk = new Buku[5];
        bk[0] = new Buku("Sinchan", "Komik", 1500, 150);
        bk[1] = new Buku("Twilight", "Novel", 2000, 200);
        bk[2] = new Buku("Sangkuriang", "Cerita Legenda", 1000, 100);
        bk[3] = new Buku("Metabolisme", "Ilmu Pengetahuan", 3000, 300);
        bk[4] = new Buku("Ideologi Hukum", "Filsafat", 2500, 250);
        for (int i = 0; i < 10;) {
            System.out.println("********************************************");
            System.out.println("*              SELAMAT DATANG              *");
            System.out.println("********************************************");
            System.out.println("1. Daftar Buku");
            System.out.println("2. Data Peminjaman");
            System.out.println("3. Keluar");
            System.out.println("--------------------------------------------");
            System.out.print("Pilihan : ");
            int pil = in.nextInt();
            switch (pil) {
                case 1:
                    for (int j = 0; j < bk.length; j++) {
                        System.out.println("--------------------------------------------");
                        bk[j].getBuku();
                    }
                    break;
                case 2:
                    System.out.println("--------------------------------------------");
                    System.out.print("Banyaknya Buku Yang dipinjam : ");
                    int banyak = in.nextInt();
                    for (int j = 0; j < banyak; j++) {
                        System.out.println("............................................");
                        System.out.println("Pilih Buku =");
                        System.out.println("0. Keluar");
                        System.out.println("1. Sinchan");
                        System.out.println("2. Twilight");
                        System.out.println("3. Sangkuriang");
                        System.out.println("4. Metabolisme");
                        System.out.println("5. Ideologi Hukum");
                        System.out.println("............................................");
                        System.out.print("Pilihan : ");
                        int p = in.nextInt();
                        System.out.println("--------------------------------------------");
                        if (p > 0 && p < 6) {
                            System.out.print("Lama Peminjaman : ");
                            bk[p - 1].setLamaPeminjaman(in.nextInt());
                            System.out.print("Telat Mengembalikan : ");
                            bk[p - 1].setTelatPengembalian(in.nextInt());
                            System.out.println("============================================");
                            bk[p - 1].DisplayMessage();
                            System.out.println("============================================");
                        } else if (p == 0) {
                            System.exit(0);
                        } else {
                            System.out.println("Maaf, pilihan yang anda masukan tidak ada");
                        }
                    }
                    break;
                case 3:
                    System.out.println("                 TERIMAKASIH                ");
                    System.exit(0);
            }
        }
    }
}