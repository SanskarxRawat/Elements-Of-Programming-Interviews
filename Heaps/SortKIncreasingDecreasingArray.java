import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortKIncreasingDecreasingArray {

    /**
     * Time Complexity: O(nlog(k))
     *
     */
     static class Pair implements Comparable<Pair>{

        int first;
        int second;
        int third;
        public Pair(int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
        @Override
        public int compareTo(Pair o) {
            return 0;
        }
    }

    enum SUBARRAY_TYPE{
         INCREASING,DECREASING
    }

    public static List<Integer> sortKIncDec(final List<Integer> array){

         List<List<Integer>> sortedSubarray=new ArrayList<>();
         SUBARRAY_TYPE subarrayType=SUBARRAY_TYPE.INCREASING;
         int startIndex=0;

         for(int index=0;index<=array.size();index++){

             if(index==array.size() || (index>0 && array.get(index-1)<array.get(index)) || (index > 0 && array.get(index - 1) >= array.get(index)
                     && subarrayType == SUBARRAY_TYPE.INCREASING)){
                 // If the subarray is increasing
                 // then add from the start
                 if (subarrayType == SUBARRAY_TYPE.INCREASING) {
                     sortedSubarray.add(array.subList(startIndex, index));
                     // If the subarray is decreasing
                     // then add from the end
                 } else {
                     List<Integer> subList = new ArrayList<>(array.subList(startIndex, index));
                     Collections.reverse(subList);
                     sortedSubarray.add(subList);
                 }
                 startIndex = index;
                 subarrayType = (subarrayType == SUBARRAY_TYPE.INCREASING
                         ? SUBARRAY_TYPE.DECREASING : SUBARRAY_TYPE.INCREASING);
             }
         }

         return MergeSortedFiles.mergeSortedArrays(sortedSubarray);
    }
}
