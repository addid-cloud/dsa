package Sort;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Sorter {
    private SortStrategy strategy;

    // Konstruktor: menerima dan menetapkan strategi
    public Sorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    // Setter: memungkinkan penggantian strategi saat runtime
    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    // Metode untuk menjalankan sorting menggunakan strategi saat ini
    public long executeSort(List<Double> data) {
        long startTime = System.nanoTime();

        System.out.println("----------------------------------------");
        System.out.println("Menggunakan Algoritma: " + strategy.getName());
        System.out.println("Data Awal: " + data);

        // Panggil metode sort dari strategi yang aktif
        strategy.sort(data);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000;
        // dalam milidetik
        System.out.println("Data Terurut: " + data);
        System.out.println("Waktu Eksekusi: " + duration + " ms");
        System.out.println("----------------------------------------");
        return duration;
    }

    public static double avgAlgo(List<Long> waktu) {
        double rataRata = 0;
        for (int i = 0; i < waktu.size(); i++) {
            rataRata += waktu.get(i);
        }
        rataRata = rataRata / waktu.size();
        return rataRata;
    }

    public static long maxSort(List<Long> waktu) {
        long max = 0;
        for (int i = 0; i < waktu.size(); i++) {
            if (max <= waktu.get(i)) {
                max = waktu.get(i);
            }
        }
        return max;
    }

    public static long minSort(List<Long> waktu) {
        long max = waktu.get(0);
        for (int i = 0; i < waktu.size(); i++) {
            if (max >= waktu.get(i)) {
                max = waktu.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // Contoh data acak
        Scanner sc = new Scanner(System.in);
        System.out.print("masukan jumlagh data : ");
        int panjangData = sc.nextInt();
        System.out.print("masukan jumlagh percobaan : ");
        int panjangPercobaan = sc.nextInt();
        List<Double> initialData = new ArrayList<>();
        List<Long> waktu1 = new ArrayList<>();
        List<Long> waktu2 = new ArrayList<>();
        for (int i = 0; i < panjangData; i++) {
            initialData.add(Math.random() * 1000);
        }
        // 1. Menggunakan Bubble Sort
        Sorter sorter = new Sorter(new BubbleSort());
        for (int i = 0; i < panjangPercobaan; i++) {
            waktu1.add(sorter.executeSort(new ArrayList<>(initialData)));
        }
        double rataRata = avgAlgo(waktu1);
        long max1 = maxSort(waktu1);
        long min1 = minSort(waktu1);
        // Kirim salinan data
        // 2. Mengganti Strategy tanpa mengubah kode inti Sorter
        // Anda hanya perlu membuat objek QuickSort dan memberikannya ke
        // Sorter
        for (int i = 0; i < panjangPercobaan; i++) {
            sorter.setStrategy(new QuickSort());
            waktu2.add(sorter.executeSort(new ArrayList<>(initialData)));
        }
        long max2 = maxSort(waktu2);
        long min2 = minSort(waktu2);
        double rataRata2 = avgAlgo(waktu2);
        System.out.println("bubble sort terburuk : ");
        System.out.println(max1);
        System.out.println("quick sort terburuk : ");
        System.out.println(max2);
        System.out.println("bubble sort terbaik : ");
        System.out.println(min1);
        System.out.println("quick sort terbaik : ");
        System.out.println(min2);
        System.out.println("bubble sort avg : ");
        System.out.println(rataRata);
        System.out.println("quick sort avg : ");
        System.out.println(rataRata2);
        // Kirim salinan data
    }
}
