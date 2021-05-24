package co.escuelaing.edu.dockerprimer.services;

import co.escuelaing.edu.dockerprimer.model.Database;
import co.escuelaing.edu.dockerprimer.model.Log;
import co.escuelaing.edu.dockerprimer.persistence.DatabaseConnector;
import co.escuelaing.edu.dockerprimer.persistence.DatabaseConnectorImpl;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

public class LogServiceImpl implements LogService {

    private static final DatabaseConnector databaseConnector = new DatabaseConnectorImpl();

    @Override
    public MongoDatabase getDatabase(Database database) {
        return databaseConnector.getDatabase(database);
    }

    @Override
    public MongoCollection<Document> getDatabaseCollection(String name , MongoDatabase database) {
        return databaseConnector.getDatabaseCollection(name,database);
    }

    @Override
    public void insertLogInDatabaseCollection(Log log , MongoCollection<Document> databaseCollection) {
        databaseConnector.insertLogInDatabaseCollection(log,databaseCollection);
    }

    @Override
    public List<Log> getLogs(MongoCollection<Document> databaseCollection) {
        return databaseConnector.getLogs(databaseCollection);
    }
}
