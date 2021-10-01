package UAP;

import java.util.Scanner;

public class SingleLinkedList {

    private Node head;
    private Node tail;

    public void tambahData(Mahasiswa data) {
        Node n = new Node();
        n.data = data;
        if (tail == null) {
            tail = head = n;
        } else {
            tail.pointer = n;
            tail = n;
        }
    }

    public void cetakData() {
        Node n = head;
        if (head == null) {
            System.out.println("Data Kosong!");
        }
        while (n != null) {
            System.out.print(n.data);
            n = n.pointer;
        }

    }

    public void cetakProgStudi(String progStudi) {
        Node n = head;
        if (head == null) {
            System.out.println("Data Kosong!");
        }
        while (n != null) {
            if (n.data.getProgramStudi().equalsIgnoreCase(progStudi)) {
                System.out.print(n.data);
            }
            n = n.pointer;
        }
    }

    public void findMahasiswa(String nim) {
        Node n = head;
        if (head == null) {
            System.out.println("Data Kosong!");
        }
        while (n != null) {
            if (n.data.getNim().equals(nim)) {
                System.out.print(n.data);
            }
            n = n.pointer;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList ssl = new SingleLinkedList();
        String nama, nim, ps;
        boolean x = true;
        while (x) {
            Scanner in = new Scanner(System.in);
            System.out.println("--------------DATA MAHASISWA--------------");
            System.out.println("1. Tambah Data");
            System.out.println("2. Cetak Data");
            System.out.println("3. Cetak Data Berdasarkan Program Studi");
            System.out.println("4. Mencari Data Berdasarkan NIM");
            System.out.println("5. Keluar");
            System.out.print("Masukkan Pilihan = ");
            int p = in.nextInt();
            switch (p) {
                case 1:
                    System.out.print("Masukkan Nama = ");
                    nama = in.next();
                    System.out.print("Masukkan NIM = ");
                    nim = in.next();
                    System.out.print("Masukkan Program Studi = ");
                    ps = in.next();
                    Mahasiswa mhs = new Mahasiswa(nama, nim, ps);
                    ssl.tambahData(mhs);
                    break;
                case 2:
                    ssl.cetakData();
                    break;
                case 3:
                    System.out.print("Masukkan Program Studi = ");
                    ps = in.next();
                    ssl.cetakProgStudi(ps);
                    break;
                case 4:
                    System.out.print("Masukkan NIM = ");
                    nim = in.next();
                    ssl.findMahasiswa(nim);
                    break;
                case 5:
                    x = false;
            }
        }
    }
}