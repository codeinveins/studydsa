package com.mixer.problems.dp.backtracking;

/*
    Given input N, print Nth fibonacci number
 */

import java.util.Arrays;

public class FibonacciUsingMemoization {

    public static int printFibonacciNumber(int n, int[]dp) {
        if(n==0) {
            return 0;
        }
        else if(n==1 || n==2) {
            return 1;
        }

        //System.out.println(Arrays.toString(dp));
        if(dp[n] != -1)
            return dp[n];

        dp[n]=printFibonacciNumber(n - 1,dp) + printFibonacciNumber(n - 2,dp);
        return dp[n];
    }

    //0 1 1 2 3 5 8 13
    public static void main(String[] args) {

        int n=6;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        System.out.println(printFibonacciNumber(n,dp));
    }
}
