import java.util.*;

public class RearrangeMaxShortestSubarray {

    /**
     * Given an array A, rearrange the elements so that the shortest subarray
     * containing all the distinct values in A has maximum possible length.
     */

    /**
     * Time Complexity: O(k*n) k it the no of distinct elements
     * Space Complexity: O(k)
     */


    public static List<Integer> rearrangeMaxShortestSubarray(List<Integer> arr) {
        // Step 1: Count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Store distinct elements and sort them by frequency (optional for balance)
        List<Map.Entry<Integer, Integer>> distinctElements = new ArrayList<>(frequencyMap.entrySet());
        distinctElements.sort((a, b) -> b.getValue() - a.getValue()); // Sort by descending frequency

        // Step 3: Rearrange elements
        List<Integer> result = new ArrayList<>();
        int n = arr.size();
        int idx = 0;

        while (result.size() < n) {
            Map.Entry<Integer, Integer> currentEntry = distinctElements.get(idx % distinctElements.size());
            result.add(currentEntry.getKey());

            // Decrement frequency
            frequencyMap.put(currentEntry.getKey(), frequencyMap.get(currentEntry.getKey()) - 1);

            // Remove element from the list if its frequency becomes 0
            if (frequencyMap.get(currentEntry.getKey()) == 0) {
                distinctElements.remove(idx % distinctElements.size());
            } else {
                idx++;
            }
        }

        return result;
    }
}
