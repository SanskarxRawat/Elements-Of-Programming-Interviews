import java.util.Arrays;

public class MinimumNumberStepsToReachEndArray {

    /**
     * Time Complexity: O(n^n)
     * Space Complexity: O(n)
     */

    static int minJumps(int arr[], int l, int h) {
        // Base case: when source
        // and destination are same
        if (h == l)
            return 0;

        // When nothing is reachable
        // from the given source
        if (arr[l] == 0)
            return Integer.MAX_VALUE;

        // Traverse through all the points
        // reachable from arr[l]. Recursively
        // get the minimum number of jumps
        // needed to reach arr[h] from these
        // reachable points.
        int min = Integer.MAX_VALUE;
        for (int i = l + 1; i <= h && i <= l + arr[l];
             i++) {
            int jumps = minJumps(arr, i, h);
            if (jumps != Integer.MAX_VALUE
                    && jumps + 1 < min)
                min = jumps + 1;
        }
        return min;
    }

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     * Memoization
     *
     */
    private static int jump(int[] nums, int idx, int end, int[] memo) {

        // We reached the end. No jumps to make further
        if (idx == end)
            return 0;

        if (memo[idx] != -1)
            return memo[idx];

        int min_jumps = Integer.MAX_VALUE - 1;

        // We will try to make all possible jumps from the current index
        // and select the minimum of those.
        // It does not matter if we try from 1 to nums[idx] or from nums[idx] to 1.
        for (int j = nums[idx]; j >= 1; --j) {
            // If we make this jump 'j' distance away from idx,
            // do we overshoot?
            // If we land within the nums, we will test further.
            if (idx + j <= end) {
                // Make a jump to idx + j index and explore further,
                // then update min_jumps with the minimum jumps
                // we made to reach the end while trying all possible
                // nums[idx] jumps from the current index.
                min_jumps = Math.min(min_jumps, 1 + jump(nums, idx + j, end, memo));
            }
        }

        return memo[idx] = min_jumps;
    }

    // Memoization
    private static int minJumps(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return jump(nums, 0, nums.length - 1, memo);
    }

    /**
     * Tabulation
     *  Time Complexity: O(n^2)
     *   Space Complexity: O(n)
     */

    private static int minJumps(int[] arr, int n) {
        // jumps[n-1] will hold the
        int jumps[] = new int[n];
        // result
        int i, j;

        // if first element is 0,
        if (n == 0 || arr[0] == 0)
            return Integer.MAX_VALUE;
        // end cannot be reached

        jumps[0] = 0;

        // Find the minimum number of jumps to reach arr[i]
        // from arr[0], and assign this value to jumps[i]
        for (i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; j++) {
                if (i <= j + arr[j]
                        && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i]
                            = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[n - 1];
    }

}
