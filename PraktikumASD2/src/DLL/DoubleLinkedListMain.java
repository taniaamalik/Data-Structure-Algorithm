package DLL;

import java.util.Scanner;

public class DoubleLinkedListMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pilihan;
        DoubleLinkedList dll = new DoubleLinkedList();
        do {
            System.out.println("=====================================");
            System.out.printf("%23s\n", "DAFTAR MENU");
            System.out.println("=====================================");
            System.out.println("0. Keluar");
            System.out.println("1. Tambah Buku di depan");
            System.out.println("2. Tambah Buku di belakang");
            System.out.println("3. Menampilkan Buku");
            System.out.println("4. Sisip Buku Terurut");
            System.out.println("5. Hapus Buku Tertentu");
            System.out.println("-------------------------------------");
            System.out.print("Masukkan pilihan : ");
            pilihan = in.nextInt();
            in.nextLine();
            switch (pilihan) {
                case 0:
                    System.out.print("Terima Kasih Atas Kunjungannya");
                    break;
                case 1:
                    System.out.print("Masukkan Judul Buku : ");
                    String judul = in.nextLine();
                    System.out.print("Masukkan Kategori Buku : ");
                    String kategori = in.nextLine();
                    System.out.print("Masukkan Harga Sewa : ");
                    double hargaSewa = in.nextDouble();
                    in.nextLine();
                    System.out.print("Masukkan Harga Denda : ");
                    double hargaDenda = in.nextDouble();
                    in.nextLine();
                    dll.sisipDipKepala(new Buku(kategori, judul, hargaSewa, hargaDenda));
                    break;
                case 2:
                    System.out.print("Masukkan Judul Buku : ");
                    judul = in.nextLine();
                    System.out.print("Masukkan Kategori Buku : ");
                    kategori = in.nextLine();
                    System.out.print("Masukkan Harga Sewa : ");
                    hargaSewa = in.nextDouble();
                    in.nextLine();
                    System.out.print("Masukkan Harga Denda : ");
                    hargaDenda = in.nextDouble();
                    in.nextLine();
                    dll.sisipDipEkor(new Buku(kategori, judul, hargaSewa, hargaDenda));
                    break;
                case 3:
                    dll.cetak("List Buku");
                    break;
                case 4:
                    System.out.print("Masukkan Judul Buku : ");
                    judul = in.nextLine();
                    System.out.print("Masukkan Kategori Buku : ");
                    kategori = in.nextLine();
                    System.out.print("Masukkan Harga Sewa : ");
                    hargaSewa = in.nextDouble();
                    in.nextLine();
                    System.out.print("Masukkan Harga Denda : ");
                    hargaDenda = in.nextDouble();
                    in.nextLine();
                    dll.sisipDataTerurut(new Buku(kategori, judul, hargaSewa, hargaDenda));
                    break;
                case 5:
                    System.out.print("Masukkan Judul yang ingin dihapus : ");
                    judul = in.nextLine();
                    dll.hapusDataTertentu(new Buku(judul));
                    break;
            }
            System.out.println();
        } while (pilihan < 6 && pilihan > 0);
    }
}