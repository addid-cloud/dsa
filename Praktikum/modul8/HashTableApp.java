package Praktikum.modul8;

class Data {
    private int data;

    public Data(int data) {
        this.data = data;
    }

    public int getKey() {
        return data;
    }
}

class HashTable {
    private Data[] hashArray;
    private int size;

    public HashTable(int size) {
        this.size = size;
        hashArray = new Data[size];
    }

    public void displayTable() {
        System.out.println("Table: ");
        for (int j = 0; j < size; j++) {
            if (hashArray[j] != null) {
                System.out.println(" | " + j + "\t | "
                        + hashArray[j].getKey() + " |");
            } else {
                System.out.println(" | " + j + "\t | -- |");
            }
        }
        System.out.println("");
    }

    public int hashFunc(int key) {
        return key % size;
    }

    public void insert(int data) {
        Data item = new Data(data);
        int key = item.getKey();
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null) {
            ++hashVal;
            hashVal %= size;
        }
        hashArray[hashVal] = item;
    }

    public Data delete(int key) {
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                Data temp = hashArray[hashVal];
                hashArray[hashVal] = null;
                return temp;
            }
            ++hashVal;
            hashVal %= size;
        }
        return null;
    }

    public Data find(int key) {
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal %= size;
        }
        return null;
    }
} // akhir class HashTable

public class HashTableApp {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(15);
        int[] dataArray = { 12, 44, 13, 88, 23, 94, 11, 39, 20, 16 };
        for (int data : dataArray) {
            hashTable.insert(data);
        }
        System.out.println("=== Isi Hash Table Setelah Insert 10 Data ===");
        hashTable.displayTable();
        int keyToFind = 23;
        if (hashTable.find(keyToFind) != null) {
            System.out.println("Data dengan key " + keyToFind + " ditemukan di tabel.");
        } else {
            System.out.println("Data dengan key " + keyToFind + " tidak ditemukan.");
        }
        hashTable.delete(23);
        hashTable.displayTable();
        int[] dataBaru = { 17, 32, 45, 57, 68 };
        for (int d : dataBaru) {
            hashTable.insert(d);
        }

        System.out.println("=== Isi Tabel Setelah Penambahan ===");
        hashTable.displayTable();
    }
}
