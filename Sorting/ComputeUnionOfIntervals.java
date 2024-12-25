import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComputeUnionOfIntervals {

    /**
     * Design an algorithm that takes as input a set of intervals, and outputs their union
     * expressed as a set of disjoint intervals.
     */

    /**
     * Time complexity: O(n log n)
     * Space complexity: O(n)
     */


    public static List<int[]> mergeIntervals(int[][] intervals) {
        // Step 1: Sort the intervals by start time
        List<int[]> intervalList = new ArrayList<>();
        Collections.addAll(intervalList, intervals);

        intervalList.sort(Comparator.comparingInt(a -> a[0]));

        // Step 2: Initialize a list to store merged intervals
        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervalList) {
            // If merged is empty or there is no overlap, add the interval
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Merge the current interval with the last one in merged
                merged.get(merged.size() - 1)[1] =
                        Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged;
    }
}
