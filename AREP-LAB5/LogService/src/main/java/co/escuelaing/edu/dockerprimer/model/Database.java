package co.escuelaing.edu.dockerprimer.model;

public class Database {

    private String url;
    private int port;
    private String name;

    public Database(String url, int port, String name) {
        this.url = url;
        this.port = port;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
