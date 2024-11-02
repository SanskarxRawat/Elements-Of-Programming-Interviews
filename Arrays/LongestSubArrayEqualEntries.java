public class LongestSubArrayEqualEntries {

    /**
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
