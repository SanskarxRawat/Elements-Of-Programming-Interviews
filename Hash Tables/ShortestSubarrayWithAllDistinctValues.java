import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShortestSubarrayWithAllDistinctValues {

    /**
     * Given an array A, find a shortest subarray A[i : j] such that each distinct
     * value present in A is also present in the subarray.
     */

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(d) , no of distinct elements
     */

    public static int[] findShortestSubarray(int[] A) {
        // Step 1: Find all distinct elements in the array
        Set<Integer> distinctValues = new HashSet<>();
        for (int num : A) {
            distinctValues.add(num);
        }

        int totalDistinct = distinctValues.size();
        Map<Integer, Integer> countMap = new HashMap<>();
        int remaining = totalDistinct;

        int left = 0, minLength = Integer.MAX_VALUE;
        int start = -1, end = -1;

        // Step 2: Sliding window to find the shortest subarray
        for (int right = 0; right < A.length; ++right) {
            // Add current element to the window
            int count = countMap.getOrDefault(A[right], 0);
            countMap.put(A[right], count + 1);

            if (count == 0) {
                remaining--; // A new distinct element is covered
            }

            // Shrink the window from the left as much as possible
            while (remaining == 0) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                    end = right;
                }

                // Remove the leftmost element
                countMap.put(A[left], countMap.get(A[left]) - 1);
                if (countMap.get(A[left]) == 0) {
                    remaining++; // A distinct element is no longer covered
                }
                left++;
            }
        }

        return new int[]{start, end}; // Return the indices of the shortest subarray
    }

}
