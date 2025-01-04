import java.util.ArrayList;
import java.util.List;

public class GeneratePowerSet {

    /**
     * Write a function that takes as input a set and returns its power set.
     */

    /**
     * Approach:
     * 1. Generate all possible subsets of a set.
     * 2. For each element in the set, there are two possibilities, either the element is included in the subset or not included.
     * 3. Recursively generate subsets for the remaining elements.
     * 4. Repeat the above steps until all elements are included/excluded.
     * 5. Time Complexity: O(2^n)
     * 6. Space Complexity: O(n)
     */


    public static List<List<Integer>> generatePowerSet(List<Integer> inputSet) {
        List<List<Integer>> result = new ArrayList<>();
        generatePowerSet(inputSet, 0, new ArrayList<>(), result);
        return result;
    }

    public static void generatePowerSet(List<Integer> inputSet, int index, List<Integer> currentSet, List<List<Integer>> result) {
        if (index == inputSet.size()) {
            result.add(new ArrayList<>(currentSet));
            return;
        }
        currentSet.add(inputSet.get(index));
        generatePowerSet(inputSet, index + 1, currentSet, result);
        currentSet.remove(currentSet.size() - 1);
        generatePowerSet(inputSet, index + 1, currentSet, result);
    }


    /**
     * Bitwise Approach
     * 1. Generate all possible subsets of a set using bitwise operations.
     * Time Complexity:
     */

    public static List<List<Integer>> generatePowerSetBitwise(List<Integer> inputSet) {
        List<List<Integer>> result = new ArrayList<>();
        int n = inputSet.size();
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    subset.add(inputSet.get(j));
                }
            }
            result.add(subset);
        }
        return result;
    }
}
