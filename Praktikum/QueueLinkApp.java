package Praktikum;

class Mahasiswa2 {
    String nim;
    String nama;
    Mahasiswa2 next;

    public Mahasiswa2(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        this.next = null;
    }

    public void displayMahasiswa() {
        System.out.println(nim + " " + nama);
    }
}

class QueueLinkedList {
    private Mahasiswa2 front;
    private Mahasiswa2 rear;

    public QueueLinkedList() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public void insert(String nim, String nama) {
        Mahasiswa2 newNode = new Mahasiswa2(nim, nama);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
    }

    public Mahasiswa2 remove() {
        if (isEmpty()) {
            System.out.println("Queue kosong, tidak bisa remove.");
            return null;
        } else {
            Mahasiswa2 temp = front;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return temp;
        }
    }

    public void displayQueue() {
        System.out.println("Queue (front --> rear):");
        Mahasiswa2 current = front;
        while (current != null) {
            current.displayMahasiswa();
            current = current.next;
        }
        System.out.println();
    }
}

public class QueueLinkApp {
    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();

        queue.insert("1665100", "Dee");
        queue.insert("1665200", "Deaja");
        queue.displayQueue();

        queue.insert("1665300", "Ami");
        queue.insert("1665400", "Haya");
        queue.insert("1665500", "Yati");
        queue.displayQueue();

        queue.remove();
        queue.remove();
        queue.displayQueue();
    }
}
