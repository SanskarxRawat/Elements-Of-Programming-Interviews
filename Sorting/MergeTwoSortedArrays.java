public class MergeTwoSortedArrays {

    /**
     * Write a program which takes as input two sorted arrays of integers, and updates the
     * first to the combined entries of the two arrays in sorted order. Assume the first array
     * has enough empty entries at its end to hold the result.
     */

    /**
     * Time Complexity: O(n+m)
     * Space Complexity: O(1)
     */

    public static void mergeTwoSortedArrays(int[] A, int m, int[] B, int n) {

        int a = m-1, b = n-1, writeIdx = m+n-1;

        while(a >= 0 && b >= 0){
            A[writeIdx--] = A[a] > B[b] ? A[a--] : B[b--];
        }

        while(b >= 0){
            A[writeIdx--] = B[b--];
        }
    }
}
