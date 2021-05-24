package edu.escuelaing.arem.ASE.app.Calculators;

import edu.escuelaing.arem.ASE.app.MyCustomLinkedListPackage.MyCustomLinkedList;

/**
 * Class that computes the Standard Desviation of a set of numbers on a Linked List
 */
public class StandardDesviationCalculator implements Calculator {

    private final MeanCalculator meanCalculator = new MeanCalculator();

    /**
     * Computes the Standard Desviation of a set of numbers on a Linked List
     * @param myCustomLinkedList Linked List to be computed
     * @return the Standard Desviation computed
     */
    @Override
    public Double getCalculation(MyCustomLinkedList<Double> myCustomLinkedList) {
        double mean = meanCalculator.getCalculation(myCustomLinkedList);
        double totalAmount = 0.0;
        double variable;
        for (int i=0;i<myCustomLinkedList.getCurrentSize();i++){
            variable=myCustomLinkedList.listIterator(i).next()-mean;
            totalAmount = totalAmount+(variable*variable);
        }
        double answer = Math.sqrt(totalAmount/(myCustomLinkedList.getCurrentSize()-1));
        return (double)Math.round(answer * 100d) / 100d;
    }
}
