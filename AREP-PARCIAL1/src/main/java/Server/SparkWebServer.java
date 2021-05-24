package Server;

import APIConsumers.ApiConsumer;
import APIConsumers.ApiConsumerException;
import APIConsumers.ApiConsumerImpl;
import Cache.OpenWeatherCache;
import Cache.OpenWeatherCacheException;
import com.google.gson.Gson;

import static spark.Spark.*;

/**
 * Servidor spark que ofrece el servicio de obtener los datos del clima de una ciudad en específico
 *
 * @author Nicolás Aguilera Contreras
 */
public class SparkWebServer {

    private static ApiConsumer apiConsumer;

    private static OpenWeatherCache openWeatherCache;

    /**
     * Funcion maín de la clase
     *
     * @param args Lista de argumentos que son necesarios para correr el programa
     */
    public static void main(String[] args) {
        Gson gson = new Gson();
        port(getPort());
        apiConsumer = new ApiConsumerImpl();
        openWeatherCache = new OpenWeatherCache();
        get("/clima", (req, res) -> {
            String city = req.queryParams("lugar");
            String json = "";
            if(city.length()==0){
                return "Por favor ingrese un lugar a buscar. Ejemplo : /clima?lugar=Bogota";
            }
            json = getWeatherByCity(city);
            return gson.toJson(json);
        });
    }

    /**
     * Obtiene el clima de una ciudad
     * @param city ciudad de la cual se obtendrá el clima
     * @return el clima de la ciudad
     * @throws ApiConsumerException en caso de que la ciudad no exista
     * @throws OpenWeatherCacheException en caso de que ocurra algun error consultando o guardando en cache
     */
    private static String getWeatherByCity(String city) throws ApiConsumerException, OpenWeatherCacheException {
        String result = "";
        if (openWeatherCache.get(city) == null) {
            try {
                result = apiConsumer.getWeatherByCity(city);
            } catch(ApiConsumerException e){
                return e.getMessage();
            }
            openWeatherCache.add(city,apiConsumer.getWeatherByCity(city),300000);
        }
        result = openWeatherCache.get(city);
        return result;
    }

    /**
     * Obtiene un puerto por defecto en caso de que esté disponible
     * @return el puerto por defecto
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}