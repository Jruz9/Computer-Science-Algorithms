package practiceFolder.GraphingAlgorithmsPractice;

import Graphs.Graph;

import  java.util.Stack;
public class DepthFirstPathsPractice {
    private boolean[] marked;   //has dfs method been called for this vertex
    private int[] edgeTo;   //Last vertex on known path to this vertex
    private final int source;   //Source is the is the vertex your trying to find

    //
    public DepthFirstPathsPractice(Graph graph,int source){
        marked=new boolean[graph.v()];  //makes a new boolean vertex in the array
        edgeTo=new int[graph.E()];//this puts the number of edges in the array
        this.source=source; //the vertex
        dfs(graph,source);  //calls the dfs method to

    }
    //checks if the node and edge have been checked.
    private  void  dfs(Graph graph, int vertex){
        marked[vertex]=true;//The boolean in the marked array is set to true
        for (int vertexLocation: graph.adj(vertex)){ //enhanced for loop that searches for in adjacent lists
            if(!marked[vertexLocation]){ //if dfs has not marked this vertex true.
                edgeTo[vertexLocation]=vertex;  //It adds the vertex and make a edge connectino
                dfs(graph,vertexLocation);  //recursive call that checks vertex to true and checks if vertex is in
            }
        }
    }
    //checks if the vertex is marked and true.
    // This just means that it makes a edge.
    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer>pathTo(int vertex){
        if(!hasPathTo(vertex)){
            return null;
        }
        //makes a stack that searches for the vertex from the source(its the one we are looking for)
        Stack<Integer>path=new Stack<Integer>();
        for(int vertexLocation=vertex; vertexLocation!=source;vertexLocation=edgeTo[vertexLocation]){
            path.push(vertexLocation);
        }
        path.push(source);
        return path;
    }
}
