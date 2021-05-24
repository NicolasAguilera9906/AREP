package edu.escuelaing.arem.ASE.app.MyCustomLinkedListPackage;

public class MyCustomNode<E> {

    /**
     * Own Implementation of a Node , helped by : https://www.youtube.com/user/RobEdwardsSDSU
     */
    private MyCustomNode<E> nextNode;
    private E value;

    /**
     * Constructor of My Custom Node
     * @param value Value of the custom node
     */
    public MyCustomNode(E value){
        this.value = value;
        nextNode = null;
    }

    /**
     * Gets the next node of the Linked List in which is located the node
     * @return the next node
     */
    public MyCustomNode getNextNode() {
        return nextNode;
    }

    /**
     * Sets the next node of the Linked List in which is located the node
     * @param nextNode The next node to be setted
     */
    public void setNextNode(MyCustomNode<E> nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * Gets the value of the node
     * @return the value of the node
     */
    public E getValue() {
        return value;
    }

    /**
     * Sets the value of the node
     * @param value the value to be setted
     */
    public void setValue(E value) {
        this.value = value;
    }

    /**
     * Calculates if the Node has a next node in the Linked List in which the node is located
     * @return True if exists a next node on the Linked List
     *         False if doesn't exist a next node on the Linked List
     */
    public boolean hasNext() {
        return getNextNode() != null;
    }
}
