package Praktikum;

class Queue2 {
    private int maxSize;
    private String[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue2(int size) {
        maxSize = size;
        queArray = new String[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(String value) {
        if (isFull()) {
            System.out.println("Maaf " + value + ", antrian masih penuh");
        } else {
            if (rear == maxSize - 1) {
                rear = -1;
            }
            queArray[++rear] = value;
            nItems++;
            System.out.println(value + " masuk antrian");
        }
    }

    public String remove() {
        if (isEmpty()) {
            return "Kosong";
        }
        String temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        System.out.println(temp + " Keluar antrian");
        return temp;
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public void tampil() {
        System.out.print("Isi antrian: ");
        int count = 0;
        int i = front;
        while (count < nItems) {
            System.out.print(queArray[i] + ",");
            i++;
            if (i == maxSize) {
                i = 0;
            }
            count++;
        }
        // sisa kosong
        for (int j = nItems; j < maxSize; j++) {
            System.out.print("Kosong,");
        }
        System.out.println();
    }
}

public class QueueApp2 {
    public static void main(String[] args) {
        Queue2 antrian = new Queue2(4);

        System.out.println(">> beberapa mulai mengantri");
        antrian.insert("Andi");
        antrian.insert("Ahmad");
        antrian.insert("Satrio");
        antrian.insert("Afrizal");
        antrian.insert("Sukran"); // penuh
        antrian.insert("Mahmud"); // penuh

        System.out.println("\n>> isi antrian");
        antrian.tampil();

        System.out.println("\n>> satu persatu keluar antrian");
        while (!antrian.isEmpty()) {
            antrian.remove();
            antrian.tampil();
        }

        System.out.println("\nantrian kosong");
        antrian.tampil();
        System.out.println("0 Person");
    }
}
