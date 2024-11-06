import java.util.*;

public class ComputeRandomSubset {

    /**
     * Time Complexity: O(k)
     * Space Complexity: O(k)
     */
    public static List<Integer> randomSubset(int n,int k){
        Map<Integer,Integer> changedElements=new HashMap<>();


        Random randIdxGen=new Random();

        for(int i=0;i<k;i++){
            int randIdx=i+randIdxGen.nextInt(n-i);

            Integer ptr1= changedElements.get(randIdx);
            Integer ptr2=changedElements.get(i);

            if(ptr1==null && ptr2==null){
                changedElements.put(randIdx,i);
                changedElements.put(i,randIdx);
            }else if(ptr1==null && ptr2!=null){
                changedElements.put(randIdx , ptr2);
                changedElements.put(i, randIdx);
            }else if (ptr1 != null && ptr2 == null) {
                changedElements.put(i , ptr1);
                changedElements.put(randIdx , i);
            } else {
                changedElements.put(i , ptr1);
                changedElements.put(randIdx , ptr2);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            result.add(changedElements.get(i));
        }
        return result ;
    }
}
