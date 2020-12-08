package fundamentals;

import java.util.Iterator;
//this is a example of a fifo queue stack

public class Queue<Item> implements Iterable<Item> {
    public Iterator<Item> iterator() {
        return new listIterator();
    }
    private class  listIterator implements Iterator<Item>
    {
        private  Node current=firstNode;

        public boolean hasNext() {
            return current !=null;
        }
        public void remove()
        {

        }

        public Item next() {
            Item item= current.item;
            current=current.next;
            return item;
        }
    }


    private Node firstNode; //link to least recently added node
    private Node lastNode;  //Link to most recently added node
    private Integer numberOfQueues;      //Number of items on the queue

    private class Node
    {
        //Nested class to define nodes
        Item item;
        Node next;
    }
    public boolean isEmpty()
    {
        return  firstNode==null;
    }
    public int size()
    {
        return numberOfQueues;
    }
    public void enqueue(Item item)
    {
        //add item to the end of the list.
        Node oldLast=lastNode;
        lastNode=new Node();
        lastNode.item=item;
        lastNode.next=null;
        if (isEmpty()) {
            firstNode=null;
        }
    }
    public Item dequeue()
    {
        // Removes item from the beginning of the list
        Item item= firstNode.item;
        firstNode=firstNode.next;
        numberOfQueues--;
        if(isEmpty())
        {
            lastNode=null;
        }
        return item;
    }
}
