package fundamentals;
//This is a push down stack implementation of a linked list implementation
public class stack<Item> {
    //this uses a generic data type to store the linked list and define them
    // good to know btw.


    /*
    An example of how the stack will work for a user perpective

    -they make a new node
    -user fills in the item data type
    -user creates a new node with a item and links it to the last node created
    -
     */

    private Node first;
    private Integer numberOfItem;

    private class Node{
        //nested class to define nodes
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public int size()
    {
        return numberOfItem;
    }

    public void push(Item item)
    {
        //Add item from top of stack.
        Node oldFirst =first;
        first=new Node();   //new node
        first.item=item;    //the new node gets the item from
        first.next= oldFirst;   //The last node will be linked to the first node
        numberOfItem++;
    }
    public Item pop()
    {
        //removes item from top of stack.
        Item item=first.item;
        first=first.next;
        numberOfItem--;
        return item;
    }
}

