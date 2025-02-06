import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class TransformOneStringToAnother {


    /**
     * Given a dictionary D and two strings s and f, write a program to determine if s
     * produces f. Assume that all characters are lowercase alphabets. If s does produce f,
     * output the length of a shortest production sequence; otherwise, output -1.
     * <p>
     * Approach:
     * 1. Model the problem as a shortest path in an unweighted graph.
     * - Each word in the dictionary D is a node.
     * - An edge exists between two nodes if one word can be transformed into another by
     * changing exactly one character.
     * 2. Perform a Breadth-First Search (BFS) starting from `s` to find the shortest path to `f`.
     * <p>
     * Time Complexity: O(N * M^2), where N is the size of the dictionary and M is the length of the words.
     * Space Complexity: O(N * M), due to storing words and graph traversal.
     */
    public static int transformString(Set<String> dictionary, String s, String f) {
        if (s.equals(f)) {
            return 0;
        }
        if (!dictionary.contains(f)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        dictionary.remove(s);
        int transformations = 0;

        while (!queue.isEmpty()) {
            transformations++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                for (String neighbor : getValidTransformations(currentWord, dictionary)) {
                    if (neighbor.equals(f)) {
                        return transformations;
                    }
                    queue.add(neighbor);
                    dictionary.remove(neighbor);
                }
            }
        }
        return -1;
    }

    private static List<String> getValidTransformations(String word, Set<String> dictionary) {
        List<String> transformations = new ArrayList<>();
        char[] wordChars = word.toCharArray();
        for (int i = 0; i < wordChars.length; i++) {
            char originalChar = wordChars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) continue;
                wordChars[i] = c;
                String transformedWord = new String(wordChars);
                if (dictionary.contains(transformedWord)) {
                    transformations.add(transformedWord);
                }
            }
            wordChars[i] = originalChar;
        }
        return transformations;
    }



    
}
