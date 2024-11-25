import java.util.*;

public class ComputeKLargestElementInHeap {

    /**
     * Given a max-heap, represented asan array A,design an algorithm that computes the k
     * largest elements stored in the max-heap. You cannot modify the heap
     */

    public static class HeapEntry{
        int index;
        int value;

        public HeapEntry(int index,int value){
            this.index=index;
            this.value=value;
        }
    }

    /**
     * Time Complexity: O(k*log(k))
     * Space Complexity: O(k)
     */
    public static class Compare implements Comparator<HeapEntry>{

        @Override
        public int compare(HeapEntry o1, HeapEntry o2) {
            return Integer.compare(o2.value,o1.value);
        }
        public static final Compare COMPARE_HEAP_ENTRIES = new Compare();
    }




    private static List<Integer> kLargestElementInHeap(List<Integer> array,int k){

        if(k<=0){
            return Collections.emptyList();
        }

        List<Integer> result=new ArrayList<>();
        Queue<HeapEntry> candidateMaxHeap=new PriorityQueue<>(Compare.COMPARE_HEAP_ENTRIES);
        candidateMaxHeap.offer(new HeapEntry(0,array.get(0)));

        for(int i=0;i<k;i++){
            HeapEntry candidateEntry=candidateMaxHeap.poll();
            int index=candidateEntry.index;
            result.add(candidateEntry.value);

            int leftChildIndex=2*index+1;
            if(leftChildIndex<array.size()){
                candidateMaxHeap.add(new HeapEntry(leftChildIndex,array.get(leftChildIndex)));
            }
            int rightChildIndex=2*index+2;
            if(rightChildIndex<array.size()){
                candidateMaxHeap.add(new HeapEntry(rightChildIndex,array.get(rightChildIndex)));
            }
        }
        return result;
    }
}
