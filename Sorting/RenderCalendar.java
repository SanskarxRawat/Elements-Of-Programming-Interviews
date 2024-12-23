import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RenderCalendar {

    /**
     * Write a program that takes a set of events, and determines the maximum number of
     * events that take place concurrently.
     */

    /**
     * Time Complexity: O(NlogN)
     * Space Complexity: O(N)
     */

    static class TimePoint implements Comparable<TimePoint> {
        int time;
        int type; // 1 for start, -1 for end

        TimePoint(int time, int type) {
            this.time = time;
            this.type = type;
        }

        // Sort first by time, then by type (end before start if times are equal)
        @Override
        public int compareTo(TimePoint other) {
            if (this.time == other.time) {
                return this.type - other.type; // End (-1) before start (+1)
            }
            return this.time - other.time;
        }
    }

    public static int findMaxConcurrentEvents(int[][] events) {
        List<TimePoint> timePoints = new ArrayList<>();

        // Convert events into time points
        for (int[] event : events) {
            timePoints.add(new TimePoint(event[0], 1)); // Start time
            timePoints.add(new TimePoint(event[1], -1)); // End time
        }

        // Sort time points
        Collections.sort(timePoints);

        // Sweep line to calculate maximum concurrent events
        int maxConcurrent = 0;
        int currentConcurrent = 0;

        for (TimePoint tp : timePoints) {
            currentConcurrent += tp.type; // Increment or decrement based on type
            maxConcurrent = Math.max(maxConcurrent, currentConcurrent);
        }

        return maxConcurrent;
    }
}
