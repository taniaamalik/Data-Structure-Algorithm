package Playlist;

import java.util.Scanner;

public class MusicPlaylist {

    private Node head;
    private Node tail;

    void addPlaylist(String jdl, String pnyny) {
        Music m = new Music(jdl, pnyny);
        Node nodeBaru = new Node();
        nodeBaru.data = m;
        if (head == null) {
            head.next = head.prev = tail.next = tail.prev = nodeBaru;
        }
        nodeBaru.prev = tail;
        nodeBaru.next = head;
        tail.next = nodeBaru;
        head.prev = nodeBaru;
        tail = nodeBaru;
    }

    void playPlaylist() {
        Music m = new Music();
        Node nodeBaru = new Node();
        Node music = head;
        if (head == null) {
            System.out.println("No Music!");
        } else {
            System.out.println("Now Playing : " + m.getJudul() + " by " + m.getPenyanyi());
        }
    }

    void next() {
        head = head.next;
    }

    void prev() {
        head = head.prev;
    }

    void cetak() {
        Node node = new Node();
        node = head;

        boolean isFirst = true;

        while (!(node.data.getJudul().equals(head.data.getJudul())
                && node.data.getPenyanyi().equals(head.data.getPenyanyi())
                && !isFirst)) {

            System.out.println(node.data.getJudul());

            node = node.next;
            isFirst = false;
        }
    }
}