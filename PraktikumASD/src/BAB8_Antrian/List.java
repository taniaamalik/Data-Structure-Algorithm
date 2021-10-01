package BAB8_Antrian;

public class List {

    private Node nodeAwal;
    private Node nodeAkhir;
    private String nama;

    public List() {
        this("list");
    }

    public List(String namaList) {
        nama = namaList;
        nodeAwal = nodeAkhir = null;
    }

    public void sisipDiAwal(Object dt) {
        // Isi penyisipan di Awal
        Node n = new Node(dt);
        if (this.kosong()) {
            nodeAwal = nodeAkhir = n;
            nodeAkhir.next = nodeAwal;
        } else {
            n.next = nodeAwal;
            nodeAwal = n;
            nodeAkhir.next = nodeAwal;
        }
    }

    public void sisipDiAkhir(Object dt) {
        // Isi penyisipan di Akhir    
        Node n = new Node(dt);
        if (this.kosong()) {
            nodeAkhir = nodeAwal = n;
            nodeAkhir.next = nodeAwal;
        } else {
            nodeAkhir.next = n;
            nodeAkhir = n;
            nodeAkhir.next = nodeAwal;
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
                nodeAkhir.next = nodeAwal;
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
        Node kini = nodeAwal;
        do {
            System.out.printf("%s ", kini.data);
            kini = kini.next;
        } while (kini != nodeAkhir.next);
        System.out.println();
    }

    public void RoundRobin(int quantumtime) {
        System.out.println("Quantum Time : " + quantumtime);
        System.out.println("-----------------------------");
        do {
            if (!kosong()) {
                if ((int) nodeAwal.data > quantumtime) {
                    System.out.println("Queue Awal : " + nodeAwal.data);
                    nodeAwal.data = (int) nodeAwal.data - quantumtime;
                    System.out.println("Sisa : " + nodeAwal.data);
                    sisipDiAkhir(nodeAwal.data);
                    hapusDrDepan();
                } else {
                    System.out.println("Queue Awal : " + nodeAwal.data);
                    nodeAwal.data = (int) nodeAwal.data - (int) nodeAwal.data;
                    System.out.println("Sisa : " + nodeAwal.data);
                    hapusDrDepan();
                }
            }
            cetak();
            System.out.println("-----------------------------");
        } while (!kosong());
    }
}