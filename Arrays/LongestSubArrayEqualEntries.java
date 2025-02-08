public class LongestSubArrayEqualEntries {

    /**
     * This method finds the length of the longest subarray with consecutive equal entries.
     *
     * Intuition:
     * - Traverse the array while maintaining two variables: `maxLength` and `currentLength`.
     * - `currentLength` keeps track of the length of the current sequence of equal entries.
     * - If the current element (`arr[i]`) is equal to the previous one (`arr[i-1]`), increment `currentLength`.
     * - Otherwise, reset `currentLength` to 1 to start counting a new sequence.
     * - Continuously update `maxLength` to hold the maximum value of `currentLength` encountered so far.
     * - Return `maxLength` at the end, which represents the longest sequence of consecutive equal entries.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int findLongestSubarrayLength(int[] arr) {
        if (arr.length == 0) return 0;

        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 1;
            }
        }
        return maxLength;
    }
}
