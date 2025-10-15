package UTS;

import java.util.LinkedList;

import yt.linklistedd;

class nasabahBank {
    // Buatlah program sorting menggunakan bubblesort untuk data nasabah bank. Data
    // nasabah bank disimpan dalam struktur data LinkedList. Data nasabah bank
    // terdiri dari no rekening, nama. Urutkan data menggunakan algoritma yang Anda
    // ketahui.

}

public class Tes1 {
    static int binartySearch(LinkedList<Long> angka, long target) {
        long low = 0;
        long high = angka.size() - 1;
        while (low <= high) {
            int mid = (int) (low + (high - low) / 2);
            if (angka.get(mid) == target) {
                return mid;
            } else if (angka.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    static void bubblesort(LinkedList<Long> angka) {
        long temp = angka.peek();
        for (int i = angka.size(); i > 0; i--) {
            for (int j = 0; j < angka.size() - 1; j++) {
                if (angka.get(j) > angka.get(j + 1)) {
                    temp = angka.get(j);
                    angka.set(j, angka.get(j + 1));
                    angka.set(j + 1, temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<String> dataNama = new LinkedList<>();
        LinkedList<Long> dataRekening = new LinkedList<>();
        dataRekening.add(3231124l);
        dataRekening.add(2231124l);
        dataRekening.add(5231124l);
        dataRekening.add(4231124l);
        dataRekening.add(1231124l);
        dataNama.add("addid");
        dataNama.add("addid2");
        dataNama.add("addid3");
        bubblesort(dataRekening);
        for (Long long1 : dataRekening) {
            System.out.println(long1);
        }
        System.out.println(binartySearch(dataRekening, 4231124l));
    }
}
