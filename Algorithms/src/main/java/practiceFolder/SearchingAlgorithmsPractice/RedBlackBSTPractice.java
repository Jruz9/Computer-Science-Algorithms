package practiceFolder.SearchingAlgorithmsPractice;

//this is a balanced tree algorithm with using the red black
// binary tree implementation.
public class RedBlackBSTPractice<Key extends Comparable<Key>,Value> {
    private Node root;
    private final static boolean RED=true;
    private final static boolean BLACK=false;

    private class Node{
        private Key key;
        private Value value;
        Node leftNode;
        Node rightNode;
        int numberOfNodes;
        boolean colorOfNode;

        public Node(Key key, Value value, int numberOfNodes, boolean colorOfNode) {
            this.key = key;
            this.value = value;
            this.numberOfNodes = numberOfNodes;
            this.colorOfNode = colorOfNode;
        }

    }
    //checks if the node is red and if it is true.
    private boolean isRed(Node node){
        if(node==null){
            return false;
        }
        return node.colorOfNode=true;

    }
    private Integer sizeOfTree(Node node){
        if(node==null){
            return null;
        }
        return node.numberOfNodes;
    }
    //rotates the right node color of red to the left
    private Node rotateLeft(Node node){
        Node exchangeNode=node.rightNode;   //copy node is now the right node
        //rotation happens in these 2 lines
        node.rightNode=node.leftNode;   //makes the right node the left node
        exchangeNode.leftNode=node; //make the copy node left node equal to the node supplied b/c its rotating left

        //
        exchangeNode.colorOfNode=node.colorOfNode;  //makes the copy node color equal to the supplied node color
        node.colorOfNode=RED;//turns  the supplied node color
        exchangeNode.numberOfNodes=node.numberOfNodes;  //makes the copy node  number of nodes equal the number of nodes from the supplied node
        node.numberOfNodes=1+sizeOfTree(node.leftNode)+sizeOfTree(node.rightNode); //get the size of the tree from the left and right nodes
        return exchangeNode;    //returns the copy node.
    }
    //rotates the left node color of red to the right
    private Node rotateRight(Node node){
        Node realNode=node.leftNode;
        node.leftNode=realNode.rightNode;
        realNode.rightNode=node;
        realNode.colorOfNode=node.colorOfNode;
        node.colorOfNode=RED;
        realNode.numberOfNodes=node.numberOfNodes;
        node.numberOfNodes=1+sizeOfTree(node.leftNode)+sizeOfTree(node.rightNode);
        return realNode;
    }

    //this method flips the color of the children and parent from black to red and children vice versa
    private void flipColors(Node node){
        node.colorOfNode=RED;
        node.leftNode.colorOfNode=BLACK;
        node.rightNode.colorOfNode=BLACK;
    }

    private Node put(Node node,Key key,Value value){

        //if no node exist this will create a new node
        if(node==null){
            return new Node(key,value,1,RED);
        }
        //compares the node and recurssively goes through the tree to till there is a match
        int compareTo= key.compareTo(node.key);
        if(compareTo<0){
            node.leftNode=put(node.leftNode,key,value);
        }
        else if(compareTo>0){
            node.rightNode=put(node.rightNode,key,value);

        }
        else {
            node.value=value;
        }



        //here, the if statement are changing the right red to left
        //If you see, the right is red and left id not red
        //so this will make the left red
        if(isRed(node.rightNode) && !isRed(node.leftNode)){
            node=rotateLeft(node);
        }

        //Here it is rotating the node to be right
        //it checks if the left node is red and if the other left nodes are also red  blacks lean left to be red
        if (isRed(node.leftNode)&& isRed(node.leftNode.leftNode)){
            node=rotateRight(node);
        }
        //If both the left node and right node are red then it will flip the colors,
        //it will make the left and right node black and the main node red.
        if (isRed(node.leftNode)&& isRed(node.rightNode)){
            flipColors(node);
        }

        //get the binary tree size.
        node.numberOfNodes=sizeOfTree(node.leftNode)+sizeOfTree(node.rightNode)+1;
        return node;// return the node supplied with the changes

    }
}
