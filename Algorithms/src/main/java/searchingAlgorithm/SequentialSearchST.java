package searchingAlgorithm;

public class SequentialSearchST<Key,Value> {
    private Node first;

    private class Node{
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next)
        {
            this.key=key;
            this.val=val;
            this.next=next;
        }
    }

    
}
