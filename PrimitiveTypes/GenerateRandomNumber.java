import java.util.Random;

public class GenerateRandomNumber {

    /**
     * Time Complexity: O(log(b-a+1))
     * Space Complexity: O(1)
     */
    private static int randomBit() {
        Random rand = new Random();
        return rand.nextInt(2);
    }

    // Method to generate a random integer between a and b (inclusive)
    public static int randomIntBetween(int a, int b) {
        int rangeSize = b - a + 1;

        // Calculate the number of bits needed to cover the range size
        int numBits = (int) Math.ceil(Math.log(rangeSize) / Math.log(2));
        int maxPossibleValue = (1 << numBits) - 1; // 2^numBits - 1

        int result;
        do {
            result = 0;
            // Generate a random number using the calculated number of bits
            for (int i = 0; i < numBits; i++) {
                result = (result << 1) | randomBit();
            }
        } while (result >= rangeSize);

        // Shift result into the range [a, b]
        return a + result;
    }
}
