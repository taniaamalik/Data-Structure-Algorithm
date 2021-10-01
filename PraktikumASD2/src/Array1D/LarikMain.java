package Array1D;

public class LarikMain {

    public static void main(String[] args) {
        int[] A = {2, 34, 5, 7, 10};
        Larik lA = new Larik(A);
        lA.cetak("Sebelum");
        lA.SelectionSort(0).cetak("Sesudah di sort");
        int k = lA.PencarianBiner(7, 0, 5);
        System.out.println(k);
        Larik lB = lA.SelectionSort(0);
        int p = lB.PencarianBiner(10, 0, 5);
        System.out.println(p);
        System.out.println("--------------------");
        int[] x = {1, 3, 4, 2, 5, 6, 7};
        Larik lx = new Larik(x);
        lx.cetak("Sebelum =");
        lx.findPosKelipatan(3, 1, 6);
        lx.Sort(x).cetak("Sesudah di sort =");
        Larik lx2 = lx.Sort(x);
        lx2.findPosKelipatan(3, 1, 6);
    }
}