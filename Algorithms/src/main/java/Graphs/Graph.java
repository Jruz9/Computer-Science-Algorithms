package Graphs;

import fundamentals.Bag;
import java.io.DataInputStream;
import java.io.IOException;
public class Graph {
    private final int  numberOfVertices;    //number of vertices
    private int numberOfEdges;
    private Bag<Integer>[] adjacentLists;
    public Graph(int  numberOfVertices){
        this.numberOfVertices=numberOfVertices;
        adjacentLists=(Bag<Integer>[]) new Bag[numberOfVertices];
        for(int vertices=0;vertices<numberOfVertices;vertices++){
            adjacentLists[vertices]=new Bag<Integer>();// creates a list for each part of the bag adt

        }
    }
    public Graph(DataInputStream in) throws IOException {
        this(in.readInt());
        int E= in.readInt();
        for (int i =0;i<E;i++){
            int v= in.readInt();
            int w= in.readInt();
            addEdge(v,w);

        }


    }
    public int v(){
        return numberOfVertices;
    }
    public int E(){
        return numberOfEdges;
    }
    public void  addEdge(int v, int w){
        adjacentLists[v].add(w);
        adjacentLists[w].add(w);
        numberOfEdges++;
    }
    public  Iterable<Integer> adj(int numberOfVertices){
        return adj(numberOfVertices);
    }
}
