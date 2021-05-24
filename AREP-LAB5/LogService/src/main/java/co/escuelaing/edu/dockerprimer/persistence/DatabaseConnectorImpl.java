package co.escuelaing.edu.dockerprimer.persistence;

import co.escuelaing.edu.dockerprimer.model.Database;
import co.escuelaing.edu.dockerprimer.model.Log;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DatabaseConnectorImpl implements DatabaseConnector {

    @Override
    public MongoDatabase getDatabase(Database database) {
        MongoClient mongoClient = new MongoClient(database.getUrl(), database.getPort());
        MongoDatabase db = mongoClient.getDatabase("store");
        return db;
    }

    @Override
    public MongoCollection<Document> getDatabaseCollection(String name , MongoDatabase database) {
        MongoCollection<Document> collection = database.getCollection("books");
        return collection;
    }

    @Override
    public List<Log> getLogs(MongoCollection<Document> databaseCollection) {
        List<Log> logs = new ArrayList<>();
        FindIterable<Document> iterDoc = databaseCollection.find();
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            Document document = (Document) it.next();
            Log log  = new Log(document.getString("content"),document.getString("date"));
            logs.add(log);
        }
        return logs;
    }

    @Override
    public void insertLogInDatabaseCollection(Log log, MongoCollection<Document> databaseCollection) {

        Document doc = new Document("content", log.getContent())
                .append("date",log.getDate());
        databaseCollection.insertOne(doc);
    }
}
