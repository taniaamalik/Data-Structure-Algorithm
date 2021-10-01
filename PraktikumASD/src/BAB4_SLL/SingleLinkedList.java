package BAB4_SLL;

public class SingleLinkedList {

    private Node head;
    private Node tail;
    // membuat suatu node baru     
    public void sisipDidepan(Buku dt) {
        Node nodeBaru = new Node();
        nodeBaru.data = dt;
        nodeBaru.next = head;
        head = nodeBaru;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        tail = temp;
    }
    // menambah data dt1 setelah data dt2 dalam LL     
    public void sisip(Buku dt1, Buku dt2) {
        /* lengkapi method ini */
        Node nodeBaru = new Node();
        nodeBaru = head;
        while (nodeBaru.next.data != dt2) {
            nodeBaru = nodeBaru.next;
        }
        Node temp = nodeBaru.next.next;
        nodeBaru.next.next.data = dt1;
        nodeBaru.next.next.next = temp;
    }
    // secara normal data dihapus di depan   
    public Buku hapusDiDepan() {
        if (head == tail) {
            tail = null;
        }
        Node hapus = head;
        head = head.next;
        return hapus.data;
    }
    public void hapusDiAkhir() {
        /* lengkapi bagian ini */
        Node nodeBaru = new Node();
        nodeBaru = head;
        if (head == tail) {
            tail = null;
        }
        while (nodeBaru.next != null) {
            nodeBaru = nodeBaru.next;
        }
        nodeBaru.next = null;
        tail = nodeBaru;
    }
    public void sisipDataDiAkhir(Buku data) {
        /* lengkapi method ini */
        if ((head == null) && (tail == null)) {
            sisipDidepan(data);
        } else {
            Node nodeBaru = new Node();
            nodeBaru.data = data;
            tail.next = nodeBaru;
            tail = nodeBaru;
        }
    }
    public void sisipDataUrut(Buku data) {
        // lengkapi bagian ini   
        sisipDataDiAkhir(data);
        int pjg = 0;
        Node nodeBaru = head;
        while (nodeBaru.next != null) {
            pjg++;
            nodeBaru = nodeBaru.next;
        }
        Node cek = head;
        for (int i = 0; i < pjg; i++) {
            for (int j = 0; j < pjg; j++) {
                if (cek.data.getHargaSewa() > cek.next.data.getHargaSewa()) {
                    Node temp = new Node();
                    temp.data = cek.data;
                    cek.data = cek.next.data;
                    cek.next.data = temp.data;
                } else if (cek.data.getHargaSewa() == cek.next.data.getHargaSewa()) {
                    if (cek.data.getHargaDenda() > cek.next.data.getHargaDenda()) {
                        Node temp = new Node();
                        temp.data = cek.data;
                        cek.data = cek.next.data;
                        cek.next.data = temp.data;
                    }
                }
                cek = cek.next;
            }
            cek = head;
        }
    }
    public void hapusData(Buku dataHapus) {
        // lenkapai bagian ini  
        Node nodeBaru = new Node();
        nodeBaru = head;
        while (nodeBaru.next.data != dataHapus) {
            nodeBaru = nodeBaru.next;
        }
        nodeBaru.next = nodeBaru.next.next;
    }
    public Node getPointer() {
        return head;
    }
    public static SingleLinkedList gabung(SingleLinkedList L1, SingleLinkedList L2) {
        // lengkapi bagian ini
        SingleLinkedList all = new SingleLinkedList();
        Node l1 = L1.head;
        Node l2 = L2.head;
        int pjgL1 = 1;
        int pjgL2 = 1;
        while (l1.next != null) {
            pjgL1++;
            l1 = l1.next;
        }
        while (l2.next != null) {
            pjgL2++;
            l2 = l2.next;
        }
        l1 = L1.head;
        l2 = L2.head;
        for (int i = 0; i < pjgL1; i++) {
            all.sisipDataDiAkhir(l1.data);
            l1 = l1.next;
        }
        for (int i = 0; i < pjgL2; i++) {
            all.sisipDataDiAkhir(l2.data);
            l2 = l2.next;
        }
        return all;
    }
    //cetak data    
    public void cetak(String kom) {
        System.out.println(kom);
        Node n = head;
        while (n != null) {
            System.out.print(n.data);
            n = n.next;
        }
    }   
}