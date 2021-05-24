package edu.escuelaing.demo;

import edu.escuelaing.database.DataBaseConnector;
import static edu.escuelaing.nanosparkweb.NanoSpark.*;

/**
 * Class that is responsible for starting the nano spark server and printing the response of the requests made to it
 */
public class NanoSparkWebDemo {

    /**
     * Main Function For The WebApp
     *
     * @param args List of the arguments needed for run the program.
     */
    public static void main (String[] args){
        get("/hello",(req,resp) -> {
            if(req.getValues()==""){
                return "Por favor ingresa un valor. Ejemplo : /Apps/hello?value=Nicolas";
            }
            String response = "";
            try {
                response = getResponse(req.getValues());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return response;
        });
        startServer();
    }

    /**
     * Get a random phrase from a firebase database
     * @return a random phrase from a firebase database
     * @throws Exception if exists a connection error with the firebase database
     */
    private static String getRandomSentence() throws Exception {
        DataBaseConnector dataBaseConnector = DataBaseConnector.getInstance();
        int number = (int) (Math.random()*7);
        if(number==0){ number=1; }
        return dataBaseConnector.getRandomSentence(number);
    }

    /**
     * Gets the response of a request to the web server
     * @param values values that the user entered as a parameter
     * @return the html response of a request to the web server
     * @throws Exception If an error occurs obtaining the response
     */
    private static String getResponse(String values) throws Exception {
        String randomSentence = getRandomSentence();
        return  "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Nicolas Aguilera Contreras</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>Welcome to ibai random sentences generator</h1>\n"
                + "Hello "+""+values+"\n"
                + "<br>\n"
                + "Every time you regenerate the page you will get a random phrase from Ibai Llanos"+"\n"
                + "<br>\n"
                + "<h3>Phrase: "+randomSentence+"</h3>\n"
                + "</body>\n"
                + "</html>\n";
    }
}
