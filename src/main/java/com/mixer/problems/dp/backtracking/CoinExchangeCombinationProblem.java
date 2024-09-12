package com.mixer.problems.dp.backtracking;


/*
Given input as an array containing coins denominations and a sum.
You need to find the possible combinations of coins whose total is equal to sum,
providing we have an infinite supply of each coin in the array.
Note: Don't include permutations of same combination of the coins as it means the same
 */

public class CoinExchangeCombinationProblem {

    public static void coinExchange(int[] coins, int sum, String res, int lastIndex) {
        if(sum == 0) {
            System.out.println(res);
            return;
        }

        //this loop ignores different permutations of same answer
        for(int i=lastIndex; i<coins.length; i++) {
            //this condition stops from picking the coin if it cannot form the sum
            if(sum >= coins[i]) {
                coinExchange(coins, sum-coins[i], res+coins[i], i);
            }
        }


        //To print all possible permutations of the coin combination
        /*
        for(int i=0; i<coins.length; i++) {
            if(sum >= coins[i]) {
                coinExchange(coins, sum-coins[i], res+coins[i], i);
            }
        }
         */
    }

    public static void main(String[] args) {
        int[] coins = {2,3,5,6};
        int sum = 10;
        coinExchange(coins, sum,"",0);
    }
}
