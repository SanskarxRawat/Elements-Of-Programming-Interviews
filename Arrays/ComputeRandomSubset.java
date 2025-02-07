import java.util.*;

public class ComputeRandomSubset {

    /**
     * This method generates a random subset of size k from the set {0, 1, ..., n-1}.
     *
     * Intuition:
     * - The problem is solved by mapping elements in a one-to-one way using a hashmap.
     * - Initially, we select elements at random without repeating, avoiding the need to shuffle the entire range of numbers.
     * - At each iteration, we select a random index between the current index and the end of the range.
     * - This index and the current index are mapped to each other in the `changedElements` Map.
     * - Collisions or previously swapped elements are handled by explicitly checking values in the map.
     * - By doing so, we only store the modified indices in the hashmap, ensuring O(k) space.
     * - After k iterations, the first k elements of the map represent the desired random subset.
     *
     *
     * Time Complexity: O(k) - We perform k iterations where each involves constant time operations.
     * Space Complexity: O(k) - The hashmap holds at most k key-value pairs.
     */
    public static List<Integer> randomSubset(int n, int k) {
        Map<Integer, Integer> changedElements = new HashMap<>();


        Random randIdxGen = new Random();

        for (int i = 0; i < k; i++) {
            int randIdx = i + randIdxGen.nextInt(n - i);

            Integer ptr1 = changedElements.get(randIdx);
            Integer ptr2 = changedElements.get(i);

            if (ptr1 == null && ptr2 == null) {
                changedElements.put(randIdx, i);
                changedElements.put(i, randIdx);
            } else if (ptr1 == null && ptr2 != null) {
                changedElements.put(randIdx, ptr2);
                changedElements.put(i, randIdx);
            } else if (ptr1 != null && ptr2 == null) {
                changedElements.put(i, ptr1);
                changedElements.put(randIdx, i);
            } else {
                changedElements.put(i, ptr1);
                changedElements.put(randIdx, ptr2);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            result.add(changedElements.get(i));
        }
        return result;
    }
}
