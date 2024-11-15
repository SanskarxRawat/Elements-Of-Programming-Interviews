public class RemoveKthNodeFromLast {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static LinkedList<Integer> removeKthLast(LinkedList<Integer> l,int k){

        LinkedList<Integer> dummyNode=new LinkedList<>(0,l);
        LinkedList<Integer> first=dummyNode.getNext();

        while (k-->0){
            first=first.getNext();
        }

        LinkedList<Integer> second=dummyNode;
        while (first!=null){
            first=first.getNext();
            second=second.getNext();
        }
        // second points to the (k + 1)-th last node, deletes its successor.
        second.setNext(second . getNext() . getNext());
        return dummyNode.getNext();
    }
}
