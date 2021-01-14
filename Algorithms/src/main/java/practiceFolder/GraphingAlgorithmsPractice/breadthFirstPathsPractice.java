package practiceFolder.GraphingAlgorithmsPractice;

import Graphs.Graph;
import fundamentals.Queue;

import java.util.Stack;
///change the variable and give explainations for every part of the algorithm.
public class breadthFirstPathsPractice {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public breadthFirstPathsPractice(Graph graph, int s){
        marked =new boolean[graph.v()];
        edgeTo= new int[graph.v()];
        this.s=s;
        bfs(graph,s);
    }
    private void bfs(Graph G,int s){
        Queue<Integer> queue=new Queue<Integer>();
        marked[s]=true;
        queue.enqueue(s);
        while (!queue.isEmpty()){
            int v=queue.dequeue();
            for(int w: G.adj(v)){
                if(!marked[w]){
                    edgeTo[w]=v;
                    marked[w]=true;
                    queue.enqueue(w);
                }
            }
        }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    public Iterable<Integer>pathTo(int v){
        if (!hasPathTo(v)){
            return null;
        }

        Stack<Integer> path=new Stack<Integer>();

        for (int x=v; x !=s; x=edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
