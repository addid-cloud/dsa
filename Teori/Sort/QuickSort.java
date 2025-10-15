package Sort;

import java.util.List;
import java.util.Collections;

public class QuickSort implements SortStrategy {
    @Override
    public void sort(List<Double> data) {
        quickSort(data, 0, data.size() - 1);
    }

    @Override
    public String getName() {
        return "Quick Sort";
    }

    // Metode rekursif utama
    private void quickSort(List<Double> data, int low, int high) {
        if (low < high) {
            int pi = partition(data, low, high);

            quickSort(data, low, pi - 1);
            quickSort(data, pi + 1, high);
        }
    }

    // Metode Partisi (memilih elemen terakhir sebagai pivot)
    private int partition(List<Double> data, int low, int high) {
        double pivot = data.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (data.get(j) <= pivot) {
                i++;
                Collections.swap(data, i, j);
            }
        }
        Collections.swap(data, i + 1, high);
        return i + 1;
    }
}