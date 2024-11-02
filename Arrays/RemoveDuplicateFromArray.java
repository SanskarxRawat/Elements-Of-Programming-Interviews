import java.util.List;

public class RemoveDuplicateFromArray {


    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static int removeDuplicates(List<Integer> A) {

        if(A.isEmpty()){
            return 0;
        }

        int writeIndex=1;

        for(int index=1; index<A.size(); index++){
            if(!A.get(index).equals(A.get(writeIndex))){
                A.set(writeIndex++, A.get(index));
            }
        }

        return writeIndex;
    }

    public static int removeKey(int[] arr, int key) {
        // Index to keep track of where to place the next valid element
        int writeIndex = 0;

        // Iterate through each element in the array
        for (int i = 0; i < arr.length; i++) {
            // If the element is not equal to the key, write it to the writeIndex position
            if (arr[i] != key) {
                arr[writeIndex] = arr[i];
                writeIndex++;
            }
        }

        // Return the number of remaining elements
        return writeIndex;
    }


    public static int updateArray(int[] arr, int m) {
        // Index to keep track of where to place the next valid element
        int writeIndex = 0;
        int count = 1;

        // Iterate through each element in the array, starting from the second element
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            // Write the element if it appears less than or equal to min(2, m) times
            if (count <= Math.min(2, m)) {
                arr[writeIndex] = arr[i - 1];
                writeIndex++;
            }
        }

        // Handle the last element
        if (count <= Math.min(2, m)) {
            arr[writeIndex] = arr[arr.length - 1];
            writeIndex++;
        }

        // Return the number of remaining elements
        return writeIndex;
    }
}
