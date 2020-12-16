package Graphs;

import java.util.List;

public class Graph {
    private final int numberOfVertices;    //number of vertices
    private int numberOfEdges;
    private List<Integer>[] adjacentLists;
    public Graph(int numberOfVertices){
        this.numberOfVertices=numberOfVertices;
    }
}
