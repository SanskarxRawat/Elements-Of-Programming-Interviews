public class TestForCyclicity {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean hasCycle(LinkedList<Integer> head) {

        LinkedList<Integer> slow=head;
        LinkedList<Integer> fast=head;

        while(fast!=null && fast.getNext()!=null){

            slow=slow.getNext();
            fast=fast.getNext().getNext();
            if(slow==fast) return true;
        }

        return false;
    }

    public static LinkedList<Integer> hasCycleReturns(LinkedList<Integer> head){

        LinkedList<Integer> fast=head,slow=head;


        while(fast!=null && fast.getNext()!=null){

            slow=slow.getNext();
            fast=fast.getNext().getNext();
            if(slow==fast){
                //There is a cycle, so let's calculate the cycle length
                int cycleLen=0;

                do{
                    ++cycleLen;
                    fast=fast.getNext();
                }while (slow!=fast);

                // Finds the start of the cycle.
                LinkedList<Integer> cycleLenAdvancedlter = head;
                // cycleLenAdvancedlter pointer advances cycleLen first.
                while (cycleLen-- > 0) {
                    cycleLenAdvancedlter = cycleLenAdvancedlter.getNext() ;
                }
                LinkedList<Integer> iter = head;
                // Both iterators advance in tandem.
                while (iter != cycleLenAdvancedlter) {
                    iter = iter.getNext() ;
                    cycleLenAdvancedlter = cycleLenAdvancedlter.getNext() ;
                }
                return iter;
            }

        }

        return null;
    }
}
