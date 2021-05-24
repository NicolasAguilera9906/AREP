package edu.escuelaing.arem.ASE.app.Services;


import edu.escuelaing.arem.ASE.app.MyCustomLinkedListPackage.MyCustomLinkedList;

/**
 * Service that allows computing mean and standard desviation on a LinkedList
 */
public interface ComputingService {

    /**
     * Computes the Standard Desviation of a set of numbers on a Linked List
     * @param myCustomLinkedList Linked List to be computed
     * @return the Standard Desviation computed
     */
    Double computeStandardDesviation(MyCustomLinkedList<Double> myCustomLinkedList);

    /**
     * Computes the mean of a set of numbers on a Linked List
     * @param myCustomLinkedList Linked List to be computed
     * @return the mean computed
     */
    Double computeMean(MyCustomLinkedList<Double> myCustomLinkedList);
}