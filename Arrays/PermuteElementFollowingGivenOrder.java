public class PermuteElementFollowingGivenOrder {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * Intuition:
     * - The problem is addressed by following cycles in the permutation array P, where each cycle
     *   represents a group of indices that should be rearranged amongst themselves.
     * - We iterate through each index of the input array A, and for each unprocessed index (indicated
     *   by non-negative value in P), perform swaps to place the elements in their correct positions
     *   as defined by P.
     * - To ensure indices are not revisited during the cycle traversal, we subtract `n` (array size)
     *   from the values in P, effectively marking them as visited.
     * - By using the input array P to store these markers, we eliminate the need for extra space,
     *   making the algorithm very efficient in terms of space.
     */
    static void permute(int A[], int P[], int n) {
        // For each element of P
        for (int i = 0; i < n; i++) {
            int next = i;

            // Check if it is already
            // considered in cycle
            while (P[next] >= 0) {

                // Swap the current element according
                // to the permutation in P
                swap(A, i, P[next]);
                int temp = P[next];

                // Subtract n from an entry in P
                // to make it negative which indicates
                // the corresponding move
                // has been performed
                P[next] -= n;
                next = temp;
            }
        }
    }

    static int[] swap(int []arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
}
