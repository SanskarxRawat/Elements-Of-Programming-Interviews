public class FirstOccurrenceOfK {


    /**
     * Time Complexity: O(log(n))
     */
    public static int firstK(int[] arr,int target){

        int left=0,right=arr.length-1,result=-1;


        while(left<=right){

            int mid=left+((right-left)/2);

            if(arr[mid]>target){
                right=mid-1;
            }else if(arr[mid]==target){
                result=mid;
                right=mid-1;
            }else{ // A .get (mid) < k
                left = mid + 1;
            }
        }

        return result;
    }

    public static int findFirstGreater(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        int result = -1; // To store the index of the first element greater than key

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > key) {
                result = mid; // Update result, as this is a potential candidate
                high = mid - 1; // Narrow the search to the left half
            } else {
                low = mid + 1; // Narrow the search to the right half
            }
        }

        return result; // Return the index of the first greater element, or -1 if not found
    }
}
