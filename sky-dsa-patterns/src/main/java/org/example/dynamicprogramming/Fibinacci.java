package org.example.dynamicprogramming;

class Test{

}
public class Fibinacci {

    public static void main(String[] args) {
        int n = 5;
        int[] ans = new int[5+1];
        System.out.println(fib(n, ans));
    }

    public static int fib(int n, int[] ans){
        if (n <= 1){
            return n;
        }
        ans[0] = 0;
        ans[1] = 1;
        for (int i=2; i<= n; i++){
            ans[i] =  ans[i-2] + ans[i-1];
        }
        return ans[n];
    }
}
