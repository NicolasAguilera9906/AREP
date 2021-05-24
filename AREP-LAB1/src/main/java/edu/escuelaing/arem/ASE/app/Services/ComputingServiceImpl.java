package edu.escuelaing.arem.ASE.app.Services;

import edu.escuelaing.arem.ASE.app.MyCustomLinkedListPackage.MyCustomLinkedList;
import edu.escuelaing.arem.ASE.app.Calculators.Calculator;
import edu.escuelaing.arem.ASE.app.Calculators.MeanCalculator;
import edu.escuelaing.arem.ASE.app.Calculators.StandardDesviationCalculator;


/**
 * Service that implements the computation of mean and standard desviation on a LinkedList
 */
public class ComputingServiceImpl implements ComputingService {

    private Calculator calculator;

    /**
     * Computes the mean of a set of numbers on a Linked List
     * @param myCustomLinkedList Linked List to be computed
     * @return the mean computed
     */
    @Override
    public Double computeMean(MyCustomLinkedList<Double> myCustomLinkedList) {
        calculator = new MeanCalculator();
        return calculator.getCalculation(myCustomLinkedList);
    }

    /**
     * Computes the Standard Desviation of a set of numbers on a Linked List
     * @param myCustomLinkedList Linked List to be computed
     * @return the Standard Desviation computed
     */
    @Override
    public Double computeStandardDesviation(MyCustomLinkedList<Double> myCustomLinkedList) {
        calculator = new StandardDesviationCalculator();
        return calculator.getCalculation(myCustomLinkedList);
    }
}