public class SearchCyclicSortedArray {

    /**
     * Design an O(log n) algorithm for finding the position of the smallest element in a
     * cyclically sorted array. Assume all elements are distinct.
     */

    /**
     * Time Complexity: O(log(n))
     *
     */

    private static int searchSmallest(int[] arr) {

        int left = 0, right = arr.length - 1;


        while (left < right) {

            int mid = left + ((right - left) / 2);
            if (arr[mid] > arr[right]) {
                // Minimum must be in A.subList(mid + 1, right + 1).
                left = mid + 1;
            } else { // A.get(mid) < A .get (right) .
                // Minimum cannot be in A .subList(mid + 1, right + 1) so it must be in
                // A .sublist(left , mid + 1).
                right = mid;
            }
        }
        return left;
    }
}
