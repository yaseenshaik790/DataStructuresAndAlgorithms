package org.example.stack;


public class QueueImpl {
    int arraySize= 10;
    int[] arr = new int[arraySize];
    int start = -1;
    int end = -1;
    int currSize = 0;

    public void push(int x){
        if (currSize == arraySize){
            System.out.println("Queue Overflow");
        } else if (currSize == 0){
            start = 0;
            end = 0;
        } else {
            start = (start+1)%arraySize;
        }
        arr[end++] = x;
        currSize++;
    }

    public int pop(){
        if (currSize == 0){
            System.out.println("Queue is empty");
        }
        int val = arr[start];
        if (currSize == 1){
            start = end = -1;
        }else {
            start = (start + 1)% arraySize;
        }
        currSize--;
        return val;
    }

    public int peek(){
        if (start == -1){
            System.out.println("Queue is empty");
        }
        return arr[start];
    }

    public int size(){
        return currSize;
    }

    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl();
        queue.push(10);
        queue.push(20);
        queue.push(10);
        queue.push(20);
        System.out.println(queue.peek());
        queue.pop();
        queue.push(30);
        System.out.println(queue.size());
        System.out.println(queue.peek());
    }
}
