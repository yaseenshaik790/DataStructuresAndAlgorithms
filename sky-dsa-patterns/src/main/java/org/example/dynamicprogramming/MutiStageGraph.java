package org.example.dynamicprogramming;

public class MutiStageGraph {

    public static void main(String[] args) {
        // Example graph
        int[][] c = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},//0
                {0, 0, 2, 1, 3, 0, 0, 0, 0},//1
                {0, 0, 0, 0, 0, 2, 3, 0, 0},//2
                {0, 0, 0, 0, 0, 6, 7, 0, 0},//3
                {0, 0, 0, 0, 0, 6, 8, 9, 0},//4
                {0, 0, 0, 0, 0, 0, 0, 0, 6},//5
                {0, 0, 0, 0, 0, 0, 0, 0, 4},//6
                {0, 0, 0, 0, 0, 0, 0, 0, 5},//7
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};//8

        int n = c.length;
        int[] cost = new int[n];

        int stages = 4;
        int[] dist = new int[n];

        cost[n-1] = 0;
        //Formula c(i,k) = min(c[i][k]+cost[k])
        //i -> stage , k-> next stage
        //dist -> destination or distance of next vertex
        for (int i= n-1; i >= 1; i--){
            int min = Integer.MAX_VALUE;
            for (int k = i+1; k < n; k++){
                if (c[i][k] != 0 && c[i][k] + cost[k] < min){
                    min = c[i][k] + cost[k];
                    dist[i] = k;
                }
            }
            cost[i] = min;
        }
        int[] paths = new int[stages];
        paths[0] = 1;
        paths[stages-1] = n-1;
        for (int i = 1; i< stages-1; i++){
            paths[i] = dist[paths[i-1]];
        }

        for (int path: paths) {
            System.out.println(path);
        }
    }


}
