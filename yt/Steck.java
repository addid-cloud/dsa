package yt;

import java.util.Stack;

public class Steck {
public static void main(String[] args) {
    // stack = lifo (last in first out)
    // stores objects into a sort of "vertical tower"
    // push() to add items
    // pop() to remove items
    Stack<String> stack = new Stack<String>();
    stack.push("minecraft");
    stack.push("sky rim");
    stack.push("DOOM");
    stack.push("borderlands");
    stack.push("Final Fantasy 7");
    String myFavGame = stack.pop();
    System.out.println(stack.peek()); /// buat ngeliat paling atas
    System.out.println(stack.search("DOOM")); // buat nyari index
    System.out.println(stack);
    stack.pop();
    System.out.println(stack);
    stack.pop();
    System.out.println(stack);
    // uses of stacks
    // undo / redo features
    // moving back / forward browser history
    // backtracking algorithm
    // calling function(call stack)

}
}