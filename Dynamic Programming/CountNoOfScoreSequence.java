public class CountNoOfScoreSequence {

    /**
     * Write a program that takes a final score and scores for individual plays, and
     * returns the number of sequences of plays that result in the final score. For example,
     * 18 sequences of plays yield a score of 12. Some examples are (2, 2, 2, 3, 3), (2,3, 2, 2, 3),
     * (2,3, 7), (7, 3, 2).
     */


    public static int countSequences(int finalScore, int[] playScores) {
        // Create a DP array to store the number of ways to achieve each score
        int[] dp = new int[finalScore + 1];
        dp[0] = 1; // There's one way to make a score of 0 (no plays)

        // For each play score, update the DP table
        for (int score : playScores) {
            for (int currentScore = score; currentScore <= finalScore; currentScore++) {
                dp[currentScore] += dp[currentScore - score];
            }
        }

        return dp[finalScore];
    }

    public static void main(String[] args) {
        int finalScore = 12;
        int[] playScores = {2, 3, 7};

        int sequencesCount = countSequences(finalScore, playScores);
        System.out.println("The number of sequences that yield a score of " + finalScore + " is: " + sequencesCount);
    }
}
