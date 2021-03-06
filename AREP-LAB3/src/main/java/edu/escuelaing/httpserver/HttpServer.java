package edu.escuelaing.httpserver;

import edu.escuelaing.nanosparkweb.NanoSparkServer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class implements a simple HTTP server
 */
public class HttpServer {

    /**
     * Default constructor of this class
     */
    public HttpServer(){
        super();
    }
    private OutputStream outputStream;

    /**
     * Returns an object representing a byte stream object
     * @return an object representing a byte stream object
     */
    public OutputStream getOutputStream() {
        return outputStream;
    }


     /**
     * Sets an object representing a byte stream object
     * @param outputStream an object representing a byte stream object
     */
    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    /**
     * Establish a server socket and open client connections for multiple requests.
     * @throws IOException In case of getting an error when setting the socket
     */
    public void startServer() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(getPort());
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        acceptAndManageRequests(serverSocket);
    }

    /**
     * It is responsible for accepting and handling requests made by clients through a socket.
     * @param serverSocket Object representing the socket connection opened by the server
     * @throws IOException In case the client gets any error connecting to the socket
     */
    private void acceptAndManageRequests(ServerSocket serverSocket) throws IOException {
        boolean running = true;
        while(running) {
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
                setOutputStream(clientSocket.getOutputStream());
            } catch (IOException e) {
                System.exit(1);
            }
            BufferedReader in = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.contains("GET")) {
                    String endpoint = inputLine.split(" ")[1];
                    if (endpoint.equals("/") || endpoint.equals("") || !isNanoSparkEndpoint(endpoint , NanoSparkServer.getInstance())) {
                        getStaticFiles(endpoint,clientSocket);
                    }
                }
                if (!in.ready()) { break; }
            }
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }

    /**
     * Determine if an endpoint is part of the nanospark web server
     * @param endpoint the endpoint to analyze
     * @param nanoSpark Object representing the nano spark server
     * @return true if it is endpoint of the nano spark web server
     * false if it is not part of the nano spark web server
     */
    private boolean isNanoSparkEndpoint(String endpoint , NanoSparkServer nanoSpark) {
        boolean isSparkEndpoint = false;
        if (endpoint.contains("/Apps")) {
            nanoSpark.verifyPathOnEndpoints(endpoint.replace("/Apps", ""));
            isSparkEndpoint = true;
        }
        return isSparkEndpoint;
    }

    /**
     * Get a static file from the server
     * @param resource string representing the searched file
     * @param clientSocket Object that represents the connection to the socket opened by a client
     * @throws IOException In case the file is not found on the web server
     */
    private void getStaticFiles(String resource, Socket clientSocket) throws IOException {
        if(resource.equals("/") || resource.equals("")){
            resource="index.html";
        }
        if(resource.contains("html")){
            getResource("/src/main/resources/static/"+resource, clientSocket.getOutputStream(), "html");
        }
        if(resource.contains("js")){
            getResource("/src/main/resources/static/"+resource, clientSocket.getOutputStream(), "json");
        }
        if(resource.contains("png")){
            getImagen("/src/main/resources/static/"+resource,clientSocket.getOutputStream());
        }
    }

    /**
     * Finds a static file on the web server and prints it to the screen
     * @param path The path where the file is located
     * @param outputStream An object representing a byte stream object
     * @param type The type of file to print
     */
    private static void getResource(String path, OutputStream outputStream, String type){
        try {
            BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir")+path));
            String out = "";
            String line;
            while ((line = in.readLine()) != null){
                out = out + line;
            }
            outputStream.write(("HTTP/1.1 201 OK\r\n"
                    + "Content-Type: text/"+type+";"
                    + "charset=\"UTF-8\" \r\n"
                    + "\r\n"
                    + out).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Finds a static image on the web server and prints it to the screen
     * @param path The path where the image is located
     * @param outputStream An object representing a byte stream object
     */
    public static void getImagen(String path, OutputStream outputStream){
        try {
            BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir") + path));
            ByteArrayOutputStream ArrBytes = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(outputStream);
            ImageIO.write(image, "PNG", ArrBytes);
            out.writeBytes("HTTP/1.1 200 OK \r\n"
                    + "Content-Type: image/png \r\n"
                    + "\r\n");
            out.write(ArrBytes.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets a free port from the system in case port 35000 is busy. If not, return port 35000
     * @return A free port from the system in case port 35000 is busy. If not, return port 35000
     */
    private int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000;
    }
}
