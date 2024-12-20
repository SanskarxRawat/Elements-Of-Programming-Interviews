import java.util.*;
import java.util.LinkedList;

public class RearrangeElementKDistance {

    /**
     * Given an array A and a positive integer k, rearrange the elements so that no
     * two equal elements are k or less apart.
     */

    /**
     *  Time Complexity: O(n*log(n))
     *  Space Complexity: O(n+k) , k is wait queue
     */

    public static int[] rearrange(int[] A, int k) {
        if (k == 0) return A; // No constraints, return the array as is

        // Step 1: Count frequencies of elements
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : A) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Add elements to a max-heap based on their frequencies
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            maxHeap.add(new int[]{entry.getKey(), entry.getValue()});
        }

        // Step 3: Result array and a queue to enforce the k-distance constraint
        int[] result = new int[A.length];
        int index = 0;
        Queue<int[]> waitQueue = new LinkedList<>();

        while (!maxHeap.isEmpty()) {
            // Get the most frequent element
            int[] current = maxHeap.poll();
            result[index++] = current[0];
            current[1]--; // Decrease its frequency

            // Add to the wait queue
            waitQueue.add(current);

            // If the queue size exceeds k, reinsert the oldest element back into the heap
            if (waitQueue.size() > k) {
                int[] front = waitQueue.poll();
                if (front[1] > 0) {
                    maxHeap.add(front);
                }
            }
        }

        // If the result array is not filled completely, it means rearrangement is not possible
        return index == A.length ? result : new int[0];
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 1, 2, 3, 3};
        int k = 2;
        int[] result = rearrange(A, k);
        if (result.length == 0) {
            System.out.println("Rearrangement not possible");
        } else {
            System.out.println("Rearranged array: " + Arrays.toString(result));
        }
    }
}
