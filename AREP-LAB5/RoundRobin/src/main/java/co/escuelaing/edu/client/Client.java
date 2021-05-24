package co.escuelaing.edu.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class that Implements the Client Service Method.
 */
public class Client {

    //private static final String API_URL = "http://localhost";
    private static final String API_URL = "http://ec2-3-138-154-47.us-east-2.compute.amazonaws.com";
    private final String[] ports = {"34001", "34002", "34003"};
    private int server = 0;


    public Object getLastLogs() throws IOException {
        try {
            calculateRoundRobinServerNumber();
            URL obj = new URL(API_URL+":"+ports[server]+"/getlogs");
            System.out.println(obj.getContent());
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            StringBuffer response = null;
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            } else {
                return "Logs not found";
            }
            return String.valueOf(response);
        } catch(MalformedURLException ex){
            throw new MalformedURLException(ex.getMessage());
        } catch(IOException ex){
            throw new IOException(ex.getMessage());
        }
    }

    private void calculateRoundRobinServerNumber() {
        server = (server + 1) % ports.length;
    }

    public Object addLog(String content) throws IOException {
        try {
            calculateRoundRobinServerNumber();
            URL obj = new URL(API_URL+":"+ports[server]+"/insertlog?content="+content);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            StringBuffer response = null;
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            } else {
                return "Logs not inserted";
            }
            return String.valueOf(response);
        } catch(MalformedURLException ex){
            throw new MalformedURLException(ex.getMessage());
        } catch(IOException ex){
            throw new IOException(ex.getMessage());
        }
    }
}