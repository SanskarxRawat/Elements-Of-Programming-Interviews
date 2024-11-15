public class OverLappingLists {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */


    public static LinkedList<Integer> noCycleList(LinkedList<Integer> l1,LinkedList<Integer> l2){
        int l1_length=getLength(l1),l2_length=getLength(l2);

        if(l1_length>l2_length){
            l1=advanceListByK(l1_length-l2_length,l1);
        }else{
            l2=advanceListByK(l2_length-l1_length,l2);
        }

        while(l1!=null && l2!=null){
            l1=l1.getNext();
            l2=l2.getNext();
        }
        return l1;
    }

    public static LinkedList<Integer> advanceListByK(int k,LinkedList<Integer> l){

        while(k-->0){
            l=l.getNext();
        }

        return l;
    }
    private static int getLength(LinkedList<Integer> list){
        int len=0;

        while(list!=null){
            list=list.getNext();
            len++;
        }

        return len;
    }
}
