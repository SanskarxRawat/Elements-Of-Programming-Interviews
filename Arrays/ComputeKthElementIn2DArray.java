public class ComputeKthElementIn2DArray {

    /**
     * Time Complexity: O(c) c is outer circular rings with respect to k
     * Space Complexity: O(1)
     * <p>
     * Intuition:
     * - The problem is approached as a layer-by-layer traversal of a 2D array in a spiral order.
     * - For any given element `k`, it may either belong to the outermost layer or a deeper, inner layer.
     * - We check `k` sequentially for each segment of the current spiral layer (top row, right column,
     * bottom row, and left column). If `k` is found within the bounds of the layer, we compute
     * its position directly.
     * - If `k` is not in the current layer, we use recursion to process the next inner layer.
     * - The recursive call reduces the problem to a smaller sub-matrix by slicing off the outer layer
     * and decrementing `k` by the number of elements in the removed layer.
     */
    static int findK(int A[][], int i, int j, int n, int m, int k) {
        if (n < 1 || m < 1)
            return -1;

        /*.....If element is in outermost ring ....*/
        /* Element is in first row */
        if (k <= m)
            return A[i + 0][j + k - 1];

        /* Element is in last column */
        if (k <= (m + n - 1))
            return A[i + (k - m)][j + m - 1];

        /* Element is in last row */
        if (k <= (m + n - 1 + m - 1))
            return A[i + n - 1][j + m - 1 - (k - (m + n - 1))];

        /* Element is in first column */
        if (k <= (m + n - 1 + m - 1 + n - 2))
            return A[i + n - 1 - (k - (m + n - 1 + m - 1))][j + 0];

        /*.....If element is NOT in outermost ring ....*/
        /* Recursion for sub-matrix. &A[1][1] is
        address to next inside sub matrix.*/
        return findK(A, i + 1, j + 1, n - 2,
                m - 2, k - (2 * n + 2 * m - 4));
    }
}
