package org.example.dynamicprogramming;

public class AllPairsShortestPathFloyd_WarShell {

    public static void main(String[] args) {
        /*int[][] matrix = new int[][]{
                {0, 3, Integer.MAX_VALUE, 7},
                {8, 0, 2, Integer.MAX_VALUE},
                {5, Integer.MAX_VALUE, 0, 1},
                {2, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}};*/

        int[][] matrix = new int[][]{
                {0, 1, 3},
                {1, 2, 1},
                {1, 3, 4},
                {2, 3, 1}};

        //A^k [i,j] = Min(A^k-1 [i,j] , A^k-1[i,k] + A^k-1 [k,j])
        int v = 4;
        for (int k = 1; k < 3; k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = Math.max(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (i == j) continue;
                System.out.println(i + " -> " + j + " @ " + matrix[i][j]);
            }
        }
    }
}
