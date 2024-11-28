public class ComputeRealSquareRoot {

    /**
     * Implement a function which takes as input a floating point value and returns its
     * square root.
     */

    /**
     * Computes the square root of a given floating-point number x.
     *
     * @param x         The number for which the square root is to be computed. Must be non-negative.
     * @param tolerance The precision of the computed result (default: 1e-10).
     * @return The square root of x.
     * @throws IllegalArgumentException If x is negative.
     */
    public static double squareRoot(double x, double tolerance) {
        if (x < 0) {
            throw new IllegalArgumentException("Square root is not defined for negative numbers.");
        }

        if (x == 0 || x == 1) {
            return x;
        }

        // Initial guess (half of x or x/2 is a common choice)
        double guess = x / 2.0;

        while (true) {
            // Newton-Raphson iteration formula
            double nextGuess = 0.5 * (guess + x / guess);

            // Check if the difference between guesses is within the tolerance
            if (Math.abs(nextGuess - guess) < tolerance) {
                return nextGuess;
            }

            guess = nextGuess;
        }
    }
    // Overloaded method with default tolerance
    public static double squareRoot(double x) {
        return squareRoot(x, 1e-10);
    }

    public static void main(String[] args) {
        System.out.println(squareRoot(7.0));
    }
}
