package BAB3_Array2D;

public class Matriks2 {

    public static void main(String[] args) {
        Matriks2 A;
        Matriks2 B, C;
        double[][] data1 = {{1, 2, 3}, {3, 4, 7}};
        double[][] data2 = {{4, 5, 1}, {6, 1, 9}};
        A = new Matriks2(data1);
        B = new Matriks2(data2);
        A.cetak("A");
        B.cetak("B");
        C = A.tambah(A, B);
        C.cetak("C");
        System.out.println("Determinan C : " + C.determinan());
        Matriks2 CT = Matriks2.tranpos(C);
        CT.cetak("Transpos");
        Larik2 l1 = C.getBaris(1);
        l1.cetak("Baris ke 1 dari C");
        Larik2 l2 = Matriks2.VektorKaliMatrik(l1, CT);
        l2.cetak("hasil kali C.L1");
    }
    private int nBaris, nKolom;
    private double[][] itemDt;

    public Matriks2(int jBrs, int jKlm) {
        nBaris = jBrs;
        nKolom = jKlm;
        itemDt = new double[nBaris][nKolom];
    }

    public Matriks2(double[][] A) {
        this(A.length, A[0].length);
        this.nKolom = A[0].length;
        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                this.itemDt[i][j] = A[i][j];
            }
        }
    }

    public int getNBaris() {
        return nBaris;
    }

    public int getNKolom() {
        return nKolom;
    }

    public double getItem(int idB, int idK) {
        return this.itemDt[idB][idK];
    }

    public void setItem(int idB, int idK, double dt) {
        this.itemDt[idB][idK] = dt;
    }

    public static Matriks2 tambah(Matriks2 A, Matriks2 B) {
        Matriks2 hasil = null;
        if (A.getNBaris() == B.getNBaris() && A.getNKolom() == B.getNKolom()) {
            hasil = new Matriks2(A.getNBaris(), A.getNKolom());
            for (int i = 0; i < A.getNBaris(); i++) {
                for (int j = 0; j < A.getNKolom(); j++) {
                    hasil.setItem(i, j, A.getItem(i, j) + B.getItem(i, j));
                }
            }
            return hasil;
        } else {
            return hasil;
        }
    }

    public void cetak(String kom) {
        System.out.println(kom);
        for (int i = 0; i < this.nBaris; i++) {
            for (int j = 0; j < this.nKolom; j++) {
                System.out.print(this.itemDt[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static Matriks2 tranpos(Matriks2 C) {
        Matriks2 trans = new Matriks2(C.getNKolom(), C.getNBaris());
        for (int i = 0; i < C.getNKolom(); i++) {
            for (int j = 0; j < C.getNBaris(); j++) {
                trans.setItem(i, j, C.getItem(j, i));
            }
        }
        return trans;
    }

    public static Larik2 VektorKaliMatrik(Larik2 L, Matriks2 M) {
        Larik2 lHasil = null;
        Larik2 lKolom = null;
        if (L.getSize() == M.getNBaris()) {
            lHasil = new Larik2(M.getNKolom());
            for (int i = 0; i < M.getNKolom(); i++) {
                lKolom = M.getKolom(i);
                double hasil = Larik2.LarikKaliLarik(L, lKolom);
                System.out.println(hasil);
                lHasil.isiItem(i, hasil);
            }
        }
        return lHasil;
    }

    public Larik2 getKolom(int idK) {
        Larik2 l = new Larik2(this.nBaris);
        for (int i = 0; i < nBaris; i++) {
            l.isiItem(i, (int) this.getItem(i, idK));
        }
        return l;
    }

    public Larik2 getBaris(int idK) {
        Larik2 l = new Larik2(this.nKolom);
        for (int i = 0; i < nKolom; i++) {
            l.isiItem(i, (int) this.getItem(idK, i));
        }
        return l;
    }

    private String determinan() {
        if (nBaris != nKolom) {
            return ("Bukan matriks persegi");
        } else {
            double temp = (itemDt[1][1] * itemDt[0][0] * itemDt[2][2]) + (itemDt[0][1] * itemDt[1][2] * itemDt[2][0]) + (itemDt[0][2] * itemDt[1][0] * itemDt[2][1]);
            double temp2 = (itemDt[0][2] * itemDt[1][1] * itemDt[2][0]) + (itemDt[0][0] * itemDt[1][2] * itemDt[2][1]) + (itemDt[0][1] * itemDt[1][0] * itemDt[2][2]);
            double hd = temp - temp2;
            return ("hasil detrminan " + hd);
        }
    }
}

class Larik2 {

    private int size;
    private double[] itemDt;

    static double LarikKaliLarik(Larik2 L1, Larik2 L4) {
        double l = 0;
        if (L1.getSize() == L4.getSize()) {
            for (int i = 0; i < L1.getSize(); i++) {
                l += L1.getItem(i) * L4.getItem(i);
            }
        }
        return l;
    }

    public Larik2(double[] A) {
        this.size = A.length;
        this.itemDt = new double[this.size];
        for (int i = 0; i < this.size; i++) {
            this.itemDt[i] = A[i];
        }
    }

    public Larik2(int i) {
        this.size = i;
        this.itemDt = new double[this.size];
    }

    public int getSize() {
        return this.size;
    }

    double getItem(int i) {
        return this.itemDt[i];
    }

    public void isiItem(int id, double dt) {
        this.itemDt[id] = dt;
    }

    public void cetak(String komentar) {
        System.out.println(komentar);
        for (int i = 0; i < this.size; i++) {
            System.out.printf("%.2f ", this.itemDt[i]);
        }
        System.out.println();
    }
}
