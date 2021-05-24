package edu.escuelaing.arem.ASE.app;

import edu.escuelaing.arem.ASE.app.MyCustomLinkedListPackage.MyCustomLinkedList;
import edu.escuelaing.arem.ASE.app.Services.ComputingService;
import edu.escuelaing.arem.ASE.app.Services.ComputingServiceImpl;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */

    public void testShouldIterate() {
        MyCustomLinkedList<Double> myCustomLinkedList = new MyCustomLinkedList<>();
        double[] values = {17.0, 24.0, 3.0};
        boolean flag = false;
        for (Double value : values) {
            myCustomLinkedList.addFirst(value);
        }
        int cont = 2;
        for(int i=0;i<myCustomLinkedList.getCurrentSize();i++){
            assertTrue(myCustomLinkedList.listIterator(i).next().equals(values[cont]));
            cont--;
        }
    }

    public void testShouldAddFirst() {
        MyCustomLinkedList<Double> myCustomLinkedList = new MyCustomLinkedList<>();
        double[] values = {17.0, 24.0, 3.0};
        boolean flag = false;
        for (Double value : values) {
            myCustomLinkedList.addFirst(value);
        }
        assertTrue(myCustomLinkedList.getFirst().equals(values[2]));
    }

    public void testShouldAddLast() {
        MyCustomLinkedList<Double> myCustomLinkedList = new MyCustomLinkedList<>();
        double[] values = {17.0, 24.0, 3.0};
        boolean flag = false;
        for (Double value : values) {
            myCustomLinkedList.addLast(value);
        }
        assertTrue(myCustomLinkedList.getFirst().equals(values[0]));
    }

    public void testShouldCalculateMeanAndStandardDesviationOfCase1() throws Exception {
        MyCustomLinkedList<Double> myLinkedList = new MyCustomLinkedList<>();
        ComputingService computingService = new ComputingServiceImpl();
        Double[] values ={186.0,699.0,132.0,272.0,291.0,331.0,199.0,1890.0,788.0,1601.0};
        for (Double value:values){
            myLinkedList.addFirst(value);
        }
        double mean=computingService.computeMean(myLinkedList);
        double standard_deviation=computingService.computeStandardDesviation(myLinkedList);
        assertEquals(625.63,standard_deviation);
        assertEquals(638.9,mean);
    }

    public void testShouldCalculateMeanAndStandardDesviationOfCase2() throws Exception {
        MyCustomLinkedList<Double> myLinkedList = new MyCustomLinkedList<>();
        ComputingService computingService = new ComputingServiceImpl();
        Double[] values ={23.6,56.5,43.7,21.4,22.8,76.3,93.9,18.2,328.9,18.1};
        for (Double value:values){
            myLinkedList.addFirst(value);
        }
        double mean=computingService.computeMean(myLinkedList);
        double standard_deviation=computingService.computeStandardDesviation(myLinkedList);
        assertEquals(94.65,standard_deviation);
        assertEquals(70.34,mean);
    }

}
