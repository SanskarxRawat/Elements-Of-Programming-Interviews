import java.util.HashSet;
import java.util.Set;

public class TestCollatzConjecture {


    /**
     * The Collatz conjecture is the following: Take any natural number. If it is odd, triple
     * it and add one; if it is even, halve it. Repeat the process indefinitely. No matter what
     * number you begin with, you will eventually arrive at 1.
     * As an example, if we start with 11 we get the sequence 11,34,17,52,26,13,40,
     * 20,10,5,16,8,4,2,1.
     */

    public static boolean testCollatzConjecture(int n) {

        Set<Long> verifiedNumbers = new HashSet<>();
        verifiedNumbers.add(1L);

        for (int i = 2; i <= n; i++) {
            Set<Long> sequence = new HashSet<>();
            long testI = i;
            while (testI >= i) {
                if (!sequence.add(testI)) {
                    return false;
                }

                if ((testI % 2) != 0) {
                    if (!verifiedNumbers.add(testI)) {
                        break;
                    }
                    long nextTestI = 3 * testI + 1;
                    if (nextTestI <= testI) {
                        throw new ArithmeticException("Collatz sequence overflow for " + i);
                    }
                    testI = nextTestI;
                } else {
                    testI /= 2;
                }
            }
        }
        return true;
    }
}
