public class FindClosestEntriesInSortedArrays {

    /**
     * Design an algorithm that takes three sorted arrays and returns one entry from each
     * such that the minimum interval containing these three entries is as small as possible.
     * For example, if the three arrays are (5,10,15), (3,6,9,12,15), and (8,16,24), then
     * 15,15,16 he in the smallest possible interval.
     */


    /**
     * Approach:
     *  1. Two Pointer Approach
     *
     * Time Complexity: O(p+q+r) where p,q,r are the lengths of the three arrays.
     * Space Complexity: O(1)
     */

    public static int[] findClosest(int[] A,int[] B,int[] C){

        int diff=Integer.MAX_VALUE;

        int res_i=0,res_j=0,res_k=0;

        int i=0,j=0,k=0;

        while(i<A.length && j<B.length && k<C.length){

            int minimum=Math.min(A[i],Math.min(B[j],C[k]));
            int maximum=Math.max(A[i],Math.max(B[j],C[k]));

            if(maximum-minimum<diff){
                diff=maximum-minimum;
                res_i=i;
                res_j=j;
                res_k=k;
            }

            if(diff==0) break;

            if(A[i]==minimum) i++;
            else if(B[j]==minimum) j++;
            else k++;
        }
        return new int[]{A[res_i],B[res_j],C[res_k]};
    }

    /**
     * Approach:
     *  1. Binary Search Approach
     *
     * Time Complexity: O(nlog(n)) where p,q,r are the lengths of the three arrays.
     * Space Complexity: O(1)
     */

    public static void findClosest(int[] A, int[] B, int[] C, int p, int q, int r) {

        int diff = Integer.MAX_VALUE; // Initialize min diff

        // Initialize result
        int res_i = 0, res_j = 0, res_k = 0;

        // Traverse arrays
        int i = 0, j = 0, k = 0;
        while (i < p && j < q && k < r) {
            // Find minimum and maximum of current three elements
            int minimum = Math.min(A[i], Math.min(B[j], C[k]));
            int maximum = Math.max(A[i], Math.max(B[j], C[k]));

            // Calculate the maximum difference for the current combination
            int curDiff = Math.abs(maximum - minimum);

            // Update result if current diff is less than the min
            // diff so far
            if (curDiff < diff) {
                res_i = i;
                res_j = j;
                res_k = k;
                diff = curDiff;
            }

            // If the maximum element of A is the smallest among the three,
            // we move the A pointer forward
            if (A[i] == minimum && A[i] <= B[j] && A[i] <= C[k])
                i++;

                // If the maximum element of B is the smallest among the three,
                // we move the B pointer forward
            else if (B[j] == minimum && B[j] <= A[i] && B[j] <= C[k])
                j++;

                // If the maximum element of C is the smallest among the three,
                // we move the C pointer forward
            else
                k++;
        }
    }

}
