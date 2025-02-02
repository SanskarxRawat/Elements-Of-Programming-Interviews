import java.util.Arrays;
import java.util.List;

public class PickUpCoins {

    /**
     * Design an efficient algorithm for computing the maximum total value for the starting
     * player in the pick-up-coins game.
     */


    /**
     * Approach: Dynamic Programming
     * 
     * We use a dynamic programming approach to solve this problem.
     * Define dp[i][j] as the maximum value the starting player can collect
     * when considering the subarray of coins from index i to j.
     * The key idea is to maximize the current player's score while minimizing
     * the score of the opponent, who will pick next.
     * 
     * To compute dp[i][j], the player can pick either the leftmost coin (coins[i])
     * or the rightmost coin (coins[j]). Depending on the choice:
     * - If coins[i] is picked, the opponent can only play in the range [i+1, j].
     * - If coins[j] is picked, the opponent can only play in the range [i, j-1].
     * 
     * The formula to compute dp[i][j] is:
     * dp[i][j] = max(
     * coins[i] + min(dp[i+2][j], dp[i+1][j-1]),
     * coins[j] + min(dp[i+1][j-1], dp[i][j-2])
     * )
     * 
     * Here, the min() represents the opponent playing optimally.
     * To fill the dp table, choose ranges of increasing length and compute the value.
     * 
     *  Time Complexity : O(n^2)
     *  Space Complexity: O(n^2)
     */

    public static int pickUpCoins(List<Integer> coins) {
        int n = coins.size();
        int[][] dp = new int[n][n];

        for (int length = 1; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;

                // Ensure no out-of-bounds access by adding boundary checks
                int pickLeft = coins.get(i) +
                        (i + 1 <= j ? Math.min(
                                (i + 2 <= j ? dp[i + 2][j] : 0),
                                dp[i + 1][j - 1]
                        ) : 0);

                int pickRight = coins.get(j) +
                        (i <= j - 1 ? Math.min(
                                dp[i + 1][j - 1],
                                (i <= j - 2 ? dp[i][j - 2] : 0)
                        ) : 0);

                dp[i][j] = Math.max(pickLeft, pickRight);
            }
        }

        return dp[0][n - 1];
    }


        public static int pickUpCoinsRecursive(List<Integer> coins) {
            return maxValue(coins, 0, coins.size() - 1);
        }

        private static int maxValue(List<Integer> coins, int i, int j) {
            // Base cases
            if (i > j) {
                return 0;
            }
            if (i == j) {
                return coins.get(i);
            }

            // Recursive cases
            int pickLeft = coins.get(i) + Math.min(
                    maxValue(coins, i + 2, j),
                    maxValue(coins, i + 1, j - 1)
            );

            int pickRight = coins.get(j) + Math.min(
                    maxValue(coins, i + 1, j - 1),
                    maxValue(coins, i, j - 2)
            );

            return Math.max(pickLeft, pickRight);
        }

    public static void main(String[] args) {
        List<Integer> coins = Arrays.asList(5, 3, 7, 10); // Sample Input
        int resultDP = pickUpCoins(coins);
        int resultRecursive = pickUpCoinsRecursive(coins);

        // Print results
        System.out.println("Result using DP: " + resultDP);
        System.out.println("Result using Recursive: " + resultRecursive);

        // Verify correctness
        if (resultDP == resultRecursive) {
            System.out.println("Both approaches yield the same result: " + resultDP);
        } else {
            System.err.println("Mismatch between DP and Recursive results!");
        }
    }
}
