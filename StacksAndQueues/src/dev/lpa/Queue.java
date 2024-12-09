package dev.lpa;

public class Queue {
    private Node first;
    private Node last;
    private int length;

    public Queue() {
        first = null;
        last = null;
        length = 0;
    }

    /**
     * See the first item in the queue
     * @return - String
     */
    public String peek(){
        if(length == 0){
            return "Queue is empty";
        }

        return first.getValue();
    }

    public void enqueue(String value){
        Node newNode = new Node(value);

        if(length == 0){
            first = last = newNode;
        } else{
            last.setNext(newNode);
            last = newNode;
        }
        length++;
    }

    /**
     * Remove first item from queue
     * @return - String, value of the node
     */
    public String dequeue(){
        if(length == 0){
            return "Queue is empty";
        } else{
            Node holderNode = first;
            first = holderNode.getNext();
            holderNode.setNext(null);
            length--;
            return holderNode.getValue();
        }
    }

    @Override
    public String toString() {
        if(length == 0){
            return "Queue is empty";
        }
        return "Queue{" +
                "first=" + first.getValue() +
                ", last=" + last.getValue() +
                ", length=" + length +
                '}';
    }
}
