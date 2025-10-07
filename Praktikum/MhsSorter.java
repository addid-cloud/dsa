package Praktikum;
import java.util.ArrayList;

class MhsSorter {

    public static void mergeSortByNama(ArrayList<LinkQueue> list) {
        if (list.size() <= 1) return; 
        int mid = list.size() / 2;
        ArrayList<LinkQueue> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<LinkQueue> right = new ArrayList<>(list.subList(mid, list.size()));
        mergeSortByNama(left);
        mergeSortByNama(right);
        merge(list, left, right);
    }

    private static void merge(ArrayList<LinkQueue> list, ArrayList<LinkQueue> left, ArrayList<LinkQueue> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).nama.compareTo(right.get(j).nama) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) list.set(k++, left.get(i++));
        while (j < right.size()) list.set(k++, right.get(j++));
    }

    public static void shellSortByNim(ArrayList<LinkQueue> list) {
        int n = list.size();
        for (int gap = n / 2; gap > 0; gap /= 2) { 
            for (int i = gap; i < n; i++) {
                LinkQueue temp = list.get(i);
                int j = i;
                while (j >= gap && list.get(j - gap).nim.compareTo(temp.nim) > 0) {
                    list.set(j, list.get(j - gap));
                    j -= gap;
                }
                list.set(j, temp);
            }
        }
    }

    public static void quickSortByNama(ArrayList<LinkQueue> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quickSortByNama(list, low, pi - 1);
            quickSortByNama(list, pi + 1, high);
        }
    }

    private static int partition(ArrayList<LinkQueue> list, int low, int high) {
        String pivot = list.get(high).nama;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (list.get(j).nama.compareTo(pivot) <= 0) {
                i++;
                LinkQueue temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        LinkQueue temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);
        return i + 1;
    }

    public static void display(ArrayList<LinkQueue> list) {
        for (LinkQueue mhs : list) {
            mhs.displayMhs();
        }
        System.out.println();
    }
}
