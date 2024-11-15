public class RemoveDuplicatesFromSortedLists {


    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static LinkedList<Integer> removeDuplicate(LinkedList<Integer> l){

        LinkedList<Integer> iter=l;

        while (iter!=null){
            LinkedList<Integer> nextDistinct=iter.getNext();

            while(nextDistinct!=null && nextDistinct.getData()==iter.getData()){
                nextDistinct=nextDistinct.getNext();
            }

            iter.setNext(nextDistinct);
            iter=nextDistinct;
        }

        return l;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static LinkedList<Integer> removeDuplicatesWithMCount(LinkedList<Integer> head, int m) {
        if (head == null || m < 1) return null;

        LinkedList<Integer> dummy = new LinkedList<>(0); // Dummy node to handle edge cases
        dummy.setNext(head);

        LinkedList<Integer> current = head;
        int count = 1; // To count occurrences of the current value

        while (current != null && current.getNext() != null) {
            if (current.getData().equals(current.getNext().getData())) {
                // Found a duplicate
                count++;

                if (count > m) {
                    // Skip the next node (remove it from the list)
                    current.setNext(current.getNext().getNext());
                    // Do not move current forward; check for more duplicates
                } else {
                    // Move to the next node
                    current = current.getNext();
                }
            } else {
                // Value changes; reset count and move forward
                count = 1;
                current = current.getNext();
            }
        }
        return dummy.getNext();
    }



}
