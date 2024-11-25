import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ImplementStackUsingHeap {


    static class HeapEntry<T> implements Comparator<HeapEntry<T>> {
        T value;
        int timestamp;

        public HeapEntry(T value,int timestamp){
            this.value=value;
            this.timestamp=timestamp;
        }

        @Override
        public int compare(HeapEntry<T> o1, HeapEntry<T> o2) {
            return Integer.compare(o2.timestamp,o1.timestamp);
        }
    }


    static class Stack<T>{
        private int timestamp;
        private Queue<HeapEntry<T>> maxHeap;

        public Stack(){
            this.maxHeap=new PriorityQueue<>();
        }

        public void push(T data){
            maxHeap.offer(new HeapEntry<>(data,timestamp++));
        }

        public T pop(){
            return maxHeap.remove().value;
        }
        public T peek() {
            return maxHeap.peek().value;
        }

    }
}
