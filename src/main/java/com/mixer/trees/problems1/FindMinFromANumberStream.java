package com.mixer.trees.problems1;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMinFromANumberStream {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    private void insert(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if(maxHeap.size() > minHeap.size()+1) {
            minHeap.add(maxHeap.poll());
        } else if(maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public static void main(String[] args) {

    }
}
