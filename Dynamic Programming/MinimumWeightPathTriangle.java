import java.util.Arrays;
import java.util.List;

public class MinimumWeightPathTriangle {


    /**
     * Write a program that takes as input a triangle of numbers and returns the weight of
     * a minimum weight path. For example, the minimum weight path for the number.
     */


    /**
     * Approach : Brute Force
     *
     * 1. Calculate all the paths and choose the minium one.
     *
     *
     * Optimal Approach: Dynamic Programming
     *
     * 1. Start from the second-to-last row of the triangle and move upwards.
     * 2. For each element, calculate the sum of the current element and the minimum of the two adjacent elements in the row below.
     * 3. Update the element in place with the calculated value.
     * 4. The minimum weight path is stored in the top element after processing all rows.
     *
     */

    public static int minimumWeight(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }

        // Start from the second-to-last row, moving upwards
        for (int row = triangle.size() - 2; row >= 0; row--) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                // Update the current element with the sum of itself and the minimum of the two adjacent elements from the row below
                triangle.get(row).set(col, triangle.get(row).get(col)
                        + Math.min(triangle.get(row + 1).get(col), triangle.get(row + 1).get(col + 1)));
            }
        }

        // The top element now contains the minimum weight path
        return triangle.get(0).get(0);
    }


}
