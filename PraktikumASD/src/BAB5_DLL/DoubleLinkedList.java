package BAB5_DLL;

public class DoubleLinkedList {

    private NodeDLL pKepala, pEkor;

    public DoubleLinkedList() {
        pKepala = null;
        pEkor = null;
    }
    public void sisipDipKepala(Buku dt) {
        NodeDLL baru = new NodeDLL();
        baru.data = dt;
        if (pKepala == null) {
            baru.prev = pKepala;
            baru.next = pEkor;
            pKepala = baru;
            pEkor = baru;
        } else {
            baru.next = pKepala;
            pKepala.prev = baru;
            pKepala = baru;
        }
    }
    public void sisipDipEkor(Buku data) {
        NodeDLL baru = new NodeDLL();
        baru.data = data;
        if (pEkor == null) {
            baru.prev = pKepala;
            baru.next = pEkor;
            pKepala = baru;
            pEkor = baru;
        } else {
            baru.prev = pEkor;
            pEkor.next = baru;
            pEkor = baru;
        }
    }
    public void cetak(String kom) {
        System.out.println(kom);
        NodeDLL p = pKepala;
        while (p != pEkor.next) {
            System.out.print(p.data);
            p = p.next;
        }
        if (pKepala != null && pKepala.next == null) {
            pKepala = null;
        }
    }
    public void hapusDataTertentu(Buku dataHapus) {
        // lengkapi bagian ini  
        NodeDLL baru = pKepala;
        if (pKepala.data.getJudul().equalsIgnoreCase(dataHapus.getJudul())) {
            pKepala = pKepala.next;
            pKepala.prev = null;
        } else if (pEkor.data.getJudul().equalsIgnoreCase(dataHapus.getJudul())) {
            pEkor = baru.prev;
            pEkor.next = null;
        } else {
            while (pKepala != pEkor) {
                if (baru.next.data.getJudul().equalsIgnoreCase(dataHapus.getJudul())) {
                    baru.next = baru.next.next;
                    baru.next.prev = baru;
                    break;
                }
                baru = baru.next;
            }
        }
    }
    public void sisipDataTerurut(Buku data) {
        // lengkapi bagian ini 
        sisipDipEkor(data);
        int pjg = 0;
        NodeDLL baru = pKepala;
        while (baru.next != null) {
            pjg++;
            baru = baru.next;
        }
        NodeDLL cek = pKepala;
        for (int i = 0; i < pjg; i++) {
            for (int j = 0; j < pjg; j++) {
                if (cek.data.getHargaSewa() > cek.next.data.getHargaSewa()) {
                    NodeDLL temp = new NodeDLL();
                    temp.data = cek.data;
                    cek.data = cek.next.data;
                    cek.next.prev.data = cek.data;
                    cek.next.data = temp.data;
                } else if (cek.data.getHargaSewa() == cek.next.data.getHargaSewa()) {
                    if (cek.data.getHargaDenda() > cek.next.data.getHargaDenda()) {
                        NodeDLL temp = new NodeDLL();
                        temp.data = cek.data;
                        cek.data = cek.next.data;
                        cek.next.prev.data = cek.data;
                        cek.next.data = temp.data;
                    }
                }
                cek = cek.next;
            }
            cek = pKepala;
        }
    }
}