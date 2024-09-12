package com.mixer.graphs.storing;

import java.util.LinkedList;
import java.util.List;

public class EdgeList {

    public static void main(String[] args) {

        //mainly used where sorting is needed for edges
        //Minimum Spanning tree

        List<AdjacencyList.Edge> graph = new LinkedList<>();
        graph.add(new AdjacencyList.Edge(0,2,2));

        graph.add(new AdjacencyList.Edge(1,2,10));
        graph.add(new AdjacencyList.Edge(1,3,0));

        graph.add(new AdjacencyList.Edge(2,3,-1));

    }
}
