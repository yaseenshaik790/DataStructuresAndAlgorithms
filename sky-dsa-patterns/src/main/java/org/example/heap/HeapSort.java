package org.example.heap;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {10, 20, 15, 12, 40, 25, 18};
        int n = arr.length;
        //Heapify
        for (int i= arr.length/2-1; i >= 0; i--){
            heapify(arr, n, i);
        }

        // Sorting By deleting edge node
        for (int i=n-1; i> 0; i--){
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }

        for (int ans: arr){
            System.out.println(ans);
        }
    }

    public static void heapify(int[] arr, int n, int i){
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left < n && arr[left] > arr[largest]){
            largest = left;
        }

        if(right < n && arr[right] > arr[largest]){
            largest = right;
        }

        if (largest != i){
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }

    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
