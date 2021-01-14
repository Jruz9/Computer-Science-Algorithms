package practiceFolder.SearchingAlgorithmsPractice;

//this is a an simple
public class SequentialSearchPractice<Key,Value> {
    private Node first;

    private class Node{
        Key key;
        Value value;
        Node next;

        //this is a Constructor for referencing inside the private class for classes
        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }
    public void put(Key key,Value value){

        // the arguments inside for loop simply mean that
        // this searches for keys and updates value if found; grows table if new.
        // In the for loop argument, it basically saying that if the node is full to the next one till be have a empty node and then stops
        // currentNode is a representation of the the next node in the tree, think of it like when we have i in a for loop and i++ for the next number.
        for(Node currentNode=first; currentNode !=null;currentNode=currentNode.next)
        {
            //here we go inside the current node and see if the key is equal to the key we gave and if it is update the value in it.
            if(key.equals(currentNode.key))
            {
                currentNode.value=value;    //updates the value
                return; //unless return but put there b/c of the book and i guess some clarity
            }

        }
        //this basically add a new node the current node when
        first=new Node(key,value,first);    //in my old implementation this was in the for but this don't make sense b/c that would add a new node every time and be a infinite loop.
    }
    public Value get(Key key)
    {
        //for definition check put method it explains this for loop.
        for (Node currentNode=first;currentNode!=null; currentNode=currentNode.next)
        {
            //if currentNode key equals the key given then we get the value in that node back and return.
            if(currentNode.equals(key)){
                return currentNode.value;
            }

        }
        //if there is node with the key we want then we return null;
        return null;
    }

}
