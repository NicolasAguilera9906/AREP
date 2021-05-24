package co.escuelaing.edu.demosecuritylife;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class SecureUrlReader {


    /**
     * Initialize the service that trust on a TrustStore
     * @throws KeyStoreException in case of error
     * @throws IOException in case of error
     * @throws NoSuchAlgorithmException in case of error
     * @throws CertificateException in case of error
     * @throws KeyManagementException in case of error
     */
    public static void init() throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, KeyManagementException {
        // Create a file and a password representation
        File trustStoreFile = new File("keyscerts/myTrustStore");
        char[] trustStorePassword = "123456".toCharArray();
        // Load the trust store, the default type is "pkcs12", the alternative is "jks"
        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(new FileInputStream(trustStoreFile), trustStorePassword);
        // Get the singleton instance of the TrustManagerFactory
        TrustManagerFactory tmf = TrustManagerFactory
                .getInstance(TrustManagerFactory.getDefaultAlgorithm());

        // Itit the TrustManagerFactory using the truststore object
        tmf.init(trustStore);
        //Set the default global SSLContext so all the connections will use it
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);
        SSLContext.setDefault(sslContext);
        // We can now read this URL
        // This one can't be read because the Java default truststore has been
        // changed.
    }


    /**
     * Makes a Client to get a service from another server
     * @return the response of the request
     * @throws IOException  in case of an error
     */
    public static String getService () throws IOException {
        String site = "https://localhost:5001/service";
        URL url = new URL(site);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setDoOutput(true);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return response.toString();
        }
    }
}
