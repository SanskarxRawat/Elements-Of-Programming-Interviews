import java.util.Collections;
import java.util.List;

    /**
     * Intuition:
     * - To find the next permutation, we need to identify the first decreasing element from the end.
     * - By swapping this element with the smallest greater element to its right, we create a larger permutation.
     * - Reversing the suffix to the right of this element gives the smallest order, ensuring we find the next permutation.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
public class ComputeTheNextPermutation {

    public static List<Integer> nextPermutation(List<Integer> permutation) {
        int k = permutation.size() - 2;


        while (k >= 0 && permutation.get(k) >= permutation.get(k + 1)) {
            k--;
        }

        if (k == -1) {
            return Collections.emptyList();
        }


        for (int i = permutation.size() - 1; i > k; i--) {
            if (permutation.get(i) > permutation.get(k)) {
                Collections.swap(permutation, k, i);
                break;
            }
        }

        Collections.reverse(permutation.subList(k + 1, permutation.size()));

        return permutation;
    }
}
