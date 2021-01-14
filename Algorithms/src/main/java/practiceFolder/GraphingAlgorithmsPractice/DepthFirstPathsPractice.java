package practiceFolder.GraphingAlgorithmsPractice;

import Graphs.Graph;

import  java.util.Stack;
public class DepthFirstPathsPractice {
    private boolean[] marked;   //has dfs method been called for this vertex
    private int[] edgeTo;   //Last vertex on known path to this vertex
    private final int source;   //Source is the starting vertex

    //
    public DepthFirstPathsPractice(Graph graph,int source){
        marked=new boolean[graph.v()];  //makes a new boolean vertex in the array
        edgeTo=new int[graph.E()];//this puts the number of edges in the array
        this.source=source; //
        dfs(graph,source);

    }
    private  void  dfs(Graph graph, int vertex){
        marked[vertex]=true;//The boolean in the marked array is set to true
        for (int w: graph.adj(vertex)){ //enhanced for loop that searches for in adjacent lists
            if(!marked[w]){
                edgeTo[w]=vertex;
                dfs(graph,w);
            }
        }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    public Iterable<Integer>pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }
        Stack<Integer>path=new Stack<Integer>();
        for(int x=v; x!=source;x=edgeTo[x]){
            path.push(source);
        }
        path.push(source);
        return path;
    }
}
