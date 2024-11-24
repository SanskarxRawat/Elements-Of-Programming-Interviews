import java.util.*;

public class TopKLongestStrings {

    /**
     * Time Complexity: O(nlog(k))
     */


    public static List<String> topK(int k, Iterator<String> iter){

        Queue<String> minHeap=new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        });

        while (iter.hasNext()){
            minHeap.add(iter.next());

            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        return new ArrayList<>(minHeap);
    }
}
