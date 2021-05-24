
import APIConsumers.ApiConsumer;
import APIConsumers.ApiConsumerException;
import APIConsumers.ApiConsumerImpl;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.json.simple.parser.ParseException;

/**
 * Unit test for WeatherApp
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

    public void testShouldFindWeather() {
        ApiConsumer apiConsumer = new ApiConsumerImpl();
        try {
            String weather = apiConsumer.getWeatherByCity("Bogotá");
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(weather);
            assertEquals(json.get("name"),"Bogotá");
        } catch (ApiConsumerException e) {
            assertTrue(false);
        } catch (ParseException e) {
            assertTrue(false);
        }
    }

    public void testShouldNotFindWeather() {
        ApiConsumer apiConsumer = new ApiConsumerImpl();
        try {
            String weather = apiConsumer.getWeatherByCity("kfjdshfkhsjdfhksd");
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(weather);
            assertTrue(false);
        } catch (ApiConsumerException e) {
            assertTrue(true);
        } catch (ParseException e) {
            assertTrue(false);
        }
    }
}