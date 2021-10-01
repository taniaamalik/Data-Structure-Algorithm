package Latihan;

import java.util.Scanner;

public class MusicPlaylist {

    public class Music {

        String judul;
        String pencipta;
    }

    private class Node {

        Music data;
        Node next;
        Node prev;
    }

    // Gaperlu tail karena head bisa juga berlaku sebagai tail di circular linked list
    //(head.prev) sama dengan (tail)
    private Node head;
    // Lagu yang sekarang diputar bisa disimpan di variabel nowPlaying
    private Node nowPlaying;

    // Sama seperti konsep add tail
    public void addMusic(String judul, String pencipta) {
        Node node = new Node();
        Music music = new Music();
        music.judul = judul;
        music.pencipta = pencipta;
        node.data = music;

        if (head == null) {
            node.next = node;
            node.prev = node;
            head = nowPlaying = node;
            return;
        }

        node.next = head;
        node.prev = head.prev;
        head.prev.next = node;
        head.prev = node;
    }

    public void next() {
        nowPlaying = nowPlaying.next;
    }

    public void prev() {
        nowPlaying = nowPlaying.prev;
    }

    public Music getCurrentPlayMusic() {
        return nowPlaying.data;
    }

    public void ui() {
        Node node = new Node();
        node = head;

        boolean isFirst = true;

        while (!(node.data.judul.equals(head.data.judul)
                && node.data.pencipta.equals(head.data.pencipta)
                && !isFirst)) {

            System.out.println(node.data.judul);

            node = node.next;
            isFirst = false;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = 1;

        MusicPlaylist musicPlaylist = new MusicPlaylist();

        do {
            switch (input) {
                case 1:
                    System.out.println("Add Music");
                    System.out.print("Judul: ");
                    String judul = sc.next();
                    System.out.print("Pencipta: ");
                    String pencipta = sc.next();
                    musicPlaylist.addMusic(judul, pencipta);
                    break;
                case 2:
                    musicPlaylist.next();
                    break;
                case 3:
                    musicPlaylist.prev();
                    break;
                default:
                    break;
            }
            System.out.println("\n==============================");
            System.out.print("\nNow Playing: " + musicPlaylist.getCurrentPlayMusic().judul + " oleh " + musicPlaylist.getCurrentPlayMusic().pencipta);
            System.out.print("\n1. Add Music\n2. Next\n3. Prev\n99. Exit\nInput: ");
            input = sc.nextInt();
        } while (input != 99);
    }

}