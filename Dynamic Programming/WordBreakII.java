import java.util.*;

public class WordBreakII {

    /**
     * Given a dictionary i.e., a set of strings, and a name, design an efficient algorithm that
     * checks whether the name is the concatenation of a sequence of dictionary words. If
     * such a concatenation exists, return it. A dictionary word may appear more than once
     * in the sequence, e.g., "a", "man", "a", "plan", "a", "canal" is a valid sequence for
     * "amanaplanacanal".
     */


    /**
     * Approach: Brute Force
     *
     *
     *  Recursive Function:
     * Start from the beginning of the string.
     * For each position i, check if the substring name[0:i] is in the dictionary.
     * If it is, recursively check the remaining substring name[i:].
     * If the entire string can be decomposed, return the sequence of words.
     *
     *
     * Time Complexity: O(2^n)
     * Space Complexity: O(n) due to recursive call stack
     */

        public List<String> wordBreak(String s, List<String> dict) {
            if (s == null || s.isEmpty()) {
                return new ArrayList<>();
            }
            // Convert dict to a Set for O(1) lookups
            Set<String> dictionary = new HashSet<>(dict);
            return breakWord(s, dictionary, new HashMap<>());
        }

        private List<String> breakWord(String s, Set<String> dict, Map<String, List<String>> memo) {
            if (memo.containsKey(s)) {
                return memo.get(s);
            }
            List<String> res = new ArrayList<>();
            if (s.isEmpty()) {
                res.add(""); // Base case: valid split with no remaining string
                return res;
            }
            for (int i = 1; i <= s.length(); i++) {
                String prefix = s.substring(0, i);
                if (dict.contains(prefix)) {
                    List<String> suffixes = breakWord(s.substring(i), dict, memo); // Pass the SAME memo
                    for (String suffix : suffixes) {
                        res.add(prefix + (suffix.isEmpty() ? "" : " ") + suffix);
                    }
                }
            }
            memo.put(s, res);
            return res;
        }


}
