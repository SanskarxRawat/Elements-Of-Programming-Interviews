import java.util.ArrayList;
import java.util.List;

public class EntryEqualToIndex {

    /**
     * Design an efficient algorithm that takes a sorted array of distinct integers, and returns
     * an index i such that the element at index i equals i. For example, when the input is
     * (-2,0, 2, 3, 6, 7, 9) your algorithm should return 2 or 3.
     */


    public static int searchEntryToItsIndex(int[] array){

        int left=0,right=array.length-1;

        while (left<=right){
            int mid=left+((right-left)/2);

            int difference=array[mid]-mid;

            if(difference==0){
                return mid;
            }else if(difference>0){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }

        return -1;
    }

    /**
     * Same Problem but array contains duplicate
     */

    public static List<Integer> searchEntriesEqualToTheirIndex(int[] array) {
        List<Integer> result = new ArrayList<>();

        int left = 0, right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == mid) {
                result.add(mid);

                // Explore both left and right sides of the mid for duplicates
                int tempLeft = mid - 1;
                int tempRight = mid + 1;

                // Check left side
                while (tempLeft >= left && array[tempLeft] == tempLeft) {
                    result.add(tempLeft);
                    tempLeft--;
                }

                // Check right side
                while (tempRight <= right && array[tempRight] == tempRight) {
                    result.add(tempRight);
                    tempRight++;
                }

                // Break after collecting duplicates
                break;

            } else if (array[mid] > mid) {
                // Narrow the search to the left half
                right = mid - 1;
            } else {
                // Narrow the search to the right half
                left = mid + 1;
            }
        }

        return result;
    }
}
