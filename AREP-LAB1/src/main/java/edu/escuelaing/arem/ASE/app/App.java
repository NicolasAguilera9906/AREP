package edu.escuelaing.arem.ASE.app;


import edu.escuelaing.arem.ASE.app.MyCustomLinkedListPackage.MyCustomLinkedList;
import edu.escuelaing.arem.ASE.app.Services.ComputingService;
import edu.escuelaing.arem.ASE.app.Services.ComputingServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


/**
 * App Class
 * @author Nicolas Aguilera Contreras
 */
public class App
{
    /**
     * Main Function For The App
     *
     * @param args List of the arguments needed for run the program.
     */
    public static void main(String[] args)
    {
        MyCustomLinkedList<Double> myCustomLinkedList = null;
        MyCustomLinkedList<Double> myCustomLinkedList2 = null;
        try {
            myCustomLinkedList = getLinkedList("resources\\examples.txt");
            myCustomLinkedList2 = getLinkedList("resources\\examples2.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        ComputingService computingService = new ComputingServiceImpl();
        double mean = computingService.computeMean(myCustomLinkedList);
        double standarDesviation = computingService.computeStandardDesviation(myCustomLinkedList);
        System.out.println("Standard Deviation of examples.txt: " + standarDesviation);
        System.out.println("Mean of examples.txt: " + mean);

        double mean2 = computingService.computeMean(myCustomLinkedList2);
        double standarDesviation2 = computingService.computeStandardDesviation(myCustomLinkedList2);
        System.out.println("Standard Deviation of examples2.txt: " + standarDesviation2);
        System.out.println("Mean of examples2.txt: " + mean2);
    }


    /**
     * Method that reads the numbers of a file and convert them into a Linked List
     * @param filePath the path in which is located the file
     * @return a custom Linked List with the numbers of the file
     * @throws Exception if exists an error reading the numbers of the file
     */
    public static MyCustomLinkedList<Double> getLinkedList(String filePath) throws Exception {
        MyCustomLinkedList<Double> myCustomLinkedList = new MyCustomLinkedList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)));
        double value;
        String line = bufferedReader.readLine();
        while( line != null){
            value = Double.parseDouble(line);
            myCustomLinkedList.addFirst(value);
            line = bufferedReader.readLine();
        }
        return myCustomLinkedList;
    }

}