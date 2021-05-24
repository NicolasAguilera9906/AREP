package edu.escuelaing.nanosparkweb;

import edu.escuelaing.httpserver.HttpServer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that represents a nano version of a web server based on the Spark microframework
 */
public class NanoSparkServer {

    private static NanoSparkServer _theInstance = new NanoSparkServer();
    private HttpServer hserver = new HttpServer();
    private Map<String,BiFunction<MyCustomRequest, MyCustomResponse,String>> bodyMap = new HashMap();


    /**
     * Constructor of the class that starts the http server
     */
    public void startServer() {
        try {
            hserver.startServer();
        } catch (IOException ex) {
            Logger.getLogger(NanoSparkServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns an instance of this class
     * @return an instance of this class
     */
    public static NanoSparkServer getInstance() {
        return _theInstance;
    }

    /**
     * Register a route on the web server endpoints so that requests are accepted on it
     * @param path Path to be registered
     * @param bifunction binary function with two input parameters that represent an http request and response and an output parameter of type string representing the result of said operation.
     */
    public void get(String path, BiFunction<MyCustomRequest, MyCustomResponse,String> bifunction) {
        bodyMap.put(path,bifunction);
    }

    /**
     * Check if the path is stored on the web server endpoints
     * @param path to be verified
     */
    public void verifyPathOnEndpoints(String path) {
        String newPath;
        if(path.indexOf("?") > 0 ) {
             newPath = path.substring(0, path.indexOf("?"));
        }
        else{
            newPath = path;
        }
        bodyMap.forEach((k,v) -> {
            if(newPath.equals(k)){
                runRequest(path,v);
            }
        });
    }

    /**
     * It is responsible for executing the function that corresponds to a path requested by the user
     * @param path to be searched for execution
     * @param function to be executed
     */
    public void runRequest(String path, BiFunction<MyCustomRequest, MyCustomResponse, String> function) {
        try {
            String result = function.apply(new MyCustomRequest(path), new MyCustomResponse(path));
            if (result != null) {
                hserver.getOutputStream().write(("HTTP/1.1 200 OK\r\n" + "\r\n" + result).getBytes());
            }
        } catch (IOException e) {
            Logger.getLogger(NanoSparkServer.class.getName()).log(Level.SEVERE, null, e);

        }
    }
}
