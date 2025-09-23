package Praktikum;

class LinkStack {
    public int id;
    public String barang;
    public LinkStack next;

    LinkStack(int id,String barang) {
        this.id = id;
        this.barang = barang;
    }

    public void displayLinkStack() {
        System.out.println("{" + id + ", " + barang + "}");
    }
}
class LinkStackedList {
    private LinkStack top;

    public LinkStackedList() {
        top = null;
    }

    public boolean isEmpty() {
        return (top == null);
    }
    public void push(int id, String nama) {
        LinkStack newBarang = new LinkStack(id, nama);
        newBarang.next = top;
        top = newBarang;
    }
    public LinkStack pop(){
        if(isEmpty()){
            System.out.println("daftar barang kosong tidak bisa pop");
            return null;
        }else{
            LinkStack temp = top;
            top = top.next;
            return temp;
        }
    }
    public void display(){
        LinkStack current = top;
        System.out.println("stack (top to bottom)");
        while(current != null){
            current.displayLinkStack();
            current = current.next;
        }
        System.out.println();
    }
}

public class Elektronik {
    public static void main(String[] args) {
        LinkStackedList stack = new LinkStackedList();

        stack.push(1, "VCD");
        stack.push(2, "TV");
        stack.display();

        stack.push(3, "kulkas");
        stack.push(4, "PC");
        stack.push(5, "rice cooker");
        stack.push(6, "dispenser");
        stack.display();

        stack.pop();
        stack.pop();
        stack.display();
    }
}
