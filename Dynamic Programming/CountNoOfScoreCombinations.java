public class CountNoOfScoreCombinations {


    /**
     * Write a program that takes a final score and scores for individual plays, and returns
     * the number of combinations of plays that result in the final score.
     */

    /**
     * Approach: Recursive
     * 1. For each play, there are two possibilities, either take or skip.
     * 2. If we take the play, then the final score will be reduced by the play score.
     * 3. If we skip the play, then the final score will remain the same.
     * 4. Base case: If the final score is 0, then return 1.
     * 5. Base case: If the final score is less than 0 or we have reached the end of the plays, then return 0.
     *
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     */

    public static int countRec(int n,int i,int[] points){

        if(n==0) return 1;
        if(n<0 || i==points.length) return 0;

        int take= countRec(n-points[i],i,points);
        int skip= countRec(n,i+1,points);
        return take+skip;
    }


    /**
     * Approach: Dynamic Programming: Tabulation
     * 1. Create a 2D array dp[scores.length][finalScore+1]
     * 2. dp[i][j] represents the number of ways to reach the score j using the first i plays.
     * 3. dp[i][j] = dp[i-1][j] + dp[i][j-scores[i-1]]
     * 4. dp[i-1][j] represents the number of ways to reach the score j using the first i-1 plays.
     * 5. dp[i][j-scores[i-1]] represents the number of ways to reach the score j-scores[i-1] using the first i plays.
     *
     * Time Complexity: O(n*finalScore)
     * Space Complexity: O(n*finalScore)
     */

    public static int countNoOfScoreCombinations(int finalScore, int[] scores) {
        int[][] dp = new int[scores.length + 1][finalScore + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= scores.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= finalScore; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= scores[i - 1] ? dp[i][j - scores[i - 1]] : 0);
            }
        }
        return dp[scores.length][finalScore];
    }

}
