package edu.escuelaing.arem.ASE.app.MyCustomLinkedListPackage;

import java.util.Iterator;

/**
 * Own Implementation of a Linked List Iterator , helped by https://dzone.com/articles/creating-a-custom-linked-list-implementation
 * @param <E> The Element Type of the Collection.
 */
public class MyCustomLinkedListIterator<E> implements Iterator<E> {
    MyCustomNode<E> current;

    /**
     * Constructor of The Linked List Iterator
     * @param myCustomLinkedList The linked list to be iterated
     */
    public MyCustomLinkedListIterator(MyCustomLinkedList<E> myCustomLinkedList) {
        current = (MyCustomNode<E>) myCustomLinkedList.getFirst();
    }

    /**
     * Determinates if exists another Node in the Linked List
     * @return True if exists another element in the Linked List
     *         False if doesn't exist another element in the Linked List
     */
    @Override
    public boolean hasNext() {
        return current!=null;
    }

    /**
     * Calculates the next value of the next node on the Linked List
     * @return The next value on the Linked List
     */
    @Override
    public E next() {
        E value = current.getValue();
        current = current.getNextNode();
        return value;
    }
}
