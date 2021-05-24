package co.escuelaing.edu;

/**
 * Class that represents a calculator
 */
public class CalculatorServicesImpl implements CalculatorService {

    /**
     * Calculates the logarithm of a number
     * @param value The value that is going to be calculated with the Logarithm
     * @return the logarithm of the value
     */
    @Override
    public Double calculateTheLogarithm(Double value) {
        Double log = Math.log10(value);
        return log;
    }

    /**
     * Raises the Euler number to a number
     * @param value the number that is going to raise the euler number
     * @return The euler number raised to the number
     */
    @Override
    public Double raiseEulerToAPower(Double value) {
        Double exp = Math.pow(Math.E,value);
        return exp;
    }
}
