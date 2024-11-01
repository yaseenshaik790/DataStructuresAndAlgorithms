package org.example.dynamicprogramming;

public class MultiStageGraphProblem2 {

    public static void main(String[] args) {
        int[][] graph =new int[][] {
                {0, 1, 2, 5, 9999, 9999, 9999},//0
                {9999, 0, 9999, 9999, 4, 11, 9999},//1
                {9999, 9999, 0, 9999, 9, 5, 16},//2
                {9999, 9999, 9999, 0, 9999, 9999, 2},//3
                {9999, 9999, 9999, 9999, 0, 9999, 9999},//4
                {9999, 9999, 9999, 9999, 9999, 0, 9999},  //5
                {9999, 9999, 9999, 9999, 9999, 9999, 0}};//6

        int n = graph.length; //7
        int[] cost = new int[n];
        int[] dist = new int[n];
        int stages = 4;
        cost[n-1] = 0;
        for (int i= n-1; i >= 0; i--){
            int min = Integer.MAX_VALUE;
            for (int k = i+1; k < n; k++){
                if (graph[i][k] != 9999 && graph[i][k]+cost[k] < min){
                    min = graph[i][k]+cost[k];
                    dist[i] = k;
                }
            }
            cost[i] = min;
        }

        int[] paths = new int[stages];
        paths[0] = 0;
        paths[stages-1] = n-1;
        for (int i=1; i< stages-1; i++){
            paths[i] = dist[paths[i-1]];
        }

        for (int path: paths){
            System.out.println(path);
        }

    }
}
