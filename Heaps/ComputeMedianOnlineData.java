import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ComputeMedianOnlineData {

    /**
     * Time Complexity: O(log(n))
     */
    private static double medianOfStream(Iterator<Integer> stream){

        Queue<Integer> minHeap=new PriorityQueue<>();
        Queue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());

        while(stream.hasNext()){
            int x=stream.next();

            if(minHeap.isEmpty()){
                minHeap.offer(x);
            }else{
                if(x>=minHeap.peek()){
                    minHeap.offer(x);
                }else{
                    maxHeap.offer(x);
                }
            }
        }

        if(minHeap.size()>maxHeap.size()+1){
            maxHeap.offer(minHeap.remove());
        }else{
            minHeap.offer(maxHeap.remove());
        }

        return minHeap.size() == maxHeap.size()
                ? 0.5 * (minHeap.peek()+maxHeap.peek())
                : minHeap.peek();
    }
}
