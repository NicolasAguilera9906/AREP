package co.escuelaing.edu;

/**
 * Class that declares the services of a Temperature converter
 */
public interface TemperatureService {

    /**
     * Converts Fahrenheit degrees to Celsius degrees
     * @param fahrenheit degrees to be converted
     * @return fahrenheit degrees converted to celcius
     */
    double convertFahrenheitToCelsius(double fahrenheit);
}
