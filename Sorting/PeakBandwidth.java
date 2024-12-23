import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PeakBandwidth {

    /**
     * Users 1,2,...,n share an Internet connection. User i uses bj bandwidth from
     * time Sj to f, inclusive. What is the peak bandwidth usage?
     */


    /**
     * Time Complexity: O(n*log(n))
     * Space Complexity: O(n)
     */


    // Class to represent a time point with its bandwidth change
    static class TimePoint implements Comparable<TimePoint> {
        int time;
        int bandwidthChange;

        TimePoint(int time, int bandwidthChange) {
            this.time = time;
            this.bandwidthChange = bandwidthChange;
        }

        // Sort by time, then by bandwidthChange (end before start for same time)
        @Override
        public int compareTo(TimePoint other) {
            if (this.time == other.time) {
                return this.bandwidthChange - other.bandwidthChange;
            }
            return this.time - other.time;
        }
    }

    public static int findPeakBandwidthUsage(int[][] users) {
        List<TimePoint> timePoints = new ArrayList<>();

        // Convert each user's usage into time points
        for (int[] user : users) {
            int start = user[0];
            int end = user[1];
            int bandwidth = user[2];

            // Add start and end points
            timePoints.add(new TimePoint(start, bandwidth)); // Start adds bandwidth
            timePoints.add(new TimePoint(end + 1, -bandwidth)); // End subtracts bandwidth
        }

        // Sort the time points
        Collections.sort(timePoints);

        // Sweep line to calculate peak bandwidth
        int currentBandwidth = 0;
        int peakBandwidth = 0;

        for (TimePoint tp : timePoints) {
            currentBandwidth += tp.bandwidthChange; // Update current bandwidth
            peakBandwidth = Math.max(peakBandwidth, currentBandwidth); // Update peak
        }

        return peakBandwidth;
    }
}
