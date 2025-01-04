import java.util.*;

public class EnumerateNumbers {

    /**
     * Design an algorithm for efficiently computing the k smallest numbers of the form
     * a + bV2 for non-negative integers a and b.
     */


    /**
     * Approach:
     * 1. The smallest number of the form a+bV2 is 0+0V2=0.
     * 2. The next smallest number is 0+1V2=1V2.
     *
     *
     * Time Complexity: O(klogk)
     * Space Complexity: O(k)
     */

    static class Number implements Comparable<Number>{
        int a;
        int b;
        double value;

        public Number(int a, int b) {
            this.a = a;
            this.b = b;
            this.value = a + b * Math.sqrt(2);
        }

        @Override
        public int compareTo(Number o) {
            return Double.compare(value, o.value);
        }
    }

    public static List<Double> kSmallest(int k) {
        List<Double> result = new ArrayList<>();
        SortedSet<Number> minHeap = new TreeSet<>();
        minHeap.add(new Number(0, 0));
        while (k-- > 0) {
            Number current = minHeap.first();
            result.add(current.value);
            minHeap.add(new Number(current.a + 1, current.b));
            minHeap.add(new Number(current.a, current.b + 1));
        }
        return result;
    }
}
