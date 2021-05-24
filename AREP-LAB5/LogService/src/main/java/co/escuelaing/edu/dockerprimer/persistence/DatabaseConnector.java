package co.escuelaing.edu.dockerprimer.persistence;

import co.escuelaing.edu.dockerprimer.model.Database;
import co.escuelaing.edu.dockerprimer.model.Log;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

public interface DatabaseConnector {

    public MongoDatabase getDatabase(Database database);

    public MongoCollection<Document> getDatabaseCollection(String name , MongoDatabase database);

    public List<Log> getLogs(MongoCollection<Document> databaseCollection);

    public void insertLogInDatabaseCollection(Log log  ,MongoCollection<Document> databaseCollection );
}
