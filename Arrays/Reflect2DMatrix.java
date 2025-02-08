public class Reflect2DMatrix {

    // Reflect matrix about horizontal axis

    /**
     * Intuition:
     * - Reflecting a matrix about the horizontal axis involves flipping rows
     * symmetrically around the middle row. The first row swaps with the last,
     * the second swaps with the second last, and so on.
     */
    public static void reflectHorizontal(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = temp;
        }
    }

    // Reflect matrix about vertical axis

    /**
     * Intuition:
     * - Reflecting a matrix about the vertical axis involves flipping columns
     * symmetrically around the middle column. Elements from the left-most
     * column swap with the right-most column, continuing inward.
     */
    public static void reflectVertical(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    // Reflect matrix about diagonal from top-left to bottom-right

    /**
     * Intuition:
     * - Reflecting a matrix across the top-left to bottom-right diagonal involves transposing
     * the matrix. Elements at (i, j) are swapped with elements at (j, i), making rows into
     * columns.
     */
    public static void reflectDiagonalTopLeftBottomRight(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    // Reflect matrix about diagonal from top-right to bottom-left

    /**
     * Intuition:
     * - Reflecting a matrix across the top-right to bottom-left diagonal involves swapping
     * elements in a mirrored manner across the diagonal. Elements at (i, j) swap with
     * elements at (n - j - 1, n - i - 1).
     */
    public static void reflectDiagonalTopRightBottomLeft(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = temp;
            }
        }
    }
}
