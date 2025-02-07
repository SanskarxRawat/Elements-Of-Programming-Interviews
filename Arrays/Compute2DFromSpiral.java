import java.util.List;

public class Compute2DFromSpiral {

    /**
     * Variant 1: Given a sequence of integers P, compute a 2D array A whose spiral order is P
     * <p>
     * Intuition:
     * - The problem requires converting a 1D list into a 2D matrix in a spiral order.
     * - To achieve this, divide the matrix into layers (like an onion) and fill each layer iteratively.
     * - Begin with the outermost layer (top row, right column, bottom row, left column) and work inward.
     * - Maintain pointers (`top`, `bottom`, `left`, `right`) to track the current layer boundaries.
     * - Assembling the matrix is accomplished by traversing four directions in order (left-to-right, top-to-bottom,
     * right-to-left, bottom-to-top) and decrementing/incrementing the corresponding boundaries after each pass.
     * - Continue the process until all numbers in the input sequence are placed in the matrix.
     */
    public static int[][] generateMatrixFromSpiralOrder(List<Integer> P) {
        int n = (int) Math.sqrt(P.size());
        int[][] matrix = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int index = 0;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                matrix[top][j] = P.get(index++);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = P.get(index++);
            }
            right--;

            for (int j = right; j >= left; j--) {
                matrix[bottom][j] = P.get(index++);
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = P.get(index++);
            }
            left++;
        }
        return matrix;
    }
}
