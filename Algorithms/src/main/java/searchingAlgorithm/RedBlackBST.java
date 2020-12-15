package searchingAlgorithm;

//red blacks are implmentions of balanced search trees.
public class RedBlackBST <Key extends Comparable<Key>,Value>{
    private Node root;

    private static final boolean RED=true;
    private static final boolean BLACK= false;
    private class Node{
        Key key;
        Value val;
        Node leftNode,rightNode;
        int numberOfNode;
        boolean color;
        Node(Key key,Value val,int numberOfNode,boolean color)
        {
            this.key=key;
            this.val=val;
            this.numberOfNode=numberOfNode;
            this.color=color;
        }

    }
    private boolean isRed(Node x){
        if(x==null){
            return false;
        }
        return  x.color=true;
    }

    private int size(Node x){
        if(x==null){
            return 0;
        }
        else {
            return x.numberOfNode;
        }
    }

    private Node rotateLeft(Node h){
        Node x =h.rightNode;
        h.rightNode=x.leftNode;
        x.leftNode=h;
        x.color=h.color;
        h.color=RED;
        x.numberOfNode=h.numberOfNode;
        h.numberOfNode=1+size(h.leftNode)+size(h.rightNode);
        return x;
    }
    private Node rotateRight(Node h){
        Node x =h.leftNode;
        h.leftNode=x.rightNode;
        x.rightNode=h;
        x.color=h.color;
        h.color=RED;
        x.numberOfNode=h.numberOfNode;
        h.numberOfNode=1+size(h.leftNode)+size(h.rightNode);
        return x;
    }
    private void flippedColors(Node h){

    }
    private Node put(Node h, Key key,Value val){
        if (h == null) {
            return new Node(key,val,1,RED);
        }
        int cmp=key.compareTo(h.key);

        if(cmp<0){
            h.leftNode=put(h.leftNode,key,val);
        }
        else if (cmp>0){
            h.rightNode=put(h.rightNode,key,val);
        }
        else {
            h.val=val;
        }

        //study this part to know what is really doing on the flipping and assigning colors part of the algo.
        if (isRed(h.rightNode) && !isRed(h.leftNode)){
            h=rotateLeft(h);
        }
        if (isRed(h.leftNode) && isRed(h.leftNode.leftNode)){
            h=rotateRight(h);
        }
        if(isRed(h.leftNode) && isRed(h.rightNode)){
            flippedColors(h);
        }
        h.numberOfNode=size(h.leftNode)+size(h.rightNode)+1;
        return h;
    }



}
