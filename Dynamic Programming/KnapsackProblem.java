public class KnapsackProblem {

    /**
     * Write a program for the knapsack problem that selects a subset of items that has
     * maximum value and satisfies the weight constraint. All items have integer weights
     * and values. Return the value of the subset
     */

    /**
     * Approach : Recursion
     */


    public static int knapsack(int W, int[] wt, int[] val,int n) {

        if(n==0 || W==0){
            return 0;
        }

        //If the nth weight is greater than the capacity we can't include it
        if(W>wt[n-1]){
            return knapsack(W,wt,val,n-1);
        }

        //return the maximum of two cases 1. included and 2. not included

        else return Math.max(knapsack(W,wt,val,n-1),val[n-1]+knapsack(W-wt[n-1],wt,val,n-1));
    }

    /**
     * Other Approaches Include
     * 1. Memoization with O(n*W) Time and Space Complexity
     */

    /**
     * Space Optimized Solution
     * Time Complexity: O(n*W)
     * Space Complexity: O(W)
     *
     * Approach:
     *
     * For calculating the current row of the dp[] array we require only previous row,
     * but if we start traversing the rows from right to left then it can be done with a single row only
     */

    static int knapsackSpacedOptimized(int W, int wt[], int val[], int n){
        // Making and initializing dp array
        int[] dp = new int[W + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int w = W; w >= 0; w--) {
                if (wt[i - 1] <= w){
                    // Finding the maximum value
                    dp[w] = Math.max(dp[w], dp[w - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        // Returning the maximum value of knapsack
        return dp[W];
    }

}
