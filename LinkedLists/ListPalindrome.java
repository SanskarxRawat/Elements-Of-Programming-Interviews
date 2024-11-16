public class ListPalindrome {


    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static boolean isListPalindrome(LinkedList<Integer> l){

        if(l==null){
            return true;
        }

        LinkedList<Integer> fast=l,slow=l;

        while(fast!=null && fast.getNext()!=null){
            fast=fast.getNext().getNext();
            slow=slow.getNext();
        }

        LinkedList<Integer> firstHalf=l;
        LinkedList<Integer> reversedList=ReverseLinkedList.reverseList(slow);

        while(firstHalf!=null && reversedList!=null){
            if(firstHalf.getData()!=reversedList.getData()){
                return false;
            }
            firstHalf=firstHalf.getNext();
            reversedList=reversedList.getNext();
        }

        return true;
    }

}
