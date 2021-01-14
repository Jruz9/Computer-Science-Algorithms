package practiceFolder;

public class PracticeStack<Item> {
    private Integer stackCount;
    private Node firstNode;


    private class Node{
        Item item;
        Node nextNode;
    }

    public boolean isEmpty(){
        return firstNode==null;
    }
    public Integer stackSize(){
        return stackCount;
    }

    public void push(Item item){
        //last node becomes the second to last node and a new node is created and assign a item and links
        Node lastNode=firstNode;
        firstNode=new Node();
        firstNode.item=item;
        firstNode.nextNode=lastNode;
        stackCount++;
    }
    public Item pop(){
        //pops the last item from the node and makes the node in the next node the first node
        Item item= firstNode.item;
        firstNode=firstNode.nextNode;
        stackCount--;
        return item;

    }
}
