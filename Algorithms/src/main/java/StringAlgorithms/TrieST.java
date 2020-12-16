package StringAlgorithms;

public class TrieST<Value> {
    private final static int RADIX=256; //radix
    private Node root=new Node();

    private static class Node{
        private Object val;
        private Node[] next= new Node[RADIX];
    }
    public Value get(String key){
        Node x = get(root,key,0);
        if(x==null){
            return null;
        }
        return (Value) x.val;
    }
    private Node get(Node x, String key, int d)
    {
        if(x==null){
            return null;
        }
        if (d==key.length()){
            return  x;
        }
        char c= key.charAt(d);
        return get(x.next[c],key,d+1);
    }
    public void put (String key, Value value){
        root=put(root,key,value,0);
    }
    private Node put(Node x,String key,Value value,int d)
    {
        if(x==null){
            return null;
        }
        if(d==key.length())
        {
            x.val=value;
            return x;
        }
        char c= key.charAt(d);
        x.next[c]=put(x.next[c],key,value,d+1);
        return x;
    }
    //the rest of the classes are methods to perform actions like searching and deleting and other cool operations.
}
