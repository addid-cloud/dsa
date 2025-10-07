package Praktikum;

import java.util.ArrayList;

class LinkQueue{
    String nim;
    String nama;
    LinkQueue next;
    LinkQueue(String nim, String nama){
        this.nim = nim;
        this.nama = nama;
    }

    public void displayMhs(){
        System.out.println(nim +"   "+nama);
    }
    
}

class linkedQueueList{
    LinkQueue first;
    LinkQueue end;
    public linkedQueueList() {
        first = null;
        end = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }
    public void insert(String nim, String nama) {
        LinkQueue mhsBaru = new LinkQueue(nim, nama);
        if(isEmpty()){
            first = mhsBaru;
        }else{
            end.next = mhsBaru;
        }
            end = mhsBaru;
    }

    public LinkQueue remove() {
        if (isEmpty()) {
            System.out.println("Mahasiswa kosong, tidak bisa remove.");
            return null;
        } else {
            LinkQueue temp = first;
            first = first.next;
            if (first == null) {
                end = null;
            }
            return temp;
        }
    }

    public void displayQueue() {
        System.out.println("Queue (first --> end):");
        LinkQueue current = first;
        while (current != null) {
            current.displayMhs();
            current = current.next;
        }
        System.out.println();
    }
}

public class MhsLink {
    public static void main(String[] args) {
        linkedQueueList queue = new linkedQueueList();

        queue.insert("1665100", "Dee");
        queue.insert("1665200", "Deaja");
        queue.insert("1665300", "Ami");
        queue.insert("1665400", "Haya");
        queue.insert("1665500", "Yati");

        // ambil semua data queue ke ArrayList
        ArrayList<LinkQueue> list = new ArrayList<>();
        LinkQueue current = queue.first;
        while (current != null) {
            list.add(current);
            current = current.next;
        }

        System.out.println("Data Asli:");
        MhsSorter.display(list);

        // 1. Merge Sort berdasarkan Nama
        System.out.println("Merge Sort by Nama:");
        MhsSorter.mergeSortByNama(list);
        MhsSorter.display(list);

        // 2. Shell Sort berdasarkan NIM
        System.out.println("Shell Sort by NIM:");
        MhsSorter.shellSortByNim(list);
        MhsSorter.display(list);

        // 3. Quick Sort berdasarkan Nama
        System.out.println("Quick Sort by Nama:");
        MhsSorter.quickSortByNama(list, 0, list.size() - 1);
        MhsSorter.display(list);
 
    
    }

}
