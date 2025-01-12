import java.util.ArrayList;
import java.util.List;

public class GeneratePalindromeDecomposition {

    /**
     * Compute all palindromic decompositions of a given string. For example, if the string
     * is "0204451881", then the decomposition "020", "44", "5", "1881" is palindromic, as
     * is "020", "44", "5", "1", "88", "1". However, "02044, "5", "1881" is not a palindromic
     * decomposition.
     *
     * Approach: Recursive
     * 1. For each prefix of the string, check if it is a palindrome.
     * 2. If it is a palindrome, add it to the current decomposition and recursively generate
     * palindromic decompositions for the remaining string.
     *
     *  Time Complexity: O(n*2^n)
     *  Space Complexity: O(n)
     */


    public static List<List<String>> palindromeDecompositions(String input) {
        List<List<String>> result = new ArrayList<>();
        palindromeDecompositions(input, 0, new ArrayList<>(), result);
        return result;
    }

    public static void palindromeDecompositions(String input, int index, List<String> currentDecomposition, List<List<String>> result) {
        if (index == input.length()) {
            result.add(new ArrayList<>(currentDecomposition));
            return;
        }
        for (int i = index + 1; i <= input.length(); i++) {
            String prefix = input.substring(index, i);
            if (isPalindrome(prefix)) {
                currentDecomposition.add(prefix);
                palindromeDecompositions(input, i, currentDecomposition, result);
                currentDecomposition.remove(currentDecomposition.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
