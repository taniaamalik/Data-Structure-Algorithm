package Sorting;

public class SortingMain {

    public static void main(String[] args) {
        Sorting s = new Sorting();
        System.out.println("======================================");
        int[] arr = {29, 27, 10, 8, 76, 21};
        System.out.println("MERGE SORT ");
        System.out.print("Array = ");
        s.cetakMerge(arr, 0, arr.length - 1);
        System.out.printf("\n**************************************");
        System.out.println();
        s.mergeSort(arr, 0, arr.length - 1);
        System.out.println("Time : " + System.currentTimeMillis());
        System.out.println("======================================");
        int[] arr1 = {29, 27, 10, 8, 76, 21};
        System.out.println("QUICK SORT");
        System.out.print("Array = ");
        s.Cetak(arr1);
        System.out.println("**************************************");
        s.quickSort(arr1, 0, arr1.length - 1);
        System.out.println("Time : " + System.currentTimeMillis());
        System.out.println("======================================");
        int[] arr2 = {29, 27, 10, 8, 76, 21};
        System.out.println("INSERTION SORT");
        System.out.print("Array = ");
        s.Cetak(arr2);
        System.out.println("**************************************");
        s.insertionSort(arr2);
        System.out.println("Time : " + System.currentTimeMillis());
        System.out.println("======================================");
    }
}