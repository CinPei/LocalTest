package com.cin.interview;

public class pack01 {
    public static void main(String[] args) {

    }

    private int pack0_1(int N, int W, int[] wt, int[] val){
        int[][] dp = new int[N+1][W+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (j < wt[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-wt[i-1]] + val[i-1]);
                }
            }
        }
        return dp[N][W];

    }
}
