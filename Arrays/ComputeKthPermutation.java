import java.util.ArrayList;
import java.util.List;

public class ComputeKthPermutation {


    /**
     * Explanation:
     * 1. The function `getPermutation()` calculates the k-th permutation of a given array.
     * 2. We maintain a list of the elements from the input array.
     * 3. We start by calculating the factorial of the length of the array.
     * 4. To calculate the permutation, we reduce the problem by iteratively finding the appropriate element using the `index` and updating `k` accordingly.
     *
     * For example, with array `[1, 2, 3]` and `k = 5`, the k-th permutation is `"312"`.
     */

    /**
     * Time Complexity:
     * - The time complexity of this solution is O(n^2), where n is the length of the input array.
     * - This is because we iterate through the array `n` times, and in each iteration, we remove an element from the list, which takes O(n) time in the worst case.
     *
     * Space Complexity:
     * - The space complexity is O(n), where n is the length of the input array.
     * - This is due to the storage of the elements in the list `numbers`.
     */

    public static String getPermutation(int[] array, int k) {
        List<Integer> numbers = new ArrayList<>();
        for (int num : array) {
            numbers.add(num);
        }

        int n = array.length;
        k--; // To convert k to zero-based index
        StringBuilder result = new StringBuilder();
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        for (int i = n; i > 0; i--) {
            factorial /= i;
            int index = k / factorial;
            result.append(numbers.get(index));
            numbers.remove(index);
            k %= factorial;
        }

        return result.toString();
    }
}
