package co.escuelaing.edu;

public interface CalculatorService {

    /**
     * Calculates the logarithm of a number
     * @param value The value that is going to be calculated with the Logarithm
     * @return the logarithm of the value
     */
    public Double calculateTheLogarithm(Double value);
    /**
     * Raises the Euler number to a number
     * @param value the number that is going to raise the euler number
     * @return The euler number raised to the number
     */
    public Double raiseEulerToAPower(Double value);
}
