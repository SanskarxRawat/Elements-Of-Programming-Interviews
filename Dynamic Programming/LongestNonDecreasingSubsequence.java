import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestNonDecreasingSubsequence {


    /**
     * Write a program that takes as input an array of numbers and returns the length of a
     * longest nondecreasing subsequence in the array.
     */

    /**
     * Approach: Dynamic Programming
     * <p>
     * This solution computes the length of the longest nondecreasing subsequence in the array
     * using a dynamic programming approach.
     * <p>
     * Steps:
     * 1. Use a DP array 'dp' where dp[i] represents the length of the longest nondecreasing
     * subsequence that ends at index i.
     * 2. Initialize each element of dp with 1 because the minimum length of a subsequence is 1
     * (the element itself).
     * 3. For each element i in the array:
     * - Compare it with all previous elements j (where j < i).
     * - If nums[i] >= nums[j], update dp[i] = max(dp[i], dp[j] + 1), because nums[i] can
     * extend the subsequence ending at nums[j].
     * 4. The result is the maximum value in the dp array, which represents the length of the
     * longest nondecreasing subsequence.
     *
     * Time Complexity:
     * - O(n^2): Two nested loops iterate through the array.
     *
     * Space Complexity:
     * - O(n): Additional space is used for the dp array.
     */
    public static int longestNonDecreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Initialize every element with 1, as the minimum subsequence length is 1

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().orElse(1); // Return the maximum value in dp array
    }

    /**
     *  Optimized Approach: O(n*logn(n))
     * Binary Search Approach
     */


    public static int lengthOfLNDS(int[] nums) {
        // Temp array to store the smallest elements of subsequence
        List<Integer> temp = new ArrayList<>();

        for (int num : nums) {
            // Use binary search to find the position to replace or expand
            int pos = binarySearch(temp, num);

            if (pos == temp.size()) {
                // If num >= all elements, append it to the subsequence
                temp.add(num);
            } else {
                // Replace the element at the position to maintain optimality
                temp.set(pos, num);
            }
        }

        return temp.size(); // Length of temp is the LNDS length
    }

    private static int binarySearch(List<Integer> temp, int x) {
        int low = 0, high = temp.size();

        // Standard binary search to find the insertion position
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (temp.get(mid) <= x) {
                low = mid + 1; // Move to the right half
            } else {
                high = mid;    // Move to the left half
            }
        }

        return low;
    }
}
