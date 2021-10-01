package BAB6_Sirkular;

class NodeCSLL {

    Buku data;
    NodeCSLL next;
}

public class CircularSingleLinkedList {

    private NodeCSLL pAwal, pAkhir;
    private int counter;

    public CircularSingleLinkedList() {
        pAwal = null;
        pAkhir = null;
        counter = -1;
    }

    public void SisipDataDiAwal(Buku data) {
        NodeCSLL pBaru = new NodeCSLL();
        pBaru.data = data;
        pBaru.next = null;
        if (pAwal == null) {
            pAwal = pBaru;
            pAkhir = pBaru;
            pBaru.next = pAwal;
            counter = 0;
        } else {
            pBaru.next = pAwal;
            pAwal = pBaru;
            pAkhir.next = pAwal;
            counter++;
        }
    }

    public void hapusData(Buku dtHapus) {
        if (pAwal != null) {
            NodeCSLL pSbl, pKini, pHapus;
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

    public void hapusSatuDataDiAkhir() {
        NodeCSLL temp = pAkhir;
        while (temp.next != pAwal) {
            if (temp.next == pAkhir) {
                temp.next = pAkhir;
                pAkhir = temp;
            }
            temp = temp.next;
        }
        counter--;
    }

    public void cetak(String Komentar) {
        System.out.println(Komentar);
        NodeCSLL pCetak;
        pCetak = pAwal;
        int i = -1;
        while ((i < counter)) {
            System.out.println("------------------------------------------------");
            System.out.println("Kategori : " + pCetak.data.getKategori());
            System.out.println("Judul: " + pCetak.data.getJudul());
            System.out.println("Harga Sewa : " + pCetak.data.getHargaSewa());
            System.out.println("Harga Denda : " + pCetak.data.getHargaDenda());
            pCetak = pCetak.next;
            i++;
        }
        System.out.println();
    }

    public void cetakBuku(String param, int hargaSewa) {
        System.out.println("Buku dengan harga sewa " + param + " Rp. " + hargaSewa);
        NodeCSLL pCetak;
        pCetak = pAwal;
        int i = -1, no = 1;
        while (i < counter) {
            if (param.equals("lebihdari") && (pCetak.data.getHargaSewa()) > hargaSewa) {
                System.out.println((no++) + ". " + pCetak.data.getJudul() + ", Rp. " + pCetak.data.getHargaSewa());
            } else if (param.equals("kurangdari") && (pCetak.data.getHargaSewa()) < hargaSewa) {
                System.out.println((no++) + ". " + pCetak.data.getJudul() + ", Rp. " + pCetak.data.getHargaSewa());
            } else if (param.equals("samadengan") && (pCetak.data.getHargaSewa()) == hargaSewa) {
                System.out.println((no++) + ". " + pCetak.data.getJudul() + ", Rp. " + pCetak.data.getHargaSewa());
            }
            pCetak = pCetak.next;
            i++;
        }
    }

    public static void main(String[] args) {
        CircularSingleLinkedList csll = new CircularSingleLinkedList();
        Buku[] list = new Buku[10];
        list[0] = new Buku("Novel", "Crazy Rich Asians", 5000, 2500);
        list[1] = new Buku("Novel", "To All The Boys", 5000, 2500);
        list[2] = new Buku("Novel", "Sunshine Becomes You", 3000, 200);
        list[3] = new Buku("Edukasi", "Kalkulus", 4000, 1500);
        list[4] = new Buku("Edukasi", "Matematika Disktrit", 3500, 1500);
        list[5] = new Buku("Komik", "Doraemon", 2000, 1000);
        list[6] = new Buku("Komik", "Naruto", 1500, 1000);
        list[7] = new Buku("Komik", "Detective Conan", 2000, 1000);
        list[8] = new Buku("Majalah", "Kartini", 1500, 500);
        list[9] = new Buku("Majalah", "Go Girl!", 1000, 500);
        csll.SisipDataDiAwal(list[0]);
        csll.SisipDataDiAwal(list[1]);
        csll.SisipDataDiAwal(list[2]);
        csll.SisipDataDiAwal(list[3]);
        csll.SisipDataDiAwal(list[4]);
        csll.SisipDataDiAwal(list[5]);
        csll.SisipDataDiAwal(list[6]);
        csll.SisipDataDiAwal(list[7]);
        csll.SisipDataDiAwal(list[8]);
        csll.SisipDataDiAwal(list[9]);
        csll.cetak("CSLL Awal");
        csll.hapusData(list[1]);
        csll.cetak("\n" + "CSLL setelah buku ke - 2 dihapus");
        csll.hapusSatuDataDiAkhir();
        csll.cetak("\n" + "CSLL setelah buku terakhir dihapus");
        csll.cetakBuku("lebihdari", 1000);
        csll.cetakBuku("samadengan", 2000);
        csll.cetakBuku("kurangdari", 5000);
    }
}