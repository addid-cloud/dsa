package Praktikum;

import java.util.Scanner;

class Stack2 {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public Stack2(int size) {
        maxSize = size;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char item) {
        stackArray[++top] = item;
    }

    public char pop() {
        return stackArray[top--];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}

class Pembalik {
    private String input;

    public Pembalik(String input) {
        this.input = input;
    }

    public String balik() {
        int size = input.length();
        Stack2 stack = new Stack2(size);
        for (int i = 0; i < size; i++) {
            stack.push(input.charAt(i));
        }
        String output = "";
        while (!stack.isEmpty()) {
            output += stack.pop();
        }
        return output;
    }
}

public class AppPembalik {
    public static void main(String[] args) {
        String kata = "kasur";
        Pembalik pembalik = new Pembalik(kata);

        String hasil = pembalik.balik();

        System.out.println("Kata asli   : " + kata);
        System.out.println("Kata dibalik: " + hasil);
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            System.out.print("Kata asli   : ");
            kata = sc.nextLine();
            pembalik = new Pembalik(kata);
            hasil = pembalik.balik();
            System.out.println("Kata dibalik: " + hasil);
        }
    }
}
