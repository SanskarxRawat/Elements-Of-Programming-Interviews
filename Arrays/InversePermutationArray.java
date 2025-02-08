public class InversePermutationArray {

    /**
     * Intuition:
     * - The idea is to encode both the original value and the new value into a single array cell.
     * - This is achieved by adding the new value (calculated as A[A[i]]) multiplied by 'n' (array size)
     * to the current value of A[i]. Using modulo operation ensures we access the original value
     * without it being overwritten.
     * - In the second loop, we decode the new value by dividing the updated A[i] by 'n', effectively
     * retrieving the new value and completing the inversion process in-place.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static void invertPermutation(int[] A) {
        int n = A.length;

        for (int i = 0; i < n; i++) {
            // Encoding both original and new values in the same array cell
            // Add the new value (A[A[i]]) as (new_value * n) to the current A[i]
            // to avoid overwriting the original values immediately
            A[A[i] % n] += (i * n);
        }

        // Decode the final result
        for (int i = 0; i < n; i++) {
            A[i] /= n; // Extract the new value by dividing by n
        }
    }
}
