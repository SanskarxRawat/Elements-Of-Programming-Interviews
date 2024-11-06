public class ComputeKthElementIn2DArray {

    /**
     * Time Complexity: O(c) c is outer circular rings with respect to k
     * Space Complexity: O(1)
     *
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
