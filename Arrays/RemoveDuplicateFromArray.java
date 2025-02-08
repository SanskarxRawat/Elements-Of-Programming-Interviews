import java.util.List;

public class RemoveDuplicateFromArray {


    /**
     * This method removes duplicates from a sorted list such that each unique element appears only once.
     *
     * Intuition:
     * - In a sorted list, all duplicates of an element are grouped together.
     * - Use a writeIndex pointer to track the position where the next unique element should be placed.
     * - Start iterating through the list from the second element (index 1).
     * - Compare the current element with the element at the position before the writeIndex.
     * - If they are different, a new unique element is found, and it is written to the writeIndex position.
     * - Increment writeIndex to move to the next position for storing the next unique element.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static int removeDuplicates(List<Integer> A) {

        if (A.isEmpty()) {
            return 0;
        }

        int writeIndex = 1;

        for (int index = 1; index < A.size(); index++) {
            if (!A.get(index).equals(A.get(writeIndex))) {
                A.set(writeIndex++, A.get(index));
            }
        }

        return writeIndex;
    }

    /**
     * This method removes all occurrences of a specific key from an array.
     * <p>
     * Intuition:
     * - Use a writeIndex pointer to track the position where the next valid element should be placed.
     * - Iterate through the array, and check each element.
     * - If the current element is not equal to the key, write it to the writeIndex position.
     * - Increment the writeIndex pointer for subsequent valid elements.
     * - Elements equal to the key are effectively skipped by not writing them.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static int removeKey(int[] arr, int key) {
        int writeIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[writeIndex] = arr[i];
                writeIndex++;
            }
        }

        return writeIndex;
    }

    /**
     * This method updates an array to allow each unique element to appear at most min(2, m) times.
     * <p>
     * Intuition:
     * - Use a writeIndex pointer to track where the next valid element should be written.
     * - Maintain a count to track the number of times the current element has been encountered consecutively.
     * - Iterate through the array, starting from the second element:
     * - If the current element is the same as the previous one, increment the count.
     * - Otherwise, reset the count to 1 for the new element.
     * - Write the current element to the writeIndex position if it appears less than or equal to min(2, m) times.
     * - Handle the last element separately to ensure it is considered.
     * - Return the writeIndex, which represents the number of remaining valid elements.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static int updateArray(int[] arr, int m) {
        int writeIndex = 0;
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= Math.min(2, m)) {
                arr[writeIndex] = arr[i - 1];
                writeIndex++;
            }
        }

        if (count <= Math.min(2, m)) {
            arr[writeIndex] = arr[arr.length - 1];
            writeIndex++;
        }

        return writeIndex;
    }
}
