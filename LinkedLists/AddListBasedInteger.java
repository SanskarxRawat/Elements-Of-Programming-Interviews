public class AddListBasedInteger {

    /**
     *Time Complexity: O(n+m)
     * Space Complexity: O(1)
     */
    public static LinkedList<Integer> addTwoNumbers(LinkedList<Integer> l1,LinkedList<Integer> l2){


        LinkedList<Integer> dummyHead=new LinkedList<>(0,null);
        LinkedList<Integer> placeIter=dummyHead;

        int carry=0;

        while(l1!=null || l2!=null){
            int sum=carry;
            if(l1!=null){
                sum+=l1.getData();
                l1=l1.getNext();
            }
            if(l2!=null){
                sum+=l2.getData();
                l2=l2.getNext();
            }

            placeIter.setNext(new LinkedList<>(sum%10,null));
            carry=sum/10;
            placeIter=placeIter.getNext();
        }

        if(carry>0){
            placeIter.setNext(new LinkedList<>(carry,null));
        }
        return dummyHead.getNext();
    }

    /**
     * Approach: 1. Reverse, Normal Addition
     *           2. Stacks
     * Solve the same problem when integers are represented as lists of digits with
     * the most significant digit comes first.
     */
}
