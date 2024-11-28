public class LocalMinima {

    /**
     * Let A be an unsorted array of n integers, with A[0] > A[l] and A[n - 2] <
     * A[n -1]. Call an index i a local minimum if A[i] is less than or equal to its neighbors.
     * How would you efficiently find a local minimum, if one exists?
     */

    public static int localMinima(int[] nums){
        if(nums.length == 1) return 0;

        int n = nums.length;

        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        int start = 1;
        int end = n-2;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]) return mid;
            else if(nums[mid] > nums[mid-1]) end = mid - 1;
            else if(nums[mid] > nums[mid+1]) start = mid + 1;
        }
        return -1;
    }
}
