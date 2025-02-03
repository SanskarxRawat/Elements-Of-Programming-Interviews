import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class MinimizeIntervals {

    /**
     * You are given a set of closed intervals. Design an efficient algorithm for finding a
     * minimum sized set of numbers that covers all the intervals.
     */


    /**
     * Approach:
     *
     * 1. Sort the intervals by their ending points in ascending order. This ensures that 
     *    we consider intervals that end earlier first, minimizing overlap and redundancy.
     *
     * 2. Select the endpoint of the first interval as the first "visited time" since it 
     *    lies within that interval and can cover it.
     *
     * 3. Iterate through the remaining intervals:
     *    - If the starting point of the current interval is greater than the last selected 
     *      "visited time," it means the current interval is not yet covered. Add the 
     *      endpoint of this interval to the list of "visited times" and update the 
     *      "last visited" time.
     *
     * 4. Return the list of "visited times" representing the minimum set of points 
     *    that covers all intervals.
     *
     * Time Complexity:
     * - Sorting the intervals takes O(n log n), where n is the number of intervals.
     * - Iterating through the intervals takes O(n).
     * - Overall: O(n log n).
     *
     * Space Complexity:
     * - O(m), where m is the size of the result list containing the selected points.
     */


    public static List<Integer> findMinimumVisits(int[][] intervals) {
        List<Integer> visitTimes = new ArrayList<>();
        if (intervals.length == 0) {
            return visitTimes;
        }

        // Sort intervals based on their end times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int lastVisit = intervals[0][1];
        visitTimes.add(lastVisit);

        for (int[] interval : intervals) {
            int start = interval[0];
            if (start > lastVisit) {
                lastVisit = interval[1];
                visitTimes.add(lastVisit);
            }
        }

        return visitTimes;
    }
}
