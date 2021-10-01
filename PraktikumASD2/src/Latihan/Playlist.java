package Latihan;

import java.util.Scanner;

class Music {

    Music prev, next;
    String namaMusik;
}

public class Playlist {

    Music head, tail;
    int size = 0;

    Playlist() {
        head = null;
        tail = null;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void addPlaylist(String namaMusik) {
        Music baru = new Music();
        baru.namaMusik = namaMusik;

        if (isEmpty()) {
            head = tail = baru;
            baru.next = baru.prev = baru;
        } else {
            baru.next = head;
            baru.prev = tail;
            head.prev = baru;
            tail.next = baru;
            head = baru;
        }
        size++;
    }

    void playPlaylist() {
        Scanner inp = new Scanner(System.in);
        boolean wow = true;

        Music x = tail;
        while (wow) {
            if (isEmpty()) {
                System.out.println("Belum ada musik di dalam playlist!");
                wow = false;
            } else {
                System.out.println("Memainkan musik " + x.namaMusik + "...");
                System.out.println("1. next");
                System.out.println("2. prev");
                System.out.println("3. keluar");
                int m = inp.nextInt();
                if (m == 1) {
                    x = x.prev;
                } else if (m == 2) {
                    x = x.next;
                } else if (m == 3) {
                    wow = false;
                } else {
                    System.out.println("Pilihan salah!");
                }
            }
        }
    }

    void cetak() {
        Music n = tail;
        int a = 0;
        if (isEmpty()) {
            System.out.println("belum ada musik di dalam playlist!");
        }
        while (a < size) {
            System.out.println("-> " + n.namaMusik);
            a++;
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        Playlist yey = new Playlist();
        boolean uye = true;
        while (uye) {
            System.out.println("------- MUSIC PLAYER -------");
            System.out.println("1. Tambah musik dalam playlist");
            System.out.println("2. Play playlist");
            System.out.println("3. Lihat playlist");
            System.out.println("4. Keluar");
            System.out.print("input = ");
            int input = inp.nextInt();
            if (input == 1) {
                System.out.print("Nama musik = ");
                String nama = inp.next();
                yey.addPlaylist(nama);
            } else if (input == 2) {
                yey.playPlaylist();
            } else if (input == 3) {
                yey.cetak();
            } else if (input == 4) {
                uye = false;
            } else {
                System.out.println("Pilihan salah");
            }
        }
    }
}