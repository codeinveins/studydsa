package com.mixer.trees.problems1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class FirstAndLastIndexOfTargetInSortedArray {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter sorted array: ");
        int []a = Arrays.stream(s.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Enter target value: ");
        int t = s.nextInt();

        int[] r = findFirstAndLastIndexLinear(a, t);
        System.out.println("First and last index of " + t + " is " + Arrays.toString(r));
        int[] rb = findFirstAndLastIndexBinary(a, t);
        System.out.println("First and last index of " + t + " is " + Arrays.toString(rb));
    }

    private static int[] findFirstAndLastIndexLinear(int[] a, int target) {
        int[] r = {-1, -1};
        for(int i=0 ; i<a.length; i++) {
            if(a[i] == target && r[0] == -1) {
                r[0] = i;
                if(i==a.length-1) {
                    r[1] = i;
                }
            } else if(a[i] == target) {
                r[1] = i;
            }
        }
        if(r[0] != -1 && r[1] == -1) {
            r[1] = r[0];
        }
        return r;
    }

    private static int[] findFirstAndLastIndexBinary(int[] a, int target) {
        int r[] = {-1, -1};
        int midIndex = a.length/2;
        if(a[midIndex] < target) {
            findFirstAndLastIndexBinary(Arrays.copyOfRange(a, midIndex, a.length+1), target);
        } else if(a[midIndex] > target) {
            findFirstAndLastIndexBinary(Arrays.copyOfRange(a, 0, midIndex+1), target);
        } else {
            r[0] = midIndex;
            if(midIndex+1 < a.length && a[midIndex+1] == target) {
                r[1] = midIndex+1;
            } else if(midIndex-1 < a.length && a[midIndex-1] == target) {
                r[1] = midIndex-1;
            } else {
                r[1] = midIndex;
            }
        }
        return r;
    }
}
