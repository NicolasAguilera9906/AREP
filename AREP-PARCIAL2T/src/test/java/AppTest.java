import co.escuelaing.edu.CalculatorService;
import co.escuelaing.edu.CalculatorServicesImpl;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test for simple Spark Web App.
 */
public class AppTest extends TestCase {


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
     * Tests if the calculator service calculates the Logarithm of a number
     */
    public void testShouldCalculateLogarithmOfANumber() {
        CalculatorService calculatorService = new CalculatorServicesImpl();
        Double value = calculatorService.calculateTheLogarithm((double) 17);
        Double value2 = calculatorService.calculateTheLogarithm((double) 10);
        assertEquals(1.2304489213782739,value);
        assertEquals(1.0,value2);

    }

    /**
     * Tests if the Calculator service raises the euler number to another number
     */
    public void testShouldRaiseEulerNumber() {
        CalculatorService calculatorService = new CalculatorServicesImpl();
        Double value = calculatorService.raiseEulerToAPower((double) 6);
        Double value2 = calculatorService.raiseEulerToAPower((double) 0);
        assertEquals(403.428793492735,value);
        assertEquals(1.0,value2);
    }

}