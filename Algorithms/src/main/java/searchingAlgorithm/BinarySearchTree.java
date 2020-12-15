package searchingAlgorithm;

public class BinarySearchTree <Key extends  Comparable<Key>,Value>{
    private Node root;
    private class Node{
        private Key key;
        private Value val;
        private Node leftNode;
        private Node rightNode;
        private Integer numberOfNodes;

        public  Node(Key key,Value val, Integer numberOfNodes){
            this.key=key;
            this.val=val;
            this.numberOfNodes=numberOfNodes;
        }

    }

    public int size(){
        return sizeOfTree(root);
    }
    private int sizeOfTree(Node x)
    {
        if(x==null){
            return 0;
        }
        else{
            return x.numberOfNodes;
        }

    }

    public Value get (Key key){
      return get(root,key);
    }
    private Value get(Node x, Key key){
        if(x==null){
            return null;
        }
        int cmp= key.compareTo(x.key);
        if (cmp<0){
            return  get(x.leftNode,key);
        }
        else if (cmp>0){
            return get(x.rightNode,key);
        }
        else {
            return x.val;
        }
    }

    public void put(Key key,Value val){
        root=put(root,key,val);
    }


    private Node put(Node x,Key key,Value value){

        if(x==null){
            return new Node(key,value,1);
        }
        int cmp=key.compareTo(x.key);
        if(cmp<0){
            x.leftNode=put(x.leftNode,key,value);
        }
        else if(cmp>0){
            x.rightNode=put(x.rightNode,key,value);
        }
        else {
            x.val=value;
        }
        x.numberOfNodes=sizeOfTree(x.leftNode)+sizeOfTree(x.rightNode)+1;
        return x;
    }
    //there are other methods the perform additional functions. They are not added for the sake of time
    //but are on the book and are simple to implement and hack around with little time. soorry :)
}
