package co.escuelaing.edu;


import spark.Request;
import spark.Response;

import java.text.SimpleDateFormat;
import java.util.Date;

import static spark.Spark.*;

/**
 * Spark Web App que ofrece el endpoint del servicio
 */
public class SparkWebApp {

    /**
     * Main class
     * @param args arguments needed by the class to run
     */
    public static void main(String[] args) {
        port(getPort());
        secure("keyscerts/timeservice.p12", "123456","keyscerts/myTrustStore","123456");
        get("/service", SparkWebApp::getHour);

    }

    /**
     * Gets the actual hour
     * @param request request made to the server
     * @param response response made by the server
     * @return
     */
    private static Object getHour(Request request, Response response) {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    /**
     * retorna el puerto del ambiente, sino se encuentra retorna el puerto 5002
     * @return un entero especificando el puerto
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5001;
    }
}