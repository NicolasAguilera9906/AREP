import co.escuelaing.edu.TemperatureService;
import co.escuelaing.edu.TemperatureServiceImpl;
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
     * Tests if the temperature services converts from Fahrenheit to Celcius
     */
    public void testShouldCalculateLogarithmOfANumber() {
        TemperatureService temperatureService = new TemperatureServiceImpl();
        Double celsius1 = temperatureService.convertFahrenheitToCelsius(50);
        assertEquals(10.0008,celsius1);
        Double celsius2 = temperatureService.convertFahrenheitToCelsius(32);
        assertEquals(0.0,celsius2);
    }
}