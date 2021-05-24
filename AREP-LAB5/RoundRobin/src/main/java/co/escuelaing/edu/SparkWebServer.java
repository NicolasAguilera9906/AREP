package co.escuelaing.edu;

import co.escuelaing.edu.client.Client;
import spark.Request;
import spark.Response;

import java.io.IOException;
import static spark.Spark.*;
public class SparkWebServer {

    private static Client client = new Client();

    public static void main(String... args){
        port(getPort());
        staticFiles.location("/static");
        get("/", SparkWebServer::redirectToIndexPage);
        get("/lastlogs", SparkWebServer::getLastLogs);
        post("/addlog", SparkWebServer::addLog);
    }

    private static Object getLastLogs(Request request , Response response) throws IOException {
        return client.getLastLogs();
    }

    private static Object addLog(Request request , Response response) throws IOException {
        System.out.println("hola");
        return client.addLog(request.queryParams("content"));
    }

    private static Object redirectToIndexPage(Request request, Response response) {
        response.redirect("/index.html");
        return null;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4400;
    }
}
