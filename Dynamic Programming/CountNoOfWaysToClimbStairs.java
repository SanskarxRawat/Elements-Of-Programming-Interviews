public class CountNoOfWaysToClimbStairs {


    /**
     * You are climbing stairs. You can advance 1 to k steps at a time. Your destination is
     * exactly n steps up.
     * Write a program which takes as inputs n and k and returns the number of ways in
     * which you can get to your destination. For example, if n = 4 and k = 2, there are five
     * ways in which to get to the destination:
     * • four single stair advances,
     * • two single stair advances followed by a double stair advance,
     * • a single stair advance followed by a double stair advance followed by a single
     * stair advance,
     * • a double stair advance followed by two single stairs advances, and
     * • two double stair advances.
     */

    /**
     * Approach: Recursive
     * Time Complexity: O(k^n)
     * Space Complexity: O(n) call stack
     *
     *
     * DP
     *
     * Time Complexity: O(n*k)
     * Space Complexity: O(n)
     */

    public static int countWaysToClimbStairsRecursive(int n, int k) {
        if(n==0) return 1;
        if(n<0 || k<0) return 0;
        return countWaysToClimbStairsRecursive(n-1, k) + countWaysToClimbStairsRecursive(n-k, k);
    }

    public static int countWaysToClimbStairs(int n, int k) {
        int[] dp = new int[n + 1];
        dp[0] = 1; // One way to stay at the ground (do nothing).

        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[n];
    }
}
