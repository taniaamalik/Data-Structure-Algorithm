package BAB6_Sirkular;

class NodeCDLL {

    Object data;
    NodeCDLL next, prev;
}

public class CircularDoubleLinkedList {

    private NodeCDLL pAwal, pAkhir;
    private int counter;

    public CircularDoubleLinkedList() {
        pAwal = null;
        pAkhir = null;
        counter = -1;
    }

    public void SisipDataDiAwal(Object data) {
        NodeCDLL pBaru = new NodeCDLL();
        pBaru.data = data;
        pBaru.next = null;
        if (pAwal == null) {
            pAwal = pBaru;
            pAkhir = pBaru;
            pBaru.next = pAwal;
            pAwal.prev = pAwal;
            counter = 0;
        } else {
            pBaru.next = pAwal;
            pAwal.prev = pBaru;
            pAwal = pBaru;
            pAkhir.next = pAwal;
            pAwal.prev = pAkhir;
            counter++;
        }
    }

    public void hapusData(Object dtHapus) {
        if (pAwal != null) {
            NodeCDLL pSbl, pKini, pHapus;
            pSbl = null;
            pKini = pAwal;
            boolean ketemu = false;
            int i = -1;
            if (pAwal != null) {
                i = 0;
            }
            while (!ketemu && (i <= counter) && (i != -1)) {
                if (pKini.data.equals(dtHapus)) {
                    ketemu = true;
                } else {
                    pSbl = pKini;
                    pKini = pKini.next;
                    pKini.prev = pSbl;
                }
                i++;
            }
            if (ketemu) {
                if (pSbl == null) {
                    pHapus = pAwal;
                    pHapus = null;
                } else {
                    pSbl.next = pKini.next;
                    pHapus = pKini;
                    pHapus = null;
                }
                this.counter--;
            }
        }
    }

    public Object hapusSatuDataDiAkhir() {
        NodeCDLL temp = pAkhir;
        temp = null;
        if (pAwal != null) {
            if (pAwal.next == pAwal) {
                pAwal = null;
            } else {
                temp = pAwal;
                while (temp.next.next != pAwal) {
                    temp = temp.next;
                }
                pAkhir = temp;
                pAkhir.next = pAwal;
                pAwal.prev = pAkhir;
                counter--;
            }
        }
        return pAkhir.data;
    }

    public void cetak(String Komentar) {
        System.out.println(Komentar);
        NodeCDLL pCetak;
        pCetak = pAwal;
        int i = -1;
        while ((i < counter)) {
            System.out.print(pCetak.data + "<->");
            pCetak = pCetak.next;
            i++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();
        cdll.SisipDataDiAwal(new Integer(50));
        cdll.SisipDataDiAwal(new Integer(60));
        cdll.SisipDataDiAwal(new Integer(70));
        cdll.SisipDataDiAwal(new Integer(8));
        cdll.SisipDataDiAwal(new Integer(9));
        cdll.SisipDataDiAwal(new Integer(90));
        cdll.SisipDataDiAwal(new Integer(19));
        cdll.cetak("CDLL Awal");
        cdll.hapusData(8);
        cdll.cetak("CDLL setelah data 8 dihapus");
        cdll.hapusSatuDataDiAkhir();
        cdll.cetak("CDLL setelah  satu data terakhir dihapus");
    }
}