public class MergeTwoSortedLists {

    /**
     * Time Complexity: O(n+m)
     * Space Complexity: O(1)
     */

    private static LinkedList<Integer> mergeTwoSortedLists(LinkedList<Integer> l1,LinkedList<Integer> l2){

        LinkedList<Integer> dummyHead=new LinkedList<>(0,null);

        LinkedList<Integer> current=dummyHead;
        LinkedList<Integer> p1=l1,p2=l2;


        while(p1!=null && p2!=null){
            if(p1.getData()<p2.getData()){
                current.setNext(p1);
                p1=p1.getNext();
            }else{
                current.setNext(p2);
                p2=p2.getNext();
            }
            current=current.getNext();
        }

        current.setNext(p1!=null?p1:p2);
        return dummyHead.getNext();
    }
}
