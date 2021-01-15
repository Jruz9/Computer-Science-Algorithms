package practiceFolder.GraphingAlgorithmsPractice;

import Graphs.Graph;
import fundamentals.Queue;

import java.util.Stack;
///change the variable and give explanations for every part of the algorithm.
public class breadthFirstPathsPractice {
    private boolean[] marked;   //Is a shortest path to this vertex known
    private int[] edgeTo;       // Last vertex on known path to this vertex
    private final int vertexToFind; //source

    public breadthFirstPathsPractice(Graph graph, int vertexToFind){
        marked =new boolean[graph.v()]; //
        edgeTo= new int[graph.v()];
        this.vertexToFind=vertexToFind;
        bfs(graph,vertexToFind);
    }
    private void bfs(Graph graph,int vertexToFind){
        Queue<Integer> queue=new Queue<Integer>();  //Queue is a First in first out
        marked[vertexToFind]=true;      //Marks the source
        queue.enqueue(vertexToFind);   //and puts it onto the queue
        while (!queue.isEmpty()){
            int v=queue.dequeue();      //remove the next vertex from the queue (removes the first number in line)
            for(int vertexLocation: graph.adj(vertexToFind)){    // Looks for adjacentLists in the graph
                if(!marked[vertexLocation]){    //for every unmarked adjacent vertex
                    edgeTo[vertexLocation]=v;   // mark it because path is known
                    marked[vertexLocation]=true;    //and add it to the queue
                    queue.enqueue(vertexLocation);
                }
            }
        }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer>pathTo(int vertex){
        if (!hasPathTo(vertex)){
            return null;
        }

        Stack<Integer> path=new Stack<Integer>();

        for (int x=vertex; x !=vertexToFind; x=edgeTo[x]){
            path.push(x);
        }
        path.push(vertexToFind);
        return path;
    }
}
