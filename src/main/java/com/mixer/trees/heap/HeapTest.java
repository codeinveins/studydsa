package com.mixer.trees.heap;

import java.util.Arrays;


//important questions
//1. Find kth largest or kth smallest number?
//2. Find the Binary tree is max heap or not?
//3. Minimum cost of ropes problem.

public class HeapTest {

    static int heap[];

    public static void main(String[] args) {
        heap = new int[]{2,4,7,8,1,3,5};
        System.out.print("Original      = "); print(heap);
        buildMinHeap(heap);
        System.out.print("Min Heap      = "); print(heap);
        System.out.print("Extract Min   = "+extractMin());
        System.out.println(); print(heap);
        System.out.print("Extract Min   = "+extractMin());
        System.out.println(); print(heap);

        buildMaxHeap(heap);
        System.out.print("Max Heap      = "); print(heap);
        maxHeapify(heap, 0);
        System.out.print("Extract Max   = "+extractMax());
        System.out.println(); print(heap);
        System.out.print("Extract Max   = "+extractMax());
        System.out.println(); print(heap);

        System.out.println("Inserting 7 = ");insertInMaxHeap(7);
        print(heap);
        System.out.println("Inserting 1 = ");insertInMaxHeap(1);
        print(heap);

    }
    public static void print(int a[]) {
        for (int t : a) {
            System.out.print(t + " -> ");
        }
        System.out.println();
    }
    public static void maxHeapify(int[] heap, int i) {
        int left = 2*i+1;
        int right = 2*i+2;
        int largest;
        //System.out.println(i + " -- " + left + " -- " + right);
        if(left < heap.length && heap[left] > heap[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if(right < heap.length && heap[right] > heap[largest]) {
            largest = right;
        }

        if(largest != i) {
            //swap
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;

            maxHeapify(heap, largest);
        }
    }
    public static void minHeapify(int[] heap, int i) {
        int left = 2*i+1;
        int right = 2*i+2;
        int smallest;
        if(left < heap.length && heap[left]<heap[i]) {
            smallest = left;
        } else {
            smallest = i;
        }

        if(right < heap.length && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if(smallest != i) {
            //swap
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;

            minHeapify(heap, smallest);
        }
    }
    public static void buildMaxHeap(int[] array) {
        for(int i=(array.length+2-1)/2-1; i >= 0; i--) {
            maxHeapify(array, i);
        }
    }
    public static void buildMinHeap(int[] array) {
        for(int i=(array.length+2-1)/2-1; i >= 0; i--) {
            minHeapify(array, i);
        }
    }
    public static int extractMax() {
        if(heap.length < 1) {
            System.out.println("HEAP UNDERFLOW");
            return 0;
        }

        int max = heap[0];
        heap[0] = heap[heap.length-1];
        heap = Arrays.copyOf(heap, heap.length-1);
        maxHeapify(heap,0);
        return max;

    }
    public static int extractMin() {
        if(heap.length < 0) {
            System.out.println("HEAP UNDERFLOW");
        }

        int min = heap[0];
        heap[0] = heap[heap.length-1];
        heap = Arrays.copyOf(heap, heap.length-1);
        return min;
    }
    public static void insertInMaxHeap(int val) {
        heap = Arrays.copyOf(heap, heap.length+1);
        heap[heap.length-1] = val;
        int i = heap.length-1;
        while(i>0 || heap[i/2] < heap[i]) {
            int temp = heap[i/2];
            heap[i/2] = heap[i];
            heap[i] = temp;

            i = i/2;
        }
    }
}
