package edu.escuelaing.arem.ASE.app.Calculators;

import edu.escuelaing.arem.ASE.app.MyCustomLinkedListPackage.MyCustomLinkedList;

/**
 * Class that computes the mean of a set of numbers on a Linked List
 */
public class MeanCalculator implements Calculator {

    /**
     * Computes the mean of a set of numbers on a Linked List
     * @param linkedList Linked List to be computed
     * @return the mean computed
     */
    public Double getCalculation(MyCustomLinkedList<Double> linkedList) {
        double totalAmount = 0.0;
        for(int i=0;i<linkedList.getCurrentSize();i++){
            totalAmount+=linkedList.listIterator(i).next();
        }
        double answer = (totalAmount / linkedList.getCurrentSize());
        return (double)Math.round(answer * 100d) / 100d;
    }
}
