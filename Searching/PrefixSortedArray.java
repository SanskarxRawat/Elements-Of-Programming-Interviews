public class PrefixSortedArray {

    /**
     * For the array {"apple", "banana", "cherry", "date", "fig", "grape"} and prefix "ba":
     *
     * The program checks mid elements and finds "banana" starts with "ba".
     * It returns true.
     */
    public static boolean isPrefix(String[] arr, String p) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            String midValue = arr[mid];

            // Check if p is a prefix of the midValue
            if (midValue.startsWith(p)) {
                return true;
            } else if (midValue.compareTo(p) < 0) {
                // Search in the right half
                low = mid + 1;
            } else {
                // Search in the left half
                high = mid - 1;
            }
        }

        return false; // No match found
    }
}
