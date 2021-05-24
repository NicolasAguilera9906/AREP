package Cache;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;

/**
 * Clase que implementa la interfaz de Cache de OpenWeatherCache y almacena los climas de las ciudades en Caché.
 */

public class OpenWeatherCache {
    private final ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();
    private final DelayQueue<CacheObject> cleaningUpQueue = new DelayQueue<>();

    /**
     * Constructor de la clase OpenWeatherCacheImpl
     */
    public OpenWeatherCache() {
        Thread cleanerThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    CacheObject cacheObject = cleaningUpQueue.take();
                    cache.remove(cacheObject.getKey(), cacheObject.getReference());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        cleanerThread.setDaemon(true);
        cleanerThread.start();
    }

    /**
     * Añade una nueva ciudad al cache de la aplicación
     * @param city la ciudad a ser usada como llave en el cache
     * @param weather el clima de la ciudad que se almacenará en el caché
     * @param periodInMillis el tiempo que durará el clima de la ciudad almacenada en caché
     * @throws OpenWeatherCacheException si existe un error al añadir la ciudad al cache
     */

    public void add(String city, String weather, long periodInMillis) throws OpenWeatherCacheException {
        if (city == null) {
            throw new OpenWeatherCacheException("La ciudad es nula");
        }
        if (weather == null) {
            cache.remove(city);
            throw new OpenWeatherCacheException("La ciudad no existe");
        } else {
            long expiryTime = System.currentTimeMillis() + periodInMillis;
            cache.put(city, weather);
            cleaningUpQueue.put(new CacheObject(city, weather, expiryTime));
        }
    }

    /**
     * Remueve un clima de una ciudad del cache de la aplicación
     * @param city la ciudad a ser usada como llave en el cache
     */
    private void remove(String city) {
        cache.remove(city);
    }

    /**
     * Obtiene un valor de un clima de una ciudad cache de acuerdo al nombre de la ciudad
     * @param city la ciudad a ser usada como llave en el cache
     * @return el clima de la ciudad almacenada en cache
     */
    public String get(String city) {
        return cache.get(city);
    }

    /**
     * Limpia el caché
     */
    private void clear() {
        cache.clear();
    }

    /**
     * Obtiene el numero de elementos almacenados en caché
     * @return el numero de elementos almacenados en caché
     */
    public long size() {
        return cache.size();
    }

}