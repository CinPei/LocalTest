package com.cin.dr.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC120 {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(-1);
        triangle.add(list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(-2);
        list2.add(-3);
        triangle.add(list2);

        int size = triangle.size();
        int[][] dp = new int[size][size];

        dp[0][0] = triangle.get(0).get(0);
        if(size < 2){
//            return dp[0][0];
        }
        for(int i=1; i<triangle.size(); i++){
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
            for(int j=1; j<i; j++){
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
            }
        }
        int result = dp[size-1][0];
        for(int j=1;j<size;j++){
            result = Math.min(result,dp[size-1][j]);
        }

        System.out.println(result);
    }
}
