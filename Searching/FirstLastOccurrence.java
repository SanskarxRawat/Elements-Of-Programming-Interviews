public class FirstLastOccurrence {

    /**
     * int arr[] = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };
     *         int n = arr.length;
     *         int x = 8;
     *         int[] ans = { -1, -1 };
     *         // For first occurrence
     *         ans[0] = search(arr,x, true);
     *         if (ans[0] != -1) {
     *             // For last occurrence
     *             ans[1] = search(arr, x, false);
     *         }
     *
     *    Time Complexity: O(log(n))
     *    Space Complexity: O(1)
     */
    static int search(int[] nums, int target,boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            // find the middle element
            // int mid = (start + end) / 2;
            //  might be possible that (start + end)
            //  exceeds the range of int in  java
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            }
            else if (target > nums[mid]) {
                start = mid + 1;
            }
            else {
                // potential ans found
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
        }

        return ans;
    }
}
