package org.example.patterns.preFixSum;

public class PrefixSumExample {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        int n = height.length;
        int a = 0;
        int max = 0;
        while(a < n-1){
            int b = a+1;
            while(b < n){
                int index = b-a;
                int len = Math.min(height[a] ,height[b]);
                int val = index*len;
                max = Math.max(max, val);
                b++;
            }

            a++;
        }

        System.out.println(max);
    }
}
