package Graphs;

import java.util.Stack;

public class DepthFirstPaths {
    private boolean[] marked;
    private  int[] edgeTo;
    private final int s;
    public DepthFirstPaths(Graph graph, int s)
    {
        marked=new boolean[graph.v()];
        edgeTo= new int[graph.E()];
        this.s=s;
        dfs(graph,s);
    }
    private void dfs(Graph g, int v)
    {
        marked[v]=true;
        for (int w: g.adj(v)){
            if ((!marked[w]))
            {
                edgeTo[w]=v;
                dfs(g,w);
            }
        }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    public  Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return  null;
        }
        Stack<Integer> path=new Stack<Integer>();

        for(int x=v;x !=s;x=edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
