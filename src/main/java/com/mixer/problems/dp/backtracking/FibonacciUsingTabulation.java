package com.mixer.problems.dp.backtracking;

/*
    Given input N, print Nth fibonacci number
 */

import java.util.Arrays;

public class FibonacciUsingTabulation {

    public static void fillFibonacciNumber(int n, int[]dp) {

        for (int i=2; i<=n ;i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
    }

    //0 1 1 2 3 5 8 13
    public static void main(String[] args) {

        int n=6;
        int[] dp = new int[n+1];
//        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;
        fillFibonacciNumber(n,dp);
        System.out.println(dp[n-1]);
    }
}
