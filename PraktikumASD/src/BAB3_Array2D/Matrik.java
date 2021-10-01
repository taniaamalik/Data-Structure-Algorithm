package BAB3_Array2D;

public class Matrik {

    public static void main(String[] args) {
        Matrik A, B, C;
        double[][] X = {{1, 2, 3}, {2, 14, 5}, {16, 8, 13}};
        double[][] Y = {{10, 12, 0}, {5, 1, 5}, {3, 1, 10}};
        A = new Matrik(X);
        A.cetak("Matrik A");
        B = new Matrik(Y);
        B.cetak("Matrik B");
        C = A.tambah(B);
        C.cetak("Matrik C = A + B");
        Larik larikb, larikk;
        larikb = C.getBaris(1);
        larikb.cetak("Larik baris ke-1");
        larikk = C.getKolom(1);
        larikk.cetak("Larik kolom ke-1");
        System.out.println("Determinan C : " + C.determinan());
        C.Transpose();
        C.cetak("Transpose C : ");
        Matrik E;
        E = A.kali(B);
        E.cetak("Matrik A * Matrik B");
    }
    private int nBaris, nKolom;
    private double[][] itemDt;

    public Matrik(int jBrs, int jKlm) {
        nBaris = jBrs;
        nKolom = jKlm;
        itemDt = new double[nBaris][nKolom];
    }

    public Matrik(double[][] dt) {
        nBaris = dt.length;
        nKolom = dt[0].length;
        this.itemDt = new double[nBaris][nKolom];
        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                this.setItem(i, j, dt[i][j]);
            }
        }
    }

    public int getNBaris() {
        return nBaris;
    }

    public int getNKolom() {
        return nKolom;
    }

    public Larik getBaris(int m) {
        Larik baris = new Larik(nBaris, nKolom);
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < nKolom; j++) {
                baris.setItem((m - 1), j, this.getItem((m - 1), j));
            }
        }
        return baris;
    }

    public Larik getKolom(int n) {
        Larik kolom = new Larik(nBaris, nKolom);
        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < 1; j++) {
                kolom.setItem(i, n - 1, this.getItem(i, n - 1));
            }
        }
        return kolom;
    }

    public double getItem(int idB, int idK) {
        return this.itemDt[idB][idK];
    }

    public void setItem(int idB, int idK, double dt) {
        this.itemDt[idB][idK] = dt;
    }

    public Matrik tambah(Matrik x) {
        Matrik y = null;
        if ((this.nBaris == x.getNBaris()) && (this.nKolom == x.getNKolom())) {
            y = new Matrik(x.getNBaris(), x.getNKolom());
            for (int i = 0; i < this.nBaris; i++) {
                for (int j = 0; j < this.nKolom; j++) {
                    y.setItem(i, j, this.itemDt[i][j] + x.getItem(i, j));
                }
            }
        }
        return y;
    }

    public double determinan() {
        double bawah, atas;
        int i = 0, j = 0;
        atas = getItem(i, j) * getItem(i + 1, j + 1) * getItem(i + 2, j + 2) + getItem(i, j + 1) * getItem(i + 1, j + 2) * getItem(i + 2, j) + getItem(i, j + 2) * getItem(i + 1, j) * getItem(i + 2, j + 1);
        bawah = getItem(j + 1, i + 1) * getItem(j + 2, i) * getItem(j, i + 2) + getItem(i, j) * getItem(j + 2, i + 1) * getItem(j + 1, i + 2) + getItem(j + 2, i + 2) * getItem(j + 1, i) * getItem(j, i + 1);
        return (bawah - atas);
    }

    public Matrik Transpose() {
        Matrik hasil = new Matrik(nBaris, nKolom);
        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                hasil.setItem(i, j, this.getItem(j, i));
            }
        }
        return hasil;
    }

    public Matrik kali(Matrik x) {
        Matrik y = null;
        if ((this.nBaris == x.getNBaris()) && (this.nKolom == x.getNKolom())) {
            y = new Matrik(x.getNBaris(), x.getNKolom());
            for (int i = 0; i < this.nBaris; i++) {
                for (int j = 0; j < this.nKolom; j++) {
                    y.setItem(i, j,
                            this.itemDt[i][0] * x.getItem(0, j)
                            + this.itemDt[i][1] * x.getItem(1, j)
                            + this.itemDt[i][2] * x.getItem(2, j));
                }
            }
        }
        return y;
    }

    public void cetak(String kom) {
        System.out.println(kom);
        for (int i = 0; i < this.nBaris; i++) {
            for (int j = 0; j < this.nKolom; j++) {
                if (kom.contains("Tran") || kom.contains("tran")) {
                    System.out.print(this.Transpose().itemDt[i][j] + "  ");
                } else {
                    System.out.print(this.itemDt[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }
}

class Larik {

    private int nBaris, nKolom;
    private int[][] itemDt;

    public Larik(int nBrs, int nKlm) {
        nBaris = nBrs;
        nKolom = nKlm;
        itemDt = new int[nBaris][nKolom];
    }

    public Larik(double[][] dt) {
        nBaris = dt.length;
        nKolom = dt[0].length;
        this.itemDt = new int[nBaris][nKolom];
        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                this.setItem(i, j, dt[i][j]);
            }
        }
    }

    public double getItem(int idB, int idK) {
        return this.itemDt[idB][idK];
    }

    public void setItem(int idB, int idK, double data) {
        int dt = (int) data;
        this.itemDt[idB][idK] = dt;
    }

    public void cetak(String kal) {
        System.out.println(kal);
        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                if (this.getItem(i, j) != 0) {
                    System.out.print(this.getItem(i, j) + "  ");
                } else {
                    System.out.print("");
                }
            }
            System.out.println("");
        }
    }
}