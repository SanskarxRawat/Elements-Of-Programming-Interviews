import java.util.ArrayList;
import java.util.List;

public class NthRowPascalTriangle {

    /**
     * Intuition:
     * - The N-th row of Pascal's Triangle can be generated using combinations (nCr).
     * - Start with the first element (nC0), which is always 1.
     * - Each subsequent element is derived from the previous one using the relation:
     * nCr = (nCr-1 * (n - r + 1)) / r
     * - This approach eliminates the need to calculate factorials multiple times,
     * reducing the computational complexity.
     *
     * Print the N-th row of the Pascal's Triangle
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */


    static List<Integer> generateNthrow(int n) {
        List<Integer> res = new ArrayList<>();

        // nC0 = 1
        int prev = 1;
        res.add(prev);

        for (int i = 1; i <= n; i++) {

            // nCr = (nCr-1 * (n - r + 1))/r
            int curr = (prev * (n - i + 1)) / i;
            res.add(curr);
            prev = curr;
        }
        return res;
    }
}
