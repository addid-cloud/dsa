package yt;

import java.util.LinkedList;

public class linklistedd {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        // linkedList.push("a");
        // linkedList.push("b");
        // linkedList.push("c");
        // linkedList.push("d");
        // linkedList.push("e");
        // linkedList.push("f");
        // linkedList.pop();
        linkedList.offer("a");
        linkedList.offer("b");
        linkedList.offer("c");
        linkedList.offer("d");
        linkedList.offer("e");
        linkedList.offer("f");
        System.out.println(linkedList);
    }
}
