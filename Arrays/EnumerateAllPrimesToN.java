import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnumerateAllPrimesToN {

    /**
     * Intuition:
     * - The `generatePrimes` method uses the Sieve of Eratosthenes algorithm.
     * - Starting from 2 (the first prime), it iteratively marks all multiples of a prime as non-prime.
     * - This process continues for the next unmarked number (which is guaranteed to be prime).
     * - By the end, all numbers that remain marked are primes.
     * <p>
     * Time Complexity: O(nlog(n)) - due to repeated division by increasing primes.
     * Space Complexity: O(n) - for the isPrime boolean list.
     */

    public static List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();

        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n + 1, true));

        isPrime.set(0, false);
        isPrime.set(1, false);

        for (int i = 2; i <= n; i++) {

            if (isPrime.get(i)) {
                primes.add(i);

                for (int j = i; j <= n; j += i) {
                    isPrime.set(j, false);
                }
            }
        }

        return primes;
    }

    /**
     * Intuition:
     * - The `generatePrimes2` method optimizes for space by only considering odd numbers.
     * - The first prime, 2, is added separately, as the remaining calculations skip even numbers.
     * - Similar to the Sieve of Eratosthenes, it starts with the first unmarked odd number and marks its multiples as non-prime.
     * - The isPrime array uses an index transformation to account for only odd numbers.
     * - This reduces memory usage and speeds up the marking process.
     * <p>
     * Time Complexity: O(nlog(n)) - due to efficient sieving of odd numbers.
     * Space Complexity: O(n/2) ≈ O(n) - optimized for odd-number representation.
     */

    public static List<Integer> generatePrimes2(int n) {
        final int size = (int) (Math.floor(0.5 * (n - 2)) + 1);

        List<Integer> primes = new ArrayList<>();
        primes.add(2);


        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(size, true));

        for (int i = 0; i < size; i++) {

            if (isPrime.get(i)) {
                int p = ((i * 2) + 3);
                primes.add(p);

                // Sieving from pA2, whose value is (4iA2 + 12i + 9). The index of this
                // value in isPrime is (2i^2 + 6i + 3) because isPrime.get(i) represents 2i + 3.
                // Note that we need to use long type for j because p^2 might overflow
                for (long j = ((i * i) * 2) + 6 * i + 3; j < size; j += p) {
                    isPrime.set((int) j, false);
                }
            }
        }

        return primes;
    }
}
