package co.escuelaing.edu.dockerprimer.services;

import co.escuelaing.edu.dockerprimer.model.Database;
import co.escuelaing.edu.dockerprimer.model.Log;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public interface LogService {

    public MongoDatabase getDatabase(Database database);

    public MongoCollection<Document> getDatabaseCollection(String name , MongoDatabase database);

    public void insertLogInDatabaseCollection(Log log ,MongoCollection<Document> databaseCollection);


    public List<Log> getLogs(MongoCollection<Document> databaseCollection) ;
}
