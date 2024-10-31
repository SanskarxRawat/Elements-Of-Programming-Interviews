import java.util.List;

public class AdvancingThroughArray {


    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean canReachEnd(List<Integer> array){
        int furthestReachSoFar=0,lastIndex=array.size()-1;

        for(int i=0;i<=furthestReachSoFar && furthestReachSoFar<=lastIndex; i++){
            furthestReachSoFar=Math.max(furthestReachSoFar,i+array.get(i));
        }

        return furthestReachSoFar>=lastIndex;
    }



}
