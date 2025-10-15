package Praktikum;

import java.util.ArrayList;
import java.util.List;

class MahasiswaUiIN{
    String nama;
    String nim;
    MahasiswaUiIN(String nama, String nim){
        this.nama = nama;
        this.nim = nim;
    }
}


public class MahasiswaApp {
    public static void main(String[] args) {
        ArrayList<MahasiswaUiIN> mhs = new ArrayList<>();
        MahasiswaUiIN mhs1 = new MahasiswaUiIN("muhammad alif mujaddid","240605110082");
        MahasiswaUiIN mhs2 = new MahasiswaUiIN("Dimas Bagus Harimurti","240605110081");
        MahasiswaUiIN mhs3 = new MahasiswaUiIN("Faril Irsya Arbiyansyah","240605110083");
        mhs.add(mhs1);
        mhs.add(mhs2);
        mhs.add(mhs3);
        for (int i = 0; i < mhs.size(); i++) {
            System.out.println(mhs.get(i).nama +  "  " + mhs.get(i).nim);
        }
        System.out.println();
        recMergeSort(mhs);
        System.out.println("merge sort by nama : ");
        for (int i = 0; i < mhs.size(); i++) {
            System.out.println(mhs.get(i).nama +  "  " + mhs.get(i).nim);
        }
        shellSortByNim(mhs);
        System.out.println();
        System.out.println("shell sort by nim : ");
        for (int i = 0; i < mhs.size(); i++) {
            System.out.println(mhs.get(i).nama +  "  " + mhs.get(i).nim);
        }
        quickSortByNama(mhs,0,mhs.size()-1);
        System.out.println();
        System.out.println("quick sort by name : ");
        for (int i = 0; i < mhs.size(); i++) {
            System.out.println(mhs.get(i).nama +  "  " + mhs.get(i).nim);
        }
    }
static void recMergeSort(ArrayList<MahasiswaUiIN> mahasantri) { 
  if (mahasantri.size() <= 1) return; 
        int mid = mahasantri.size() / 2;
        ArrayList<MahasiswaUiIN> left = new ArrayList<>(mahasantri.subList(0, mid));
        ArrayList<MahasiswaUiIN> right = new ArrayList<>(mahasantri.subList(mid, mahasantri.size()));
        recMergeSort(left);
        recMergeSort(right);
        merge(mahasantri, left, right); 
    }
static void merge(ArrayList<MahasiswaUiIN> mahasantri, ArrayList<MahasiswaUiIN> left, ArrayList<MahasiswaUiIN> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).nama.compareTo(right.get(j).nama) <= 0) {
                mahasantri.set(k++, left.get(i++));
            } else {
                mahasantri.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) mahasantri.set(k++, left.get(i++));
        while (j < right.size()) mahasantri.set(k++, right.get(j++));
    }
        static void shellSortByNim(ArrayList<MahasiswaUiIN> mahasantri) {
        int n = mahasantri.size();
        for (int gap = n / 2; gap > 0; gap /= 2) { 
            for (int i = gap; i < n; i++) {
                MahasiswaUiIN temp = mahasantri.get(i);
                int j = i;
                while (j >= gap && mahasantri.get(j - gap).nim.compareTo(temp.nim) > 0) {
                    mahasantri.set(j, mahasantri.get(j - gap));
                    j -= gap;
                }
                mahasantri.set(j, temp);
            }
        }
    }
    public static void quickSortByNama(ArrayList<MahasiswaUiIN> Mahasantri, int low, int high) {
        if (low < high) {
            int pi = partition(Mahasantri, low, high);
            quickSortByNama(Mahasantri, low, pi - 1);
            quickSortByNama(Mahasantri, pi + 1, high);
        }
    }

    private static int partition(ArrayList<MahasiswaUiIN> Mahasantri, int low, int high) {
        String pivot = Mahasantri.get(high).nama;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (Mahasantri.get(j).nama.compareTo(pivot) <= 0) {
                i++;
                MahasiswaUiIN temp = Mahasantri.get(i);
                Mahasantri.set(i, Mahasantri.get(j));
                Mahasantri.set(j, temp);
            }
        }
        MahasiswaUiIN temp = Mahasantri.get(i + 1);
        Mahasantri.set(i + 1, Mahasantri.get(high));
        Mahasantri.set(high, temp);
        return i + 1;
    }
}
