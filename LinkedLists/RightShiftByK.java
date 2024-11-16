public class RightShiftByK {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static LinkedList<Integer> cyclicallyRightShiftByK(LinkedList<Integer> l,int k){

        if(l==null){
            return l;
        }

        int n=1;

        LinkedList<Integer> tail=l;

        while(tail.getNext()!=null){
            n++;
            tail=tail.getNext();
        }
        k%=n;

        if(k==0){
            return l;
        }
        tail.setNext(l);
        int stepsToNewHead=n-k;
        LinkedList<Integer> newTail=tail;

        while(stepsToNewHead-->0){
            newTail=newTail.getNext();
        }
        LinkedList<Integer> newHead = newTail.getNext();
        newTail.setNext(null);
        return newHead;
    }
}
