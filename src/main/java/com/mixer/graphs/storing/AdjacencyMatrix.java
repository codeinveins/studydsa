package com.mixer.graphs.storing;

//Occupy O(V^2) space
//Time for finding neighbour is O(v)
public class AdjacencyMatrix {

    private static void createGraph(int[][] graph) {

        graph[0][0] = 0;
        graph[0][1] = 0;
        graph[0][2] = 1;
        graph[0][3] = 0;

        graph[1][0] = 0;
        graph[1][1] = 0;
        graph[1][2] = 1;
        graph[1][3] = 1;

        graph[2][0] = 1;
        graph[2][1] = 1;
        graph[2][2] = 0;
        graph[2][3] = 1;

        graph[3][0] = 0;
        graph[3][1] = 1;
        graph[3][2] = 1;
        graph[3][3] = 0;
    }

    public static void main(String[] args) {
        int v = 4;

        int[][] graph = new int[v][v];

        createGraph(graph);

    }
}
