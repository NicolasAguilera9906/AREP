package edu.escuelaing.arem.ASE.app.MyCustomLinkedListPackage;

import java.io.Serializable;
import java.util.*;

/**
 * Own Implementation of a Linked List , helped by https://www.youtube.com/user/RobEdwardsSDSU
 *
 * @param <E> The Element Type of the Collection.
 */
public class MyCustomLinkedList<E> extends AbstractSequentialList<E>
        implements List<E>, Deque<E>, Cloneable, Serializable {

    private MyCustomNode<E> head;
    private MyCustomNode<E> tail;
    private int currentSize;

    /**
     * Constructor for my custom Linked List.
     */
    public MyCustomLinkedList() {
        this.head = null;
        this.tail = null;
        this.currentSize = 0;
    }

    /**
     * Add a Node on the head of the Linked List
     * @param obj Value of the node to be added
     */
    @Override
    public void addFirst(E obj) {
        MyCustomNode<E> node = new MyCustomNode<E>(obj);
        node.setNextNode(head);
        head = node;
        currentSize++;
    }

    /**
     * Add a Node on the tail of the Linked List
     * @param obj Value of the node to be added
     */
    @Override
    public void addLast(E obj) {
        MyCustomNode<E> node = new MyCustomNode<>(obj);
        if(head==null){
            head=node;
            tail = node;
            currentSize++;
            return;
        }

        MyCustomNode<E> tmp = head;
        while(tmp.getNextNode()!=null){
            tmp = tmp.getNextNode();
        }
        tmp.setNextNode(node);
        tail = node;
        currentSize++;
    }

    /**
     * Remove the head of the Linked List
     * @return The Value of the node that is going to be eliminated
     */
    @Override
    public E removeFirst() {
        if (head == null) {
            return null;
        }
        E headValue = head.getValue();
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.getNextNode();
        }
        currentSize--;
        return headValue;
    }

    /**
     * Remove the tail of the Linked List
     * @return The Value of the node that is going to be eliminated
     */
    @Override
    public E removeLast() {
        if(head==null){
            return null;
        }
        if(head==tail){
            return removeFirst();
        }
        MyCustomNode<E> current = head;
        MyCustomNode<E> previous = null;

        while(current!=tail){
            previous = current;
            current = current.getNextNode();
        }
        previous.setNextNode(null);
        tail=previous;
        currentSize--;
        return current.getValue();
    }

    /**
     * Get the head of the linked list
     * @return Value of the head of the linked list
     */
    @Override
    public E getFirst() {
        return head.getValue();
    }

    /**
     * Get the tail of the linked list
     * @return Value of the tail of the linked list
     */
    @Override
    public E getLast() {
        return tail.getValue();
    }

    /**
     * Peek the head of the linked list
     * @return Value of the head of the linked list
     */
    @Override
    public E peekFirst() {
        if(head==null) {
            return null;
        }
        return head.getValue();
    }

    /**
     * Peek the tail of the linked list
     * @return Value of the tail of the linked list
     */
    @Override
    public E peekLast() {
        if(tail==null){
            return null;
        }
        return tail.getValue();
    }

    /**
     * Get the current size of the Linked List
     * @return The current size of the Linked List
     */
    public int getCurrentSize() {
        return currentSize;
    }

    /**
     * Generate a list iterator of the custom Linked List.
     *
     * @param index The index to iterate into the Linked List
     * @return the list iterator of my custom Linked List
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        return new ListIterator<E>() {
            final MyCustomNode<E> first = head;
            @Override
            public boolean hasNext() {
                return first.hasNext();
            }
            @Override
            public E next() {
                if (!first.hasNext()) {
                    throw new NoSuchElementException();
                }
                MyCustomNode<E> current = first;
                int counterIndex = 0;
                while (current.hasNext()) {
                    if (counterIndex == index) {
                        break;
                    }
                    current = current.getNextNode();
                    counterIndex++;
                }
                E value = current.getValue();
                return value;
            }

            @Override
            public E previous() {
                return null;
            }
            @Override
            public int nextIndex() {
                return index + 1;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove(){}

            @Override
            public void set(E e){}

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public void add(E e) {
                addLast(e);
            }
        };
    }


    @Override
    public E remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean offerFirst(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean offerLast(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E pollLast() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean offer(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E poll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E element() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E peek() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void push(E e) {
        throw new UnsupportedOperationException();
    }
    @Override
    public E pop() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<E> descendingIterator() {
        throw new UnsupportedOperationException();
    }

}
