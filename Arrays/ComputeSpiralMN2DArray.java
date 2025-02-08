import java.util.ArrayList;
import java.util.List;

public class ComputeSpiralMN2DArray {

    /**
     * Compute the spiral order for an m X n 2D array A
     * <p>
     * Intuition:
      * - The idea is to traverse the matrix layer by layer in a clockwise manner.
     * - Each layer is defined by four boundaries: top, bottom, left, and right.
     * - Starting from the outermost layer, we iterate through the rows and columns of the matrix in the following order:
     * 1. Traverse the top row from the current left boundary to the right boundary.
     * 2. Traverse the right column from the current top boundary to the bottom boundary.
     * 3. Traverse the bottom row from the current right boundary to the left boundary (if still within bounds).
     * 4. Traverse the left column from the current bottom boundary to the top boundary (if still within bounds).
     * - After traversing a layer, the boundaries are updated to move inward to the next layer.
     * - The process continues until all elements in the matrix have been traversed.
     *
     * Time Complexity: O(m * n) - Every element is visited once in the spiral order traversal.
     * Space Complexity: O(m * n) - The result list requires space to store all the elements of the matrix.
     */
    public static List<Integer> computeSpiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
