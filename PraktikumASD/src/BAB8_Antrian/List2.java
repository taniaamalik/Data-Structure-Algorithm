package BAB8_Antrian;

public class List2 {

    private Node2 nodeAwal;
    private Node2 nodeAkhir;
    private String nama;

    public List2() {
        this("list");
    }

    public List2(String namaList) {
        nama = namaList;
        nodeAwal = nodeAkhir = null;
    }

    public void sisipDiAwal(Object dt) {
        // Isi penyisipan di Awal
        Node2 n = new Node2(dt);
        if (this.kosong()) {
            nodeAwal = nodeAkhir = n;
        } else {
            n.next = nodeAwal;
            nodeAwal.prev = n;
            nodeAwal = n;
        }
    }

    public void sisipDiAkhir(Object dt) {
        // Isi penyisipan di Akhir    
        Node2 n = new Node2(dt);
        if (this.kosong()) {
            nodeAkhir = nodeAwal = n;
        } else {
            n.prev = nodeAkhir;
            nodeAkhir.next = n;
            nodeAkhir = n;
        }
    }

    public Object hapusDrDepan() {
        Object itemDihapus = null;
        if (!kosong()) {
            itemDihapus = nodeAwal.data;
            if (nodeAwal == nodeAkhir) {
                nodeAwal = nodeAkhir = null;
            } else {
                nodeAwal = nodeAwal.next;
                nodeAwal.prev = null;
            }
        }
        return itemDihapus;
    }

    public boolean kosong() {
        return nodeAwal == null;
    }

    public void cetak() {
        if (kosong()) {
            System.out.printf("Kosong %s\n", nama);
            return;
        }
        System.out.printf("Isi %s adalah : ", nama);
        Node2 kini = nodeAwal;
        while (kini != null) {
            System.out.printf("%s ", kini.data);
            kini = kini.next;
        }
        System.out.println("\n");
    }
}