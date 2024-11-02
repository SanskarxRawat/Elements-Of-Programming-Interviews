public class InversePermutationArray {

    /**
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
