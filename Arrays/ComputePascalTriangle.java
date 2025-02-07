import java.util.ArrayList;
import java.util.List;

public class ComputePascalTriangle {


    /**
     * Intuition:
     * - Pascal's Triangle starts with a single element at the top (1).
     * - Each subsequent row is constructed using the values of the row above it.
     * - Specifically, each element in a row is the sum of the two elements directly above it
     * (one to the left and one to the right). If there is no element (outside the bounds of the row),
     * it is considered to be 0.
     * - Using this property, the triangle can be constructed iteratively by adding 1 at the edges
     * and computing intermedidate values based on the above row.
     * <p>
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     */

    public static List<List<Integer>> computePascalTriangle(int numberOfRows) {

        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for (int i = 0; i < numberOfRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add((0 < j && j < i) ? pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j) : 1);
            }
            pascalTriangle.add(row);
        }

        return pascalTriangle;
    }
}
