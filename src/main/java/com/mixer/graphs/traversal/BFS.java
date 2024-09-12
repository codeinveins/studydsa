package com.mixer.graphs.traversal;

//go to immediate neighbour first
//indirect level order traversal
//Time complexity  = O(V+E)
import java.util.*;

public class BFS {

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
    private static void createGraph(List<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,3));
        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,4));
        graph[2].add(new Edge(2,0));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

    }

    public static void bfs (int startingPoint, List<Edge> graph[]) {
        if(startingPoint >graph.length || graph[startingPoint].isEmpty()) {
            System.out.println("Starting point not found");
            return;
        }

        Map<Integer, Boolean> visited = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.put(startingPoint, true);
        queue.add(startingPoint);

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + ", ");

            List<Edge> connectedNodes = graph[curr];
            if(null != connectedNodes) {
                for(Edge item : connectedNodes) {
                    if(!visited.containsKey(item.dest)) {
                        visited.put(item.dest, true);
                        queue.add(item.dest);
                    }
                }
            }

        }


    }

    public static void main(String[] args) {
        int v = 7;

        List<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println();

        bfs(3, graph);

    }

}
