package Praktikum.modul6;

public class ShellSort {
    private int[] arr;
    private int nElemen;
    private int max;

    public ShellSort(int max) {
        this.max = max;
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

    public void shellSort() {
        int in, out;
        int temp;
        int h = 1;
        while (h < nElemen / 3) {
            h = 3 * h + 1;
        }
        while (h > 0) {
            for (out = h; out < nElemen; out++) {
                temp = arr[out];
                in = out;
                while (in > h - 1 && arr[in - h] >= temp) {
                    arr[in] = arr[in - h];
                    in -= h;
                }
                arr[in] = temp;
                display();
            }
            h = (h - 1) / 3;
        }
    }

    public static void main(String[] args) {
        ShellSort data = new ShellSort(8);
        data.insert(45);
        data.insert(12);
        data.insert(78);
        data.insert(34);
        data.insert(23);
        data.insert(56);
        data.insert(89);
        data.insert(11);

        System.out.println("Data sebelum diurutkan:");
        data.display();

        System.out.println("\nProses Shell Sort:");
        data.shellSort();

        System.out.println("\nData setelah diurutkan:");
        data.display();
    }
}
