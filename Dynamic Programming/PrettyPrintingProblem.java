import java.util.Arrays;
import java.util.List;

public class PrettyPrintingProblem {


    /**
     * Given text, i.e., a string of words separated by single blanks, decompose the text into
     * lines such that no word is split across lines and the messiness of the decomposition
     * is minimized. Each line can hold no more than a specified number of characters.
     */


    /**
     * Approach:
     * Use Dynamic Programming to minimize the messiness of the decomposition.
     * Define messiness as the sum of the squares of the leading blanks at the end of each line.
     * - Let dp[i] denote the minimum messiness for arranging the first i words.
     * - For each word j, calculate the messiness for placing words j to i on the same line and
     *  update dp[i] by considering the minimum value.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     * (n = number of words)
     */

    public static int minimizeMessiness(List<String> words, int maxWidth) {
        int n = words.size();
        int[] dp = new int[n + 1]; // dp[i] represents the minimum messiness up to the i-th word
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // No messiness when no words are placed

        for (int j = 1; j <= n; j++) { // End of the line at word j
            int currentLength = 0;
            for (int i = j; i > 0; i--) { // Start of the line at word i
                currentLength += words.get(i - 1).length(); // Add the length of the word
                if (j > i) {
                    currentLength++; // Add the space between words
                }
                if (currentLength > maxWidth) {
                    break; // If the line length exceeds maxWidth, it’s not valid
                }

                int remainingSpaces = maxWidth - currentLength; // Spaces left in the line
                dp[j] = Math.min(dp[j], dp[i - 1] + remainingSpaces * remainingSpaces);
            }
        }
        return dp[n];
    }
}
