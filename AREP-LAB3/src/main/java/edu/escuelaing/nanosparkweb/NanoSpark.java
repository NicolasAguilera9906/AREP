package edu.escuelaing.nanosparkweb;

import java.util.function.BiFunction;

/**
 * Class that is responsible for putting into operation the class that represents the nano spark server.
 */
public class NanoSpark {

    /**
     * Method that instantiates the NanoSparkServer class and registers a path for requests to be accepted in it
     * @param path Path to be registered in the web server
     * @param bifunction binary function with two input parameters that represent an http request and response and an output parameter of type string representing the result of said operation.
     */
    public static void get(String path , BiFunction<MyCustomRequest,MyCustomResponse,String> bifunction){
        NanoSparkServer nanosparksvr = NanoSparkServer.getInstance();
        nanosparksvr.get(path,bifunction);
    }

    /**
     * Method that gets an instance of the NanoSparkServer and starts the web server.
     */
    public static void startServer(){
        NanoSparkServer nanosparksvr = NanoSparkServer.getInstance();
        nanosparksvr.startServer();
    }
}
