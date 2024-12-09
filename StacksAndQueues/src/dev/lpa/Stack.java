package dev.lpa;

public class Stack {

    private Node top;
    private Node bottom;
    private int length;

    public Stack() {
        top = null;
        bottom = null;
        length = 0;
    }

    public String peek(){
        return top.getValue();
    }

    /**
     * Add to the top of the stack and increase length
     * @param value - String to be added
     */
    public void push(String value){

        Node newNode = new Node(value);

        if(length == 0){
            top = bottom = newNode;
            length = 1;
            return;
        }
        // Set next to the current top
        // Make new node the new top
        newNode.setNext(top);
        top = newNode;
        length++;
    }

    /**
     * Remove the top node from the stack
     * LIFO
     * @return the value from the popped node
     */
    public String pop(){
        // Exit case, if stack is empty
        if(length == 0){
            return "Stack is empty. Nothing left to remove";
        } else if (length == 1) {
            Node poppedNode = top;
            top = null;
            bottom = null;
            length--;
            return poppedNode.getValue();
        } else {
            Node poppedNode = top;
            top = poppedNode.getNext();
            length--;
            return poppedNode.getValue();
        }
    }

    public int getLength() {
        return length;
    }


    @Override
    public String toString() {
        if(length == 0){
            return "Stack is empty";
        }
        return "Stack{" +
                "top=" + top.getValue() +
                ", bottom=" + bottom.getValue() +
                ", length=" + length +
                '}';
    }
}
