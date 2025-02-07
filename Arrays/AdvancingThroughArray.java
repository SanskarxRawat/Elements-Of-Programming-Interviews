import java.util.List;

public class AdvancingThroughArray {


    /**
     * Intuition:
     * - The problem is analogous to checking if we can traverse a graph or maze.
     * - At every index of the array, the value represents the maximum jump length we can make.
     * - Starting from the first index, we calculate the furthest position we can reach.
     * - As we iterate through the array, we continuously extend our "reachable boundary" (furthestReachSoFar).
     * - If, at any point, our current index exceeds the reachable boundary, we cannot progress further.
     * - The goal is to determine if we can eventually reach or surpass the last index of the array.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean canReachEnd(List<Integer> array) {
        int furthestReachSoFar = 0, lastIndex = array.size() - 1;

        for (int i = 0; i <= furthestReachSoFar && furthestReachSoFar <= lastIndex; i++) {
            furthestReachSoFar = Math.max(furthestReachSoFar, i + array.get(i));
        }

        return furthestReachSoFar >= lastIndex;
    }
}
