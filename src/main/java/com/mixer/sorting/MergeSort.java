package com.mixer.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = {10,9,8,7,6,5,4,3,2,1};
        sort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void sort(int arr[], int l, int r)
    {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /*public static void mergeSort(int[] a, int s, int e) {
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
    }*/
}
