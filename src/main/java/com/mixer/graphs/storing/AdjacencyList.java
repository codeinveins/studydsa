package com.mixer.graphs.storing;

import java.util.ArrayList;

//Occupy O(V) space
//Time for finding neighbour is O(x) -> x is number of neighbouring nodes
public class AdjacencyList {

    static class Edge {
        int src;
        int dest;

        int weight;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    //
    //       A(0)------C(2)
    //             /   |
    //          B(1)   |
    //             \   |
    //              ---D(3)
    //

    private static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,2, 2));

        graph[1].add(new Edge(1,2, 10));
        graph[1].add(new Edge(1,3, 0));

        graph[2].add(new Edge(2,0, 2));
        graph[2].add(new Edge(2,1, 10));
        graph[2].add(new Edge(2,3, -1));

        graph[3].add(new Edge(3,1, 0));
        graph[3].add(new Edge(3,2, -1));

    }



    public static void main(String[] args) {
        int v = 4;

        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);

        //print neighbours of 2
        for(int i=0; i<graph[2].size(); i++) {
            System.out.println(graph[2].get(i).dest+" -- "+ graph[2].get(i).weight);
        }
    }
}
