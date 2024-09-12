package com.mixer.graphs.mst;

import java.util.*;

public class MST {

    public static void main(String[] args) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new int[]{1,4}, new int[]{2,2}));
        graph.put(1, Arrays.asList(new int[]{0,4}, new int[]{2,1}, new int[]{3,5}));
        graph.put(2, Arrays.asList(new int[]{0,2}, new int[]{1,1}, new int[]{3,6}));
        graph.put(3, Arrays.asList(new int[]{1,5}, new int[]{2,6}));

        Map<Integer, Integer> mst = primsMst(graph, 0);
        printMst(mst);
    }

    static class Node {
        int weight;
        int node;
        int parent;

        Node(int w, int n, int p) {
            this.weight = w;
            this.node = n;
            this.parent = p;
        }
    }

    static class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o1.weight, o2.weight);
        }
    }

    static Map<Integer, Integer> primsMst(Map<Integer, List<int[]>> graph, int startNode) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new NodeComparator());
        Map<Integer, Boolean> visited = new HashMap<>();
        Map<Integer, Integer> mst = new HashMap<>();
        int sum = 0;

        minHeap.add(new Node(0, startNode, -1));
        while(!minHeap.isEmpty()) {
            Node curr = minHeap.poll();

            if(visited.containsKey(curr.node) && visited.get(curr.node)) {
                continue;
            }

            visited.put(curr.node, true);
            sum += curr.weight;

            if(curr.parent != -1) {
                mst.put(curr.node, curr.parent);
            }

            //explore all connected nodes and select min
            for(int[] connectedNodes : graph.getOrDefault(curr.node, new ArrayList<>())) {
                int node = connectedNodes[0];
                int weight = connectedNodes[1];
                if(!visited.containsKey(node)) {
                    minHeap.add(new Node(weight, node, curr.node));
                }
            }

            //printMst(mst);
            //System.out.println("Total weight of mst = " + sum);
        }
        return mst;
    }

    static void printMst(Map<Integer, Integer> mst) {
        for(Map.Entry<Integer, Integer> entry : mst.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }


}


