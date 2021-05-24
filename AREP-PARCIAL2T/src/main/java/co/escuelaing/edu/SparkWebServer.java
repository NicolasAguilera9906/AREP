package co.escuelaing.edu;

import org.json.simple.JSONObject;
import spark.Request;
import spark.Response;
import static spark.Spark.*;


/**
 * Class that makes a SparkWebServer
 */
public class SparkWebServer {


    private static CalculatorService calculatorServices = new CalculatorServicesImpl();

    /**
     * Main class of the application
     * @param args arguments needed to execute de app
     */
    public static void main(String ... args){
        port(getPort());
        get("/hello", (req,res) -> "Hello!" );
        get("/exp", SparkWebServer::getExp);
        get("/log",SparkWebServer::getLog);

    }

    /**
     * Get the logarithm of a number
     * @param request request made to the server
     * @param response response made by the server
     * @return the logarithm of the number
     */
    private static Object getLog(Request request, Response response) {
        Double value = Double.valueOf(request.queryParams("value"));
        JSONObject myObject = new JSONObject();
        myObject.put("operation", "log");
        myObject.put("input", value);
        myObject.put("output", calculatorServices.calculateTheLogarithm(value));
        return myObject;
    }

    /**
     * Gets the Euler number raised to a number
     * @param request request made to the server
     * @param response request made by the server
     * @return the Euler number raised to a value
     */
    private static Object getExp(Request request, Response response) {
        Double value = Double.valueOf(request.queryParams("value"));
        Double rta = calculatorServices.raiseEulerToAPower(value);
        JSONObject myObject = new JSONObject();
        myObject.put("operation", "exp");
        myObject.put("input", value);
        myObject.put("output", calculatorServices.raiseEulerToAPower(value));
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