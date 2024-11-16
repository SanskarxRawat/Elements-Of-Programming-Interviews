import java.util.Arrays;
import java.util.List;

public class EvenOddMerge {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static LinkedList<Integer> evenOddMerge(LinkedList<Integer> l){
        if(l==null){
            return l;
        }

        LinkedList<Integer> evenDummyHead=new LinkedList<>(0,null),oddDummyHead=new LinkedList<>(0,null);

        List<LinkedList<Integer>> tails= Arrays.asList(evenDummyHead,oddDummyHead);

        int turn=0;

        for(LinkedList<Integer> iter=l;iter!=null;iter=iter.getNext()){
            tails.get(turn).setNext(iter);
            tails.set(turn,tails.get(turn).getNext());
            turn^=1;
        }

        tails.get(1).setNext(null);
        tails.get(0).setNext(oddDummyHead.getNext());

        return evenDummyHead.getNext();

    }
}
