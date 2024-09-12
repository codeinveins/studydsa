package com.mixer.graphs.traversal;

import java.util.*;

public class DFS {

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
    //       ----1------3--
    //      /           |  \
    //   0--            |   5---6
    //      \           |  /
    //       ----2------4--
    //
    //              0
    //          1       2
    //      3               4
    //
    //              5
    //
    //              6
    //
    private static void createGraph(List<BFS.Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new BFS.Edge(0,1));
        graph[0].add(new BFS.Edge(0,2));

        graph[1].add(new BFS.Edge(1,3));
        graph[1].add(new BFS.Edge(1,0));

        graph[2].add(new BFS.Edge(2,4));
        graph[2].add(new BFS.Edge(2,0));

        graph[3].add(new BFS.Edge(3,1));
        graph[3].add(new BFS.Edge(3,4));
        graph[3].add(new BFS.Edge(3,5));

        graph[4].add(new BFS.Edge(4,2));
        graph[4].add(new BFS.Edge(4,3));
        graph[4].add(new BFS.Edge(4,5));

        graph[5].add(new BFS.Edge(5,3));
        graph[5].add(new BFS.Edge(5,4));
        graph[5].add(new BFS.Edge(5,6));

        graph[6].add(new BFS.Edge(6,5));

    }

    static Map<Integer, Boolean> visited = new HashMap<>();
    public static void dfs (int startingPoint, List<BFS.Edge> graph[]) {
        if(startingPoint > graph.length || graph[startingPoint].isEmpty()) {
            System.out.println("Starting point not found");
            return;
        }

        visited.put(startingPoint, true);
        System.out.print(startingPoint + ", ");

        List<BFS.Edge> connectedNodes = graph[startingPoint];
        if(null != connectedNodes) {
            for(BFS.Edge item : connectedNodes) {
                if(!visited.containsKey(item.dest)) {
                   dfs(item.dest, graph);
                }
            }
        }
    }

    public static void main(String[] args) {
        int v = 7;

        List<BFS.Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println();

        dfs(0, graph);

    }
}
