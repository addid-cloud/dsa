package UTS;

import java.util.LinkedList;

class nasabahBank {
    int rekening;
    String name;

    public nasabahBank(int rekening, String name) {
        this.rekening = rekening;
        this.name = name;
    }
}

public class Nasabah {
    public static void main(String[] args) {
        LinkedList<nasabahBank> data = new LinkedList<>();
        data.add(new nasabahBank(1, "muhammad alif mujaddid"));
        data.add(new nasabahBank(5, "muhammad alif mujaddid5"));
        data.add(new nasabahBank(2, "muhammad alif mujaddid2"));
        data.add(new nasabahBank(3, "muhammad alif mujaddid3"));
        data.add(new nasabahBank(4, "muhammad alif mujaddid4"));
        data.pop();
        // data.set(0, null)
        for (nasabahBank nasabahBank : data) {
            System.out.println(nasabahBank.rekening);
        }
        // sortData(data);
        sortByName(data);
        System.out.println("==============");
        for (nasabahBank nasabahBank : data) {
            System.out.print(nasabahBank.rekening + " ");
            System.out.println(nasabahBank.name);
        }
        System.out.println(binarySearch(data, 3));
        System.out.println(binarySearchByName(data, "muhammad alif mujaddid4"));

    }

    public static void sortData(LinkedList<nasabahBank> data) {
        nasabahBank temp;
        for (int i = data.size(); i >= 0; i--) {
            for (int j = 0; j < data.size() - 1; j++) {
                if (data.get(j).rekening > data.get(j + 1).rekening) {
                    temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);
                }
            }
        }
    }

    public static int binarySearch(LinkedList<nasabahBank> data, int target) {
        int low = 0;
        int high = data.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (data.get(mid).rekening == target) {
                return mid;
            } else if (data.get(mid).rekening < target) {
                mid = mid + 1;
            } else {
                mid = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchByName(LinkedList<nasabahBank> data, String target) {
        int low = 0;
        int high = data.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int banding = target.compareToIgnoreCase(data.get(mid).name);
            if (banding == 0) {
                return mid;
            } else if (banding > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void sortByName(LinkedList<nasabahBank> data) {
        nasabahBank temp;
        for (int i = data.size() - 1; i > 0; i--) {
            for (int j = 0; j < data.size() - 1; j++) {
                if (data.get(j).name.compareTo(data.get(j + 1).name) > 0) {
                    temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);
                }
            }
        }
    }
}