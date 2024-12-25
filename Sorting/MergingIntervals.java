import java.util.ArrayList;
import java.util.List;

public class MergingIntervals {

    /**
     * Write a program which takes as input an array of disjoint closed intervals with integer
     * endpoints, sorted by increasing order of left endpoint, and an interval to be added,
     * and returns the union of the intervals in the array and the added interval. Your result
     * should be expressed as a union of disjoint intervals sorted by left endpoint.
     */

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */

    private static class Interval {
        int left, right;

        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static List<Interval> addInterval(List<Interval> disjointIntervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int i = 0;
        while (i < disjointIntervals.size() && newInterval.left > disjointIntervals.get(i).right) {
            result.add(disjointIntervals.get(i++));
        }

        while (i < disjointIntervals.size() && newInterval.right >= disjointIntervals.get(i).left) {
            newInterval = new Interval(Math.min(newInterval.left, disjointIntervals.get(i).left),
                    Math.max(newInterval.right, disjointIntervals.get(i).right));
            i++;
        }
        result.add(newInterval);

        result.addAll(disjointIntervals.subList(i, disjointIntervals.size()));
        return result;
    }

}
