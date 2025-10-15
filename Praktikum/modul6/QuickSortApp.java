package Praktikum.modul6;

public class QuickSortApp {
    private int[] arr;
    private int nElemen;

    public QuickSortApp(int max) {
        arr = new int[max];
        nElemen = 0;
    }

    public void insert(int value) {
        arr[nElemen] = value;
        nElemen++;
    }

    public void display() {
        for (int i = 0; i < nElemen; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void QuickSort() {
        recQuickSort(0, nElemen - 1);
    }

    public void recQuickSort(int batasKiri, int batasKanan) {
        if (batasKanan - batasKiri <= 0) {
            return;
        } else {
            int pivot = arr[batasKanan];
            int partisi = partitionIt(batasKiri, batasKanan, pivot);
            recQuickSort(batasKiri, partisi - 1);
            recQuickSort(partisi + 1, batasKanan);
        }
    }

    public int partitionIt(int batasKiri, int batasKanan, int pivot) {
        int indexKiri = batasKiri - 1;
        int indexKanan = batasKanan;
        while (true) {
            while (indexKiri < batasKanan && arr[++indexKiri] < pivot)
                ;
            while (indexKanan > batasKiri && arr[--indexKanan] > pivot)
                ;
            if (indexKiri >= indexKanan) {
                break;
            } else {
                swap(indexKiri, indexKanan);
            }
        }
        swap(indexKiri, batasKanan);
        return indexKiri;
    }

    public static void main(String[] args) {
        QuickSortApp qs = new QuickSortApp(8);

        int[] data = { 60, 5, 15, 45, 35, 20, 25, 10 };
        for (int d : data) {
            qs.insert(d);
        }

        System.out.println("Array sebelum QuickSort:");
        qs.display();

        qs.QuickSort();

        System.out.println("Array setelah QuickSort:");
        qs.display();
    }
}
