package co.escuelaing.edu;

/**
 * Class that implements the service of the class TemperatureService
 */
public class TemperatureServiceImpl implements TemperatureService {

    /**
     * Converts Fahrenheit degrees to Celsius degrees
     * @param fahrenheit degrees to be converted
     * @return fahrenheit degrees converted to celcius
     */
    @Override
    public double convertFahrenheitToCelsius(double fahrenheit) {

        double celsius = (fahrenheit-32)*(0.5556);

        return celsius;
    }
}
