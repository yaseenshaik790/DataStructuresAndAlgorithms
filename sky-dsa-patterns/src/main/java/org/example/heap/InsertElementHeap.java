package org.example.heap;

import java.util.Arrays;

public class InsertElementHeap {
    public static void main(String[] args) {
        int[] arr = {50, 30, 40, 10, 5, 20, 30};
        int n = arr.length;
        arr = Arrays.copyOf(arr, n + 1);
        insertElement(arr, n, 60);
        for (int num: arr) {
            System.out.println(num);
        }
    }

    public static void insertElement(int[] arr, int n, int value){
        arr[n] = value;
        int i= n;
        while (i > 0){
            int parent = (i-1)/2;
            if (arr[parent] < arr[i]){
                swap(arr, parent, i);
                i = parent;
            }else {
                return;
            }
        }
    }

    public static void swap(int[] arr, int parent, int i){
        int temp = arr[parent];
        arr[parent] = arr[i];
        arr[i] = temp;
    }
}
