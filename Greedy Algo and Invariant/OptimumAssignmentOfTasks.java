import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimumAssignmentOfTasks {

    /**
     * Design an algorithm that takes as input a set of tasks and returns an optimum assignment.
     * The tasks are represented as an array of integers where each integer represents the time required for a task.
     * The algorithm returns a list of pairs of task indices, where each pair represents two tasks assigned to a worker.
     */


    /**
     * Approach:
     *
     * 1. Sort the tasks in ascending order of their durations.
     * 2. Use two pointers, one starting at the beginning of the sorted array and the other at the end.
     * 3. Pair the tasks pointed to by the two pointers (smallest and largest durations)
     * and move the pointers towards each other (increment the start pointer and decrement the end pointer).
     * 4. Continue this process until all tasks are paired optimally.
     *
     * Time Complexity: O(n log n) - Due to the sorting step.
     * Space Complexity: O(1) - Sorting is in-place, and only a constant amount of extra space is used (ignoring the output list).
     */


    public static List<int[]> optimumAssignment(int[] tasks) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(tasks);
        int i = 0, j = tasks.length - 1;
        while (i < j) {
            result.add(new int[]{i, j});
            i++;
            j--;
        }
        return result;
    }
}
