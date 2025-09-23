package Praktikum;

class Barang {
    int id;
    String nama;
    Barang next;

    public Barang(int id, String nama) {
        this.id = id;
        this.nama = nama;
        this.next = null;
    }

    public void displayBarang() {
        System.out.println("{" + id + ", " + nama + "}");
    }
}

class StackLinkedList {
    private Barang top;

    public StackLinkedList() {
        this.top = null;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public void push(int id, String nama) {
        Barang newBarang = new Barang(id, nama);
        newBarang.next = top;
        top = newBarang;
    }

    public Barang pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong, tidak bisa pop.");
            return null;
        } else {
            Barang temp = top;
            top = top.next;
            return temp;
        }
    }

    public void displayStack() {
        System.out.println("Stack(top --> bottom):");
        Barang current = top;
        while (current != null) {
            current.displayBarang();
            current = current.next;
        }
        System.out.println();
    }
}

public class StackLinkApp {
    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();

        stack.push(1, "VCD");
        stack.push(2, "TV");
        stack.displayStack();

        stack.push(3, "kulkas");
        stack.push(4, "PC");
        stack.push(5, "rice cooker");
        stack.push(6, "dispenser");
        stack.displayStack();

        stack.pop();
        stack.pop();
        stack.displayStack();
    }
}
