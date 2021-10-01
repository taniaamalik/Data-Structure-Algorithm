package Sorting;

public class Sorting {

    public void merge(int[] arr, int i, int tengah, int j) {
        System.out.print("Kiri: ");
        cetakMerge(arr, i, tengah);
        System.out.print(" Kanan: ");
        cetakMerge(arr, tengah + 1, j);
        System.out.println();
        int temp[] = new int[arr.length];
        int kiri = i;
        int kanan = j;
        int m = tengah + 1;
        int k = kiri;
        while (kiri <= tengah && m <= kanan) {
            if (arr[kiri] <= arr[m]) {
                temp[k++] = arr[kiri++];
            } else {
                temp[k++] = arr[m++];
            }
        }
        while (kiri <= tengah) {
            temp[k++] = arr[kiri++];
        }
        while (m <= kanan) {
            temp[k++] = arr[m++];
        }
        for (int i1 = i; i1 <= j; i1++) {
            arr[i1] = temp[i1];
        }
        System.out.print("Setelah Merge: ");
        cetakMerge(arr, i, j);
        System.out.println();
    }

    public void mergeSort(int[] arr, int i, int j) {
        int tengah = 0;

        if (i < j) {
            tengah = (i + j) / 2;
            mergeSort(arr, i, tengah);
            mergeSort(arr, tengah + 1, j);
            merge(arr, i, tengah, j);
        }
    }

    public void cetakMerge(int[] arr, int i, int j) {
        System.out.print("[");
        for (int k = i; k < j; k++) {
            System.out.print(arr[k] + ", ");
        }
        System.out.print(arr[j] + "]");
    }

    public void quickSort(int[] arr, int i, int j) {
        if (i < j) {
            int pos = perbandingan(arr, i, j);
            quickSort(arr, i, pos - 1);
            quickSort(arr, pos + 1, j);
        }
    }

    public int perbandingan(int[] arr, int i, int j) {
        System.out.println("Pivot = " + arr[j]);
        int pivot = arr[j];
        int x = i - 1;
        for (int k = i; k < j; k++) {
            if (arr[k] <= pivot) {
                x++;
                swap(arr, k, x);
            }
        }
        swap(arr, j, x + 1);
        Cetak(arr);
        return x + 1;
    }

    public void swap(int[] arr, int k, int x) {
        int temp;
        temp = arr[k];
        arr[k] = arr[x];
        arr[x] = temp;
    }

    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int temp = array[i];
            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
            System.out.print("Langkah " + i + "  : ");
            Cetak(array);
        }
    }

    public void Cetak(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}