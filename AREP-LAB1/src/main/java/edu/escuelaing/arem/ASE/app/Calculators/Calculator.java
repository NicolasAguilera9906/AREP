package edu.escuelaing.arem.ASE.app.Calculators;

import edu.escuelaing.arem.ASE.app.MyCustomLinkedListPackage.MyCustomLinkedList;

/**
 * Interface that represents the calculations done on my Linked List
 */
public interface Calculator {
    /**
     * Compute a operation on my custom Linked list
     *
     * @param myCustomLinkedList The Linked List that is going to be computed
     * @return The result of an computing on my custom Linked List
     */
    Double getCalculation(MyCustomLinkedList<Double> myCustomLinkedList);
}