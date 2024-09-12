package com.mixer.problems.dp.backtracking;

public class PrintAllSubsequenceOfString {

    public static void printSubsequence(String str, String result) {
        if(str.length() == 0) {
            System.out.println(result);
            return;
        }
        char curr = str.charAt(0);
        String remainingString = str.substring(1);
        printSubsequence(remainingString, result);
        printSubsequence(remainingString, result+curr);
    }

    public static void main(String[] args) {
        printSubsequence("abc", "");
    }
}
