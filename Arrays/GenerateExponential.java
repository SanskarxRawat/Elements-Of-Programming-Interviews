import java.util.Random;

public class GenerateExponential {


    public static double generateExponential(double lambda) {
        Random random = new Random();
        double u = random.nextDouble(); // Generate a value from [0, 1] uniformly
        return -Math.log(1 - u) / lambda; // Apply the inverse transform sampling method
    }
}
