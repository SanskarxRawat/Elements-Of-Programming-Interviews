public class OverLappingListsManyCycles {

    /**
     * Time Complexity: O(n+m)
     * Space Complexity: O(1)
     */
    public static LinkedList<Integer> overlappingLists(LinkedList<Integer> l1,LinkedList<Integer> l2){

        LinkedList<Integer> root1=TestForCyclicity.hasCycleReturns(l1);
        LinkedList<Integer> root2=TestForCyclicity.hasCycleReturns(l2);


        if(root1==null && root2==null){
            return OverLappingLists.noCycleList(l1,l2);
        }else if((root1!=null && root2==null) || (root1==null && root2!=null)){
            return null;
        }

        //Both Lists have cycles

        LinkedList<Integer> temp=root2;
        do{
            temp=temp.getNext();
        }while(temp!=root1 && temp!=root2);

        // LI and L2 do not end in the same cycle.
        if (temp != root1) {
            return null; // Cycles are disjoint.
        }
        // LI and L2 end in the same cycle, locate the overlapping node if they
        // first overlap before cycle starts.
        int stemlLength = distance(l1, root1), stem2Length = distance(l2, root2);
        int count = Math.abs(stemlLength - stem2Length);
        if (stemlLength > stem2Length) {
            l1 = OverLappingLists.advanceListByK(stemlLength - stem2Length, l1);
        } else {
            l2 = OverLappingLists.advanceListByK(stem2Length - stemlLength, l2);
        }
        while (l1 != l2 && l1 != root1 && l2 != root2) {
            l1 = l1.getNext() ;
            l2 = l2.getNext() ;
        }
        // If LI == L2 before reaching rootl, it means the overlap first occurs
        // before the cycle starts; otherwise , the first overlapping node is not
        // unique, so we can return any node on the cycle.
        return l1 == l2 ? l1 : root1;
    }

    private static int distance(LinkedList<Integer> a,LinkedList<Integer> b){
        int distance=0;

        while(a!=b){
            a=a.getNext();
            ++distance;
        }

        return distance;
    }
}
