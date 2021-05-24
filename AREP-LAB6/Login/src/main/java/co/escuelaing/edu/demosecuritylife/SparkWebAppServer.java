package co.escuelaing.edu.demosecuritylife;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Session;
import spark.staticfiles.StaticFilesConfiguration;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


/**
 * Class that makes a SparkWebServer
 */
public class SparkWebAppServer {

    private static final Gson gson = new Gson();
    private static Map<String,String> users=new HashMap<>();
    private static PasswordService passwordService = new PasswordService();


    /**
     * Main class of the application
     * @param args arguments needed to execute de app
     * @throws CertificateException in case of an error
     * @throws NoSuchAlgorithmException in case of an error
     * @throws KeyStoreException in case of an error
     * @throws KeyManagementException in case of an error
     * @throws IOException in case of an error
     */
    public static void main(String ... args) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        users.put("test@mail.com",passwordService.hashPass("test123"));
        secure("keyscerts/loginservice.p12", "123456", null, null);
        SecureUrlReader.init();
        port(getPort());
        before("/auth/*", SparkWebAppServer::handleSecureRequests);
        before("/login.html", SparkWebAppServer::handleLoginRequests);
        StaticFilesConfiguration staticHandler = new StaticFilesConfiguration();
        staticHandler.configure("/static");
        before((request, response) ->
                staticHandler.consume(request.raw(), response.raw()));
        get("/hellosecureservice", (req,res) -> "Hello from service!" );
        get("/hour", SparkWebAppServer::getHour);
        post("/login",SparkWebAppServer::handleLogin);
        post("/logout",SparkWebAppServer::handleLogout);
        get("/auth/service",SparkWebAppServer::getHour);

    }

    /**
     * Handle a request of logout to the server
     * @param request request made to the server
     * @param response response made to the server
     * @return response of the operation made
     */
    private static Object handleLogout(Request request, Response response) {
        request.session(true);
        request.session().attribute("Logged", false);
        return "Successful logout";
    }

    /**
     * Handle a request of login to the server
     * @param request request made to the server
     * @param response response made to the server
     * @return response of the operation made
     */
    private static void handleLoginRequests(Request request, Response response) {
        request.session(true);
        if (request.session().isNew()) {
            request.session().attribute("Logged", false);
        }
        boolean auth = request.session().attribute("Logged");
        if (auth) {
            response.redirect("auth/index.html");
        }
    }

    /**
     * Gets the actual hour
     * @param request request made to the server
     * @param response response of the server
     * @return the actual hour
     * @throws IOException in case of an error
     */
    private static Object getHour(Request request, Response response) throws IOException {
        return SecureUrlReader.getService();
    }


    /**
     * Handle a request of post login to the server
     * @param request request made to the server
     * @param response response made to the server
     * @return response of the operation made
     */
    private static Object handleLogin(Request request, Response response) {
        System.out.println("Login received");
        request.body();
        request.session(true);
        String result = "";
        User user = gson.fromJson(request.body(), User.class);
        if (passwordService.hashPass(user.getPassword()).equals(users.get(user.getEmail()))) {
            request.session().attribute("User", user.getEmail());
            request.session().attribute("Logged", true);
            result = "Successful login";
            return result;
        } else {
            result = "Bad credentials";
        }
        return result;
    }

    /**
     * Handle a request to the server
     * @param request request made to the server
     * @param response response made to the server
     * @return response of the operation made
     */
    private static void handleSecureRequests(Request request, Response response) {
        request.session(true);
        Session session = request.session();
        boolean newSession = session.isNew();
        if(newSession){
            request.session().attribute("Logged",false);
        }else{
            boolean auth=request.session().attribute("Logged");
            if(!auth) {
            halt(401, "<h1>401 Unauthorized</h1>");
        }};
    }

    /**
     * Gets a default Port of the server
     * @return the port of the server
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }
}
