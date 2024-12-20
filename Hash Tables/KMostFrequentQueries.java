import java.util.*;

public class KMostFrequentQueries {


    /**
     * You are given an array of strings. Compute the k strings that appear most frequently
     * in the array
     */

    /**
     * Time Complexity: O(n+m*log(k))
     * Space Complexity: O(u+k) : u is unique strings
     */

    static class HeapEntry{
        String value;
        int frequency;

        public HeapEntry(String value,int frequency){
            this.value=value;
            this.frequency=frequency;
        }
    }

    public static List<String> mostFrequentEntries(String[] array, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each string in the array
        for (String s : array) {
            frequencyMap.merge(s, 1, Integer::sum);
        }

        // Create a min-heap to keep the top k elements
        Queue<HeapEntry> minHeap = new PriorityQueue<>(
                (a, b) -> (a.frequency == b.frequency)
                        ? b.value.compareTo(a.value) // Sort alphabetically if frequency is equal
                        : a.frequency - b.frequency // Sort by frequency
        );

        // Iterate over the frequency map
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(new HeapEntry(entry.getKey(), entry.getValue()));
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element
            }
        }

        // Extract the k most frequent elements
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().value);
        }

        // Reverse to maintain descending order of frequency
        Collections.reverse(result);
        return result;
    }
}
