import java.util.*;

public class SortAlmostSortedArray {

    /**
     * Time Complexity: O(nlog(k))
     * Space Complexity: O(k)
     */

    public static List<Integer> sortAlmostSortedArray(Iterator<Integer> sequence,int k){

        List<Integer> result=new ArrayList<>();
        Queue<Integer> minHeap=new PriorityQueue<>();

        for(int index=0;index<k && sequence.hasNext();index++){
            minHeap.add(sequence.next());
        }

        while(sequence.hasNext()){
            minHeap.add(sequence.next());
            Integer num=minHeap.remove();
            result.add(num);
        }

        while (!minHeap.isEmpty()){
            result.add(minHeap.remove());
        }

        return result;

    }
}
