package org.example.heap;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class DeleteElementHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] arr = {50, 30, 40, 10, 5, 20, 30};
        int n = arr.length;
        deleteElement(arr, n, 50);
        for (int num: arr) {
            System.out.println(num);
        }
    }

    public static void deleteElement(int[] arr, int n, int value){
        //assign last element to frst
        arr[0] = arr[n-1];
        arr[n-1] = 0;
        int i= 0;
        //Traverse from Top to fulfill Binary Tree or Heap structure
        while (2 * i + 1 < n){
            int left = 2*(i);
            int right = 2*(i+1);
            int large = arr[left] < arr[right] ? left : right;
            if (arr[large] < arr[i]){
                swap(arr, large, i);
                i = large;
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
