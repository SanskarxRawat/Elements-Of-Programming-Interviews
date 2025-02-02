import java.util.Arrays;

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

    public static void main(String[] args) {
        int[] nums = {10, 22, 9, 33, 21, 50, 41, 60};
        int longestNonDecreasingSubsequence = longestNonDecreasingSubsequence(nums);
        System.out.println("The length of the longest nondecreasing subsequence is: " + longestNonDecreasingSubsequence);
    }
}
