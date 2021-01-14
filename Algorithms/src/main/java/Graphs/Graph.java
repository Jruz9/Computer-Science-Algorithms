package Graphs;

import fundamentals.Bag;
import java.io.DataInputStream;
import java.io.IOException;
public class Graph {
    private final int  numberOfVertices;    //number of vertices
    private int numberOfEdges;  //number of edges
    private Bag<Integer>[] adjacentLists;   //adjacent list


    ////make the the bag (graph)
    public Graph(int  numberOfVertices){
        this.numberOfVertices=numberOfVertices; //make the private variable link to the one in the argument
        adjacentLists=(Bag<Integer>[]) new Bag[numberOfVertices];   //initializes all lists in the bag
        for(int vertices=0;vertices<numberOfVertices;vertices++){
            adjacentLists[vertices]=new Bag<Integer>();// creates a list for each part of the bag adt

        }
    }
    //this method add vertex and edges to connect each list together in the bag (graph)
    public Graph(DataInputStream inputData) throws IOException {
        this(inputData.readInt()); //Reads number of Vertices (DataStream in) and construct this graph
        int numberOfEdges= inputData.readInt();//numberOfEdges
        for (int i =0;i<numberOfEdges;i++){
            int firstVertex= inputData.readInt();    // firstVertex or location of the the list in the graph
            int secondVertex= inputData.readInt();   // secondVertex or location of the the list in the graph
            addEdge(firstVertex,secondVertex);   //adds the data inputs to the addEdge method and creates an edge between eage node.

        }


    }
    public int v(){
        return numberOfVertices;
    }

    public int E(){
        return numberOfEdges;
    }

    public void  addEdge(int firstVertex, int secondVertex){
        adjacentLists[firstVertex].add(secondVertex);    //connects second vertex to first list
        adjacentLists[secondVertex].add(firstVertex);   //connects first vertex to second list
        numberOfEdges++;    //increase the edges made.
    }
    public  Iterable<Integer> adj(int vertex){
        return adj(vertex);
    }
}
