public class PivotTheList {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static LinkedList<Integer> pivotListing(LinkedList<Integer> l,int pivot){
        LinkedList<Integer> lessHead=new LinkedList<>(0,null);
        LinkedList<Integer> equalHead=new LinkedList<>(0,null);
        LinkedList<Integer> greaterHead=new LinkedList<>(0,null);


        LinkedList<Integer> lessIter=lessHead;
        LinkedList<Integer> equalIter=equalHead;
        LinkedList<Integer> greatIter=greaterHead;

        LinkedList<Integer> iter=l;

        while(iter!=null){

            if(iter.getData()<pivot){
                lessIter.setNext(iter);
                lessIter=iter;
            }else if(iter.getData()==pivot){
                equalIter.setNext(iter);
                equalIter=iter;
            }else{
                greatIter.setNext(iter);
                greatIter=iter;
            }
            iter=iter.getNext();
        }
        greatIter.setNext(null);
        lessIter.setNext(equalIter.getNext());
        equalIter.setNext(greatIter.getNext());
        return lessIter.getNext();
    }
}
