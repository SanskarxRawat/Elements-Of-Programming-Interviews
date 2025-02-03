import java.util.Arrays;

public class ScheduleToMinimizeWaitTime {


    /**
     *Given service times for a set of queries, compute a schedule for processing the queries
     * that minimizes the total waiting time. Return the minimum waiting time. For
     * example, if the service times are (2,5,1,3), if we schedule in the given order, the total
     * waiting time is0+(2)+(2+5)+(2+5+l) = 17. If however,weschedule queries in order
     * of decreasing service times, the total waiting time is 0 + (5) + (5 + 3) + (5 + 3+ 2) = 23.
     * As we will see, for this example, the minimum waiting time is 10
     */


    /**
     * Approach:
     *
     * 1. Sort the service times in ascending order.
     * 2. Initialize a variable to hold the total waiting time.
     * 3. Iterate through the sorted list, for each service time, multiply it by
     * the number of queries remaining after it, and add the result to the total waiting time.
     * 4. Return the total waiting time.
     *
     *  Time Complexity:
     * - Sorting the array takes O(n log n).
     * - Iterating through the array takes O(n).
     * - Overall: O(n log n).
     *
     * Space Complexity:
     * - Sorting the array in-place uses O(1) additional space.
     * - Overall: O(1).
     */

    public static int minimumWaitingTime(int[] serviceTimes) {
        Arrays.sort(serviceTimes);
        int totalWaitingTime = 0;
        int n = serviceTimes.length;
        for (int i = 0; i < n - 1; i++) {
            int remainingQueries = n - i - 1;
            totalWaitingTime += serviceTimes[i] * remainingQueries;
        }
        return totalWaitingTime;
    }
}
