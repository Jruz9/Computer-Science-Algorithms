package practiceFolder;

public class PracticeQueue<Item>{


    private Node firstNode;
    private Node lastNode;
    private Integer queueSize;

    public class Node{

        Item item;
        Node nextNode;
    }
    public boolean isEmpty(){
        return firstNode==null; //this test if the first is null b/c it sees if the queue even has a node.
    }
    public Integer size(){
        return queueSize;
    }

    public void addNode(Item item)
    {
        Node oldNode=lastNode;
        lastNode=new Node();
        lastNode.item=item;
        lastNode.nextNode=null;
        if(isEmpty()){
            firstNode=null;
        }
        queueSize++;
    }
    public Item removeNode(){
        //removes the first node of the queue this is called a dequeue.
        Item data=firstNode.item;
        firstNode=firstNode.nextNode;
        queueSize--;
        if(isEmpty()){
            lastNode=null;
        }
        return data;
    }

}
