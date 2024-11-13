public class ReverseSublist {

    /**
     * Time Complexity: O(f)  search of fth node
     * Space Complexity: O(1)
     */
    private static LinkedList<Integer> reverseSubList(LinkedList<Integer> l,int start,int finish){
        if(start==finish){
            return l;
        }

        LinkedList<Integer> dummyHead=new LinkedList<>(0,l);
        LinkedList<Integer> subListHead=dummyHead;
        int k=1;

        //Get To the point before start
        while(k++<start){
            subListHead=subListHead.getNext();
        }

        LinkedList<Integer> subListIter=subListHead.getNext();

        while(start++<finish){
            LinkedList<Integer> temp=subListIter.getNext();
            subListIter.setNext(temp.getNext());
            temp.setNext(subListHead.getNext());
            subListHead.setNext(temp);
        }

        return dummyHead.getNext();
    }
}
