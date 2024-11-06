import java.util.List;

public class Compute2DFromSpiral {

    // Variant 1: Given a sequence of integers P, compute a 2D array A whose spiral order is P
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
