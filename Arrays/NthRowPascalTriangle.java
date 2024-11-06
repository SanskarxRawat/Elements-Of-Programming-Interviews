import java.util.ArrayList;
import java.util.List;

public class NthRowPascalTriangle {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    // Print the N-th row of the Pascal's Triangle
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
