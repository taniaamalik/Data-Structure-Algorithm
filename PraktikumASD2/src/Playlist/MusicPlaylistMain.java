package Playlist;

import java.util.Scanner;

public class MusicPlaylistMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MusicPlaylist mp = new MusicPlaylist();
        boolean b = true;
        while (b) {
            System.out.println("------- MUSIC PLAYER -------");
            System.out.println("1. Tambah musik dalam playlist");
            System.out.println("2. Play playlist");
            System.out.println("3. Next");
            System.out.println("4. Prev");
            System.out.println("5. Lihat playlist");
            System.out.println("6. Keluar");
            System.out.print("input = ");
            int input = in.nextInt();
            if (input == 1) {
                System.out.print("Judul = ");
                String jdl = in.next();
                System.out.print("Penyanyi = ");
                String pnynyi = in.next();
                mp.addPlaylist(jdl, pnynyi);
            } else if (input == 2) {
                mp.playPlaylist();
            } else if (input == 3) {
                mp.next();
            } else if (input == 4) {
                mp.prev();
            } else if (input == 5) {
                mp.cetak();
            } else if (input == 6) {
                b = false;
            } else {
                System.out.println("Pilihan salah");
            }
        }
    }
}