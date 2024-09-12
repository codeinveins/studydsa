package com.mixer.trees.heap;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static int findKthLargest(int[] a, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0; i<k; i++) {
            minHeap.offer(a[i]);
        }

        for(int i=k; i<a.length; i++) {
            if(a[i] > minHeap.peek()) {
                minHeap.remove();
                minHeap.offer(a[i]);
            }
        }

        return minHeap.peek();

    }

    public static void main(String[] args) {

        int a[] = new int[]{7,3,4,8,9,20,22,2,1};
        System.out.println(findKthLargest(a, 2));
    }
}
