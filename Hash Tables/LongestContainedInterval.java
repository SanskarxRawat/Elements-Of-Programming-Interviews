import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestContainedInterval {

    /**
     * Write a program which takes as input a set of integers represented by an array, and
     * returns the size of a largest subset of integers in the array having the property that if
     * two integers are in the subset, then so are all integers between them. For example, if
     * the input is (3,-2,7, 9,8,1,2,0, -1,5,8), the largest such subset is {-2,-1,0,1,2,3), so
     * you should return 6.
     */

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */


    public static int longestContainedInterval(List<Integer> array){

        Set<Integer> unprocessedEntries=new HashSet<>(array);

        int maxInterval=0;

        while(!unprocessedEntries.isEmpty()){

            int a=unprocessedEntries.iterator().next();

            unprocessedEntries.remove(a);

            int lowerBound=a-1;

            while(unprocessedEntries.contains(lowerBound)){
                unprocessedEntries.remove(lowerBound);
                lowerBound--;
            }

            int upperBound=a+1;
            while(unprocessedEntries.contains(upperBound)){
                unprocessedEntries.remove(upperBound);
                upperBound++;
            }
            maxInterval=Math.max(maxInterval,upperBound-lowerBound-1);
        }

        return maxInterval;
    }

}
