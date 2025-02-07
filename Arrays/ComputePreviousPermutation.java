public class ComputePreviousPermutation {

    /**
     * Time Complexity of previousPermutation:
     * The time complexity of the previousPermutation solution is O(n), where n is the length of the input array.
     * This is because we have to find the rightmost element that violates the descending order, swap elements, and reverse a portion of the array, all of which take linear time.
     * Space Complexity of previousPermutation:
     * - The space complexity is O(1) since we are modifying the array in place and not using any additional data structures that depend on the input size.
     *
     *
     *
     * Intuition:
     * - The goal is to find the largest permutation that is smaller than the current one.
     * - To do this, we need to identify the first position (from right to left) where the order is not descending—this indicates the point where a reduction in value can occur.
     * - By swapping this element with the largest value to its right that is smaller than itself, we ensure the permutation is the next smallest.
     * - Finally, reversing the order of elements to the right creates the largest possible permutation for these elements, making it the correct previous permutation.
     */
    public static int[] previousPermutation(int[] p) {
        int n = p.length;
        int i = n - 2;
        // Find the first element that is greater than its next element
        while (i >= 0 && p[i] <= p[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = n - 1;
            // Find the first element from the right that is smaller than p[i]
            while (p[j] >= p[i]) {
                j--;
            }
            // Swap p[i] and p[j]
            swap(p, i, j);
        }
        // Reverse the elements from i + 1 to the end of the array
        reverse(p, i + 1, n - 1);
        return p;
    }

    private static void swap(int[] p, int i, int j) {
        int temp = p[i];
        p[i] = p[j];
        p[j] = temp;
    }

    private static void reverse(int[] p, int start, int end) {
        while (start < end) {
            swap(p, start, end);
            start++;
            end--;
        }
    }
}
