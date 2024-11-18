import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

public class ImplementCircularQueue {

    /**
     * Time Complexity: Enqueue : O(1)
     *                  Dequeue: O(1)
     */
    private int head;
    private int tail;
    private int numberQueueElements;
    private static final int SCALE_FACTOR=2;
    private Integer[] entries;

    public ImplementCircularQueue(int capacity){
        this.entries=new Integer[capacity];
        this.head=0;
        this.tail=0;
        this.numberQueueElements=0;
    }

    public void enqueue(Integer x){
        if(numberQueueElements==entries.length){
            Collections.rotate(Arrays.asList(entries),-head);

            head=0;
            tail=numberQueueElements;
            entries=Arrays.copyOf(entries,numberQueueElements*SCALE_FACTOR);
        }

        entries[tail]=x;
        tail=(tail+1)%entries.length;
        ++numberQueueElements;
    }

    public Integer dequeue(){
        if (numberQueueElements != 0) {
            --numberQueueElements ;
            Integer ret = entries[head];
            head = (head + 1) % entries.length ;
            return ret;
        }
        throw new NoSuchElementException("Dequeue called on an empty queue.");
    }


    public int size(){
        return numberQueueElements;
    }
}
