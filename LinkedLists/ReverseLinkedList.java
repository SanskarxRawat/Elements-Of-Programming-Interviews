public class ReverseLinkedList {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static LinkedList<Integer> reverseList(LinkedList<Integer> head) {

        LinkedList<Integer> prev=null;
        LinkedList<Integer> cur=head;

        while(cur!=null){
            LinkedList<Integer> temp=cur.getNext();
            cur.setNext(prev);
            prev=cur;
            cur=temp;
        }

        return prev;
    }
}
