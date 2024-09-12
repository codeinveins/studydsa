package com.mixer.problems.dp.backtracking;

/*
    Given input N, print Nth fibonacci number
 */

public class FibonacciUsingRecursion {

    public static int printFibonacciNumber(int n) {
        if(n==0) {
            return 0;
        }
        else if(n==1 || n==2) {
            return 1;
        }
        return printFibonacciNumber(n - 1) + printFibonacciNumber(n - 2);
    }

    //0 1 1 2 3 5 8 13
    public static void main(String[] args) {
        System.out.println(printFibonacciNumber(4));
    }
}
