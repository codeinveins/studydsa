package com.mixer.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = {10,9,8,7,6,5,4,3,2,1};
        mergeSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int[] a, int s, int e) {
        if(s < e) {
            int mid = (s+(e-s))/2;
            mergeSort(a, s, mid);
            mergeSort(a,mid+1, e);
            merge(a, s, mid, e);
        }
    }

    private static void merge(int[] a, int s, int mid, int e) {
        int lSize = mid-s+1;
        int rSize = e-(mid+1)+1;

        int leftArray[]  = new int[lSize];
        int rightArray[] = new int[rSize];

        //fill data in temporary arrays
        for(int i=0; i<lSize; i++) {
            leftArray[i] = a[s+i];
        }
        for(int j=0; j<rSize; j++) {
            rightArray[j] = a[mid+1+j];
        }

        int i=0,j=0,k=s;

        while(i<lSize && j<rSize) {
            if(leftArray[i]<=rightArray[j]) {
                a[k] = leftArray[i];
                i++;
            } else {
                a[k] = rightArray[j];
                j++;
            }
            k++;
        }

        //left over elements in leftArray
        while(i<lSize) {
            a[k] = leftArray[i];
            k++; i++;
        }

        //left over elements in rightArray
        while(j<rSize) {
            a[k] = rightArray[j];
            k++; j++;
        }
    }
}
