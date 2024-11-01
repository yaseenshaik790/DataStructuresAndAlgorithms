package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class MazePaths {

    public static void main(String[] args) {
        List<String> ans = mazePaths(1, 1, 3, 3);
        System.out.println(ans.size());
        for (String a: ans){
            System.out.println(a);
        }
    }

    public static List<String> mazePaths(int sr, int sc, int m, int n){
        if(sr == m && sc == n){
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        List<String> paths = new ArrayList<>();
        //horizontal
        for (int move=1; move< m-sr; move++){
            List<String> hpaths = mazePaths(sr+move, sc, m, n);

            for (String  vpa: hpaths){
                paths.add("h"+move+vpa);
            }
        }

        //vertical
        for (int move=1; move< n-sc; move++){
            List<String> vpaths = mazePaths(sr, sc+move, m, n);
            for (String vpa: vpaths){
                paths.add("v"+move+vpa);
            }
        }

        //diagonal
        for (int move=1; move < n-sc && move < m-sr; move++){
            List<String> dpaths = mazePaths(sr+move, sc+move, m, n);
            for (String  vpa: dpaths){
                paths.add("d"+move+vpa);
            }
        }
        return paths;
    }
}
