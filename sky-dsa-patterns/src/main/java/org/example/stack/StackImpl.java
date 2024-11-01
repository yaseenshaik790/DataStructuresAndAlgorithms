package org.example.stack;

import java.util.Stack;

public class StackImpl {
    int arraySize= 10;
    int[] arr = new int[arraySize];
    int peek = -1;

    public void push(int x){
        peek++;
        arr[peek] = x;
    }

    public int pop(){
        int val = arr[peek];
        arr[peek] = 0;
        peek--;
        return val;
    }

    public int peek(){
        if (peek == -1){
            throw new ArrayIndexOutOfBoundsException();
        }
        return arr[peek];
    }

    public int size(){
        return peek+1;
    }

    public static void main(String[] args) {
        StackImpl stack = new StackImpl();
        stack.push(10);
        stack.push(20);
        System.out.println(stack.peek());
        stack.pop();
        stack.push(30);
        System.out.println(stack.size());

        System.out.println("============");
        Stack<Integer> actualStack = new Stack<>();
        actualStack.push(10);
        actualStack.push(20);
        System.out.println(actualStack.peek());
        actualStack.pop();
        actualStack.push(30);
        System.out.println(actualStack.size());

    }
}
