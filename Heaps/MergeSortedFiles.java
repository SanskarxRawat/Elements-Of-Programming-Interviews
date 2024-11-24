import java.util.*;

public class MergeSortedFiles {

    private static class ArrayEntry{
        int index;
        int value;

        public ArrayEntry(int index,int value){
            this.index=index;
            this.value=value;
        }
    }

    public static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays){

        List<Iterator<Integer>> iterator=new ArrayList<>();

        for(List<Integer> it:sortedArrays){
            iterator.add(it.iterator());
        }

        Queue<ArrayEntry> queue=new PriorityQueue<>(sortedArrays.size(), new Comparator<ArrayEntry>() {
            @Override
            public int compare(ArrayEntry o1, ArrayEntry o2) {
                return Integer.compare(o1.value,o2.value);
            }
        });

        for(int index=0;index<iterator.size();index++){
            if(iterator.get(index).hasNext()){
                queue.add(new ArrayEntry(index,iterator.get(index).next()));
            }
        }

        List<Integer> result=new ArrayList<>();

        while(!queue.isEmpty()){
            ArrayEntry entry=queue.poll();

            result.add(entry.value);
            if(iterator.get(entry.index).hasNext()){
                queue.add(new ArrayEntry(entry.index,iterator.get(entry.index).next()));
            }
        }

        return result;
    }
}
