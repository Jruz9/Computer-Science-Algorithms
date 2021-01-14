package practiceFolder.SearchingAlgorithmsPractice;


public class BinarySearchTreePractice<Key extends Comparable,Value> {
    private Node tree;
    private class Node{
        private  Key key;
        private Value value;
        private Node leftNode;  //this links the other nodes we can transverse through them like a stack
        private Node rightNode;
        private int numberOfNodes;

        //allows us to use the class and it's repective variables while keeping things private and protected.
        public Node(Key key, Value value, int numberOfNodes) {
            this.key = key;
            this.value = value;
            this.numberOfNodes = numberOfNodes;
        }

    }

    //this returns the size of the binary tree.
    //the reason why we choose to use tree is because numberOfNodes gives us the the total number of nodes in the tree. per each side.
    public Integer size(){
        return  sizeOfTree(tree);
    }
    private Integer sizeOfTree(Node tree){
        if(tree==null){
            return null;
        }
        else{
            return tree.numberOfNodes;
        }
    }
    //this method returns the value by using the tree and key using another method to do this work
    public Value get(Key key){
        return getValue(tree,key);
    }

    //this is a recursive method that essentially uses compares your key and the tree key
    // and if theres no matches it will recursively go down the tree to find a key that does
    //and return the value from the tree key location.
    private Value getValue(Node node,Key key)
    {
        if(node==null){
            return null;
        }
        int compareTo= key.compareTo(node.key);
        if(compareTo<0){
            return getValue(node.leftNode,key);
        }
        else if(compareTo>0){
            return getValue(node.rightNode,key);
        }
        else{
            return node.value;
        }
    }

    //put the value using the tree and the key to find the location
    public void put(Key key,Value value)
    {
        tree= putValue(tree,key,value);
    }

    //this is a recurssive algorithms that compares the key with the key in the tree.
    //It recurssively goes through the tree till the comparision equals zero
    //and then the value will be inserted into the tree
    // then the tree will update the size of the tree calulating the left and right part of the tree.
    //then we return the tree with the changes we made to put the values in.
    private Node putValue(Node tree,Key key,Value value){
        //when we find a null link (usually at the bottom of a tree or
        if(tree==null){
            return new Node(key,value,1);
        }
        int compareTo= key.compareTo(tree.key);
        //In this if statement we are also inserting and linking the left and right node for each node(
        if (compareTo<0){
            tree.leftNode=putValue(tree.leftNode,key,value);
        }
        else if(compareTo>0){
            tree.rightNode=putValue(tree.rightNode,key,value);
        }
        else {
            tree.value=value;
        }

        //this is allow be updated recursively kinda triply.
        tree.numberOfNodes=sizeOfTree(tree.leftNode)+sizeOfTree(tree.rightNode)+1;
        return tree;
    }

    //will add more parts to the algorithm later.

}
