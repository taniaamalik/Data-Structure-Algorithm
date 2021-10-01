package BAB2_Array1D;

public class Larik2 {
//data (strukur data)

    private int size;
    private int[] itemDt;
//method

    public void buatLarik(int n) {
        this.size = n;
        this.itemDt = new int[this.size];
    }

    public Larik2(int n) {
        buatLarik(n);
    }

    public int getSize() {
        return this.size;
    }

    public Larik2(int[] dt) {
        buatLarik(dt.length);
        for (int i = 0; i < dt.length; i++) {
            isiItem(i, dt[i]);
        }
    }

    public void isiItem(int id, int dt) {
        this.itemDt[id] = dt;
    }

    public void cetak(String komentar) {
        System.out.println(komentar);
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.itemDt[i] + " ");
        }
        System.out.println();
    }

    public int findBesar() {
        int besar = this.itemDt[0];
        for (int i = 1; i < this.size; i++) {
            if (besar < this.itemDt[i]) {
                besar = this.itemDt[i];
            }
        }
        return besar;
    }

    /**
     * program ini mencari posisi suatu data tertentu di larik
     */
    public int getPosisi(int dtCari) {
        int pos = -99;
        boolean ketemu = false;
        int i = 0;
        while (!ketemu && i < this.size) {
            if (dtCari == this.itemDt[i]) {
                ketemu = true;
                pos = i;
            }
            i++;
        }
        return pos;
    }

    private int getPosMax(int id) {
        int max = this.itemDt[id];
        int posMax = id;
        for (int i = id + 1; i < size; i++) {
            if (max <= this.itemDt[i]) {
                max = this.itemDt[i];
                posMax = i;
            }
        }
        return posMax;
    }

    private int getPosMin(int id) {
        int min = this.itemDt[id];
        int posMin = id;
        for (int i = id + 1; i < size; i++) {
            if (min >= this.itemDt[i]) {
                min = this.itemDt[i];
                posMin = i;
            }
        }
        return posMin;
    }

    public int PencarianBiner(int dtCari, int awal, int akhir) {
        int pos = -99;
        int tengah = (awal + akhir) / 2;
        if (dtCari < this.itemDt[tengah]) {
            return PencarianBiner(dtCari, awal, tengah);
        } else if (dtCari > this.itemDt[tengah]) {
            return PencarianBiner(dtCari, tengah + 1, akhir);
        } else if (dtCari == this.itemDt[tengah]) {
            return tengah;
        } else {
            return pos;
        }
    }

    /**
     * program untuk mencopy isi suatu Larik2 mulai dari posisi k sebanyak n item
 hasilnya dikeluarkan sebagai array baru
     */
    public Larik2 copyLarik(int k, int n) {
        Larik2 lHasil = null;
        if (n <= this.size - k) {
            lHasil = new Larik2(n);
            int j = 0;
            for (int i = k; i < k + n; i++) {
                lHasil.isiItem(j++, this.itemDt[i]);
            }
        }
        return lHasil;
    }

    /**
     * pilihan 0 : urutkan dari kecil ke besar lainya : urutkan dari besar ke
     * kecil Algoritma pengurutan ini menggunakan selection sort
     */
    public Larik2 SelectionSort(int pilihan) {
        Larik2 lsort = copyLarik(0, size);
        for (int i = 0; i < lsort.getSize(); i++) {
            int posData;
            if (pilihan == 0) {
                posData
                        = lsort.getPosMin(i);
            } else {
                posData = lsort.getPosMax(i);
            }
            int dt1 = lsort.itemDt[i];
            int dt2 = lsort.itemDt[posData];
            lsort.itemDt[i] = dt2;
            lsort.itemDt[posData] = dt1;
        }
        return lsort;
    }

    public int findPosKelipatan(int dtCari, int awal, int akhir) {
        System.out.println("Kelipatan " + dtCari + " ada di index ke = ");
        for (int i = awal; i < akhir; i++) {
            if (this.itemDt[i] % dtCari == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        return 0;
    }

    public Larik2 Sort(int array[]) {
        Larik2 sort = copyLarik(0, size);
        for (int i = 0; i < sort.getSize() - 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (sort.itemDt[j] > sort.itemDt[j + 1]) {
                    int temp = sort.itemDt[j];
                    sort.itemDt[j] = sort.itemDt[j + 1];
                    sort.itemDt[j + 1] = temp;
                }
            }
        }
        return sort;
    }

    public static void main(String[] args) {
        int[] A = {2, 34, 5, 7, 10};
        Larik2 lA = new Larik2(A);
        lA.cetak("Sebelum");
        lA.SelectionSort(0).cetak("Sesudah di sort");
        int k = lA.PencarianBiner(7, 0, 5);
        System.out.println(k);
        Larik2 lB = lA.SelectionSort(0);
        int p = lB.PencarianBiner(10, 0, 5);
        System.out.println(p);
        System.out.println("--------------------");
        int[] x = {1, 3, 4, 2, 5, 6, 7};
        Larik2 lx = new Larik2(x);
        lx.cetak("Sebelum =");
        lx.findPosKelipatan(3, 1, 6);
        lx.Sort(x).cetak("Sesudah di sort =");
        Larik2 lx2 = lx.Sort(x);
        lx2.findPosKelipatan(3, 1, 6);
    }
}