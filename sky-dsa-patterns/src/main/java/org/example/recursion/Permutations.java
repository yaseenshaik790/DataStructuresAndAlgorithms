package org.example.recursion;

import java.util.HashMap;
import java.util.Stack;

public class Permutations {

    public static void main(String[] args) {
        String qes = "abc";
        String ans = "";
        printPermutations(qes, ans);

        int[] arr = {1, 2, 3};
        int[] res = new int[arr.length];
        printPermutationsArray(arr, res);
    }

    private static void printPermutationsArray(int[] qes, int[] ans) {
        if (qes.length == 0){
            for (int v : ans){
                System.out.print(v+" ");
            }
        }
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for (int i=0; i< qes.length; i++){
            stack.push(qes[i]);

            hm.put(qes[i], true);
            //printPermutations(res, ans+ch);
        }
    }

    private static void printPermutations(String qes, String ans) {
        if (qes.isEmpty()){
            System.out.println(ans);
        }
        for (int i=0; i< qes.length(); i++){
            char ch = qes.charAt(i);
            String left = qes.substring(0,i);
            String right = qes.substring(i+1);
            String res = left+right;
            printPermutations(res, ans+ch);
        }
    }

}
