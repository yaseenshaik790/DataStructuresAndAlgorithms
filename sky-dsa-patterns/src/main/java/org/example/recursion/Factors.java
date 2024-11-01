package org.example.recursion;

import org.example.Main;

import java.util.ArrayList;
import java.util.BitSet;

public class Factors {
    public static void main(String[] args) {
        int[] arr = {1,5,3,2,7,4,3,4};
        int N = 13;
        int k = 0;

        StringBuilder sb = new StringBuilder("10001000");
        sb.reverse();//00010001
        double ans = 0;
        for(int idx = 0; idx < sb.length(); idx++){
            char ch = sb.charAt(idx);
            if(ch == '1'){
                ans = ans + Math.pow(2, idx);
            }
        }
        System.out.print(ans);
    }

    public static ArrayList<String> getSS(String str){
        if (str.isEmpty()){
            ArrayList<String> l = new ArrayList<>();
            l.add(" ");
            return l;
        }
        char ch = str.charAt(0);
        String ss = str.substring(1);
        ArrayList<String> res = getSS(ss);
        ArrayList<String> ans = new ArrayList<>();

        for (String r : res){
            ans.add(" "+r);
            ans.add(ch+r);
        }
        return ans;
    }

    public static int maxArray(int[] arr, int n, int x, int k){
        if (n == arr.length-1){
            return n;
        }
        if (arr[n] == x){
            k = n;
            return n;
        }
        int ans = maxArray(arr, n+1, x, k);
        return ans;
    }

    public static void pzz(int n){
        if (n == 0){
            return;
        }

        System.out.println("Pre "+n);
        pzz(n-1);
        System.out.println("In "+n);
        pzz(n-1);
        System.out.println("Post "+n);

    }

    public static int logarithmic(int x, int n){
        if (n == 0){
            return 1;
        }

        int xn = logarithmic(x, n/2);
        int xres = xn * xn;
        if (n % 2 != 0){
            xres = xres * x;
        }
        return xres;
    }

    public static int factorial(int n){
        if (n == 1){
            return 1;
        }
        int res = factorial(n-1);
        return res*n;
    }


}
