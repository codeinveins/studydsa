package com.mixer.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int a[] = {9,2,3,1,5,8,7,6,4};
        System.out.println(Arrays.toString(a));
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] a, int startIndex, int endIndex) {
        if(startIndex < endIndex) {
            int posOfPivot = partition(a, startIndex, endIndex);
            quickSort(a, startIndex, posOfPivot-1);
            quickSort(a, posOfPivot+1, endIndex);
        }
    }

    private static int partition(int[] a, int startIndex, int endIndex) {
        int pivot = a[endIndex];
        int lessThanPivotIndex = startIndex-1;

        for(int i=startIndex; i<=endIndex-1; i++) {
            if(a[i] < pivot) {
                lessThanPivotIndex = swap(a, lessThanPivotIndex, i);
            }
        }

        //place pivot at correct index
        lessThanPivotIndex = swap(a, lessThanPivotIndex, endIndex);

        return lessThanPivotIndex;
    }

    private static int swap(int []a, int lessThanPivotIndex, int indexToSwap) {
        lessThanPivotIndex += 1;
        int temp = a[lessThanPivotIndex];
        a[lessThanPivotIndex] = a[indexToSwap];
        a[indexToSwap] = temp;
        return lessThanPivotIndex;
    }
}
