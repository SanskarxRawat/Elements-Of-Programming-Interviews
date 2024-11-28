public class FIndMaximumIncreasingDecreasingArray {

    /**
     * A sequence is strictly ascending if each element is greater than its predecessor.
     * Suppose it is known that an array A consists of a strictly ascending sequence
     * followed by a strictly descending sequence. Design an algorithm for finding
     * the maximum element in A
     */

    /**
     * Time Complexity: O(log(n))
     *
     */
    static int findMaximum(int[] arr) {
        int n = arr.length;
        int lo = 0;
        int hi = n - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            // If mid index value is maximum
            if(arr[mid] > arr[mid + 1] &&
                    arr[mid] > arr[mid - 1])
                return arr[mid];

                // Reducing search space by moving to right
            else if (arr[mid] < arr[mid + 1])
                lo = mid + 1;

                // Reducing search space by moving to left
            else
                hi = mid - 1;
        }

        return arr[hi];
    }
}
