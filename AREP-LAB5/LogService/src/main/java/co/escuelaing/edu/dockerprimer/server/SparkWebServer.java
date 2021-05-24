package co.escuelaing.edu.dockerprimer.server;

import co.escuelaing.edu.dockerprimer.model.Database;
import co.escuelaing.edu.dockerprimer.model.Log;
import co.escuelaing.edu.dockerprimer.services.LogService;
import co.escuelaing.edu.dockerprimer.services.LogServiceImpl;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import static spark.Spark.*;

public class SparkWebServer {

    private static final String URL = "3.138.154.47";
    //private static final String URL = "mongoDB";
    private static final int PORT = 27017;
    private static Database database;
    private static LogService logService = new LogServiceImpl();

    public static void main(String... args){
        database = new Database(URL,PORT,"logcenter");
        port(getPort());
        get("hello", (req,res) -> "Hello Docker!");
        get("getlogs", (req,res) -> getLogs());
        get("insertlog", (req,res) -> insertLog(req.queryParams("content")));
    }
    private static String insertLog(String content){
        try {
            MongoDatabase db = logService.getDatabase(database);
            MongoCollection<Document> collection = logService.getDatabaseCollection("logs", db);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            Log log = new Log(content, date.toString());
            logService.insertLogInDatabaseCollection(log, collection);
            return "Log inserted!";
        } catch (Exception e){
            return e.getMessage();
        }

    }
    private static String getLogs(){
        MongoDatabase db = logService.getDatabase(database);
        MongoCollection<Document> collection = logService.getDatabaseCollection("books",db);
        List<Log> logs= logService.getLogs(collection);
        Collections.reverse(logs);
        List<Log> tenLogs= new ArrayList<>();
        int cont = 0;
        for(Log log : logs){
            tenLogs.add(log);
            cont++;
            if(cont==10){
                break;
            }
        }
        String logsToJson = new Gson().toJson(tenLogs);
        return logsToJson;
    }
    public Database getDatabase() {
        return database;
    }
    public void setDatabase(Database database) {
        this.database = database;
    }
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4500;
    }
}