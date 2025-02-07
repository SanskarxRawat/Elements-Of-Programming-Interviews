import java.util.ArrayList;
import java.util.List;

public class ComputeRandomPermutation {

    /**
     * This method generates a random permutation of integers from 0 to n-1.
     * <p>
     * Intuition:
     * - Start by creating a list of integers from 0 to n-1 in sequential order.
     * - Shuffle the list randomly using the Fisher-Yates algorithm
     * implemented in the `SamplingOfflineData.randomSampling` method.
     * - The Fisher-Yates algorithm works by iteratively swapping elements with
     * randomly chosen indices, ensuring an unbiased random order.
     * - The result is a random permutation of the list.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static List<Integer> computeRandomPermutations(int n) {

        List<Integer> permutations = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            permutations.add(i);
        }

        SamplingOfflineData.randomSampling(permutations.size(), permutations);
        return permutations;
    }
}
