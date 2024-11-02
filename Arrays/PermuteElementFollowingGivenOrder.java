public class PermuteElementFollowingGivenOrder {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
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
        return arr;
    }
}
