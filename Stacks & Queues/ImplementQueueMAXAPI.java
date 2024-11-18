import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ImplementQueueMAXAPI {


    static class QueueWithMax <T extends Comparable<T>>{
        private Queue<T> entries;
        private Deque<T> candidateForMax;

        public QueueWithMax(){
            this.entries=new LinkedList<>();
            this.candidateForMax=new LinkedList<>();
        }


        /**
       While inserting new element in the queue, check if the newly added element is bigger than the last element
       on the candidateForMax if yes remove it all small elements are removed then add the new element to
       candidateForMax queue
     */
        public void enqueue(T x){
            entries.add(x);
            while (!candidateForMax.isEmpty()){
                if(candidateForMax.getLast().compareTo(x) >= 0)
                    break;
                candidateForMax.removeLast();
            }
            candidateForMax.addLast(x);
        }

        /**
            Remove a entry from entries queue and check if its same as that of the max candidate if yes remove
            that entry from max candidate as well
         */
        public T dequeue(){
            if(!entries.isEmpty()){
                T result  = entries.remove();
                if(result.equals(candidateForMax.getFirst())){
                    candidateForMax.removeFirst();
                }
                return result;
            }
            throw new NoSuchElementException("Called dequeue on empty row");
        }

        public T max(){
            if(!candidateForMax.isEmpty())
                return candidateForMax.getFirst();
            throw new NoSuchElementException("Called dequeue on empty row");

        }
    }

}
