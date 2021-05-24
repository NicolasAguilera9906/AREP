package co.escuelaing.edu;

import org.json.simple.JSONObject;
import spark.Request;
import spark.Response;
import static spark.Spark.*;


/**
 * Class that makes a SparkWebServer
 */
public class SparkWebServer {


    private static TemperatureService temperatureService = new TemperatureServiceImpl();

    /**
     * Main class of the application
     * @param args arguments needed to execute de app
     */
    public static void main(String ... args){
        port(getPort());
        get("/hello", (req,res) -> "Hello to the Spark Web Server!" );
        get("/celcius",SparkWebServer::getFahrenheitConvertedToCelsius);

    }

    /**
     * Get Fahrenheit degrees converted to Celcius
     * @param request request made to the server
     * @param response response made by the server
     * @return Fahrenheit degrees converted to Celcius
     */
    private static Object getFahrenheitConvertedToCelsius(Request request, Response response) {
        Double value = Double.valueOf(request.queryParams("value"));
        JSONObject myObject = new JSONObject();
        myObject.put("operation", "Fahrenheit degrees converted to Celsius");
        myObject.put("input", value);
        myObject.put("output", temperatureService.convertFahrenheitToCelsius(value));
        return myObject;
    }

    /**
     * Gets a port on which the Server will run
     * @return the port on which the Server will run
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }
}