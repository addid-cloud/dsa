package yt;

class Link {
    public int data1;
    public Link next;

    public Link(int data1) {
        this.data1 = data1;
    }

    public void displayLink() {
        System.out.println(data1 + " ");
    }
}

class LinkedList {
    private Link first;

    public LinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int data1) {
        Link newLink = new Link(data1);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public Link find(int key) {
        Link current = first;
        while (current.data1 != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int key) {
        Link current = first;
        Link previous = first;
        while (current.data1 != key) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }

    public void displayList() {
        System.out.println("List(first-->last):");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    public void insertLast(int data1) {
        Link newLink = new Link(data1);
        if (first == null) {
            first = newLink;
        } else {
            Link current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newLink;
        }
    }

    public Link deleteLast() {
        if (first == null) {
            System.out.println("List kosong, tidak ada data1 yang dihapus.");
            return null;
        }
        if (first.next == null) {
            Link temp = first;
            first = null;
            return temp;
        }
        Link current = first;
        while (current.next.next != null) {
            current = current.next;
        }
        Link temp = current.next;
        current.next = null;
        return temp;
    }

    public boolean deleteByValue(int key) {
        if (first == null)
            return false;
        if (first.data1 == key) {
            first = first.next;
            return true;
        }
        Link current = first;
        while (current.next != null) {
            if (current.next.data1 == key) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean insertAfter(int key, int newdata1) {
        Link current = first;
        while (current != null) {
            if (current.data1 == key) {
                Link newLink = new Link(newdata1);
                newLink.next = current.next;
                current.next = newLink;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean insertBefore(int key, int newdata1) {
        if (first == null)
            return false;
        if (first.data1 == key) {
            insertFirst(newdata1);
            return true;
        }
        Link current = first;
        while (current.next != null) {
            if (current.next.data1 == key) {
                Link newLink = new Link(newdata1);
                newLink.next = current.next;
                current.next = newLink;
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList theList = new LinkedList();
        theList.insertFirst(30);
        theList.insertFirst(20);
        theList.insertFirst(10);
        theList.displayList();

        theList.insertAfter(20, 25);
        theList.displayList();

        theList.insertBefore(20, 15);
        theList.displayList();

        if (theList.deleteByValue(25)) {
            System.out.println("data1 25 berhasil dihapus.");
        } else {
            System.out.println("data1 25 tidak ditemukan.");
        }
        theList.displayList();
    }
}
