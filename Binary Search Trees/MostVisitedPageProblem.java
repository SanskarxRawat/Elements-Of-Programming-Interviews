import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MostVisitedPageProblem {

    /**
     * Write a function to read the next line from a log file, and a function to find the k
     * most visited pages, where k is an input to the function. Optimize performance for the
     * situation where calls to the two functions are interleaved. You can assume the set of
     * distinct pages is small enough to fit in RAM.
     * As a concrete example, suppose the log file ids appear in the following order:
     * g,a,t,t,a,a,a,g,t,c,t,a,t, i.e., there are four pages with ids a,c,g,t. After the first 10
     * lines have been read, the most common page is a with a count of 4, and the next most
     * common page is t with a count of 3.
     */

    /**
     * Time Complexity: finding top k: O(nlogk)
     * Space Complexity: O(n)
     */

    private Map<String,Integer> pageFrequency;
    private BufferedReader lofFileReader;

    public MostVisitedPageProblem(String logFilePath) throws FileNotFoundException {
        this.pageFrequency=new HashMap<>();
        this.lofFileReader=new BufferedReader(new FileReader(logFilePath));
    }

    public void readNextLine() throws IOException {
        String line=lofFileReader.readLine();
        if(line!=null){
            pageFrequency.put(line,pageFrequency.getOrDefault(line,0)+1);
        }
    }

    public List<String> findKMostVisitedPages(int k){
       Queue<Map.Entry<String,Integer>> minHeap=new PriorityQueue<>(k, Comparator.comparingInt(Map.Entry::getValue));

        // Add all entries to the min-heap
        for (Map.Entry<String, Integer> entry : pageFrequency.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Extract the top k pages from the min-heap
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }

        // Reverse the list to have the most visited pages at the top
        Collections.reverse(result);
        return result;
    }

}
