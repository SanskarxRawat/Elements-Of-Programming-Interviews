import java.util.List;

public class SearchInCyclicallySorted {

    /**
     * Design an 0(log n) algorithm for finding the position of an element k in a
     * cyclically sorted array of distinct elements.
     *
     *
     * Time Complexity: O(log(n))
     */
    public static int pivotedSearch(List<Integer> arr, int key) {
        int low = 0, high = arr.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Case 1: Find key
            if (arr.get(mid) == key)
                return mid;

            // Case 2: Left half is sorted
            if (arr.get(mid) >= arr.get(low)) {
                if (key >= arr.get(low) && key < arr.get(mid))
                    high = mid - 1;
                else
                    low = mid + 1;
            }

            // Case 3: Right half is sorted
            else {
                if (key > arr.get(mid) && key <= arr.get(high))
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return -1; // Key not found
    }
}
