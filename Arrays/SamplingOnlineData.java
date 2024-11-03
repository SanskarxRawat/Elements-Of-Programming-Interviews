import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SamplingOnlineData {

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(k)
     */
    public static List<Integer> onlineRandomSample(Iterator<Integer> sequence, int k){

        List<Integer> runningSample=new ArrayList<>(k);

        for(int i=0;sequence.hasNext() && i<k;i++){
            runningSample.add(sequence.next());
        }
        Random gen = new Random ();
        int numberSeenSoFar=k;

        while(sequence.hasNext()){
            Integer x=sequence.next();
            ++numberSeenSoFar;

            final int indexToReplace=gen.nextInt(numberSeenSoFar);
            if(indexToReplace<k){
                runningSample.set(indexToReplace,x);
            }
        }

        return runningSample;
    }
}
