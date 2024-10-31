import java.util.List;

public class IncrementArbitraryPrecisionInteger {


    /**
     * Brute Force
     * Time Complexity: O(n)
     * Worst Case Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */


    public static List<Integer> incrementArbitraryPrecisionInteger(List<Integer> list) {

        int n=list.size()-1;

        list.set(n,list.get(n)+1);

        for(int index=n;index>0 && list.get(index)==10;--index){
            list.set(index,0);
            list.set(index-1,list.get(index-1)+1);
        }

        if(list.get(n)==10){
            list.set(0,0);
            list.set(0,1);
        }

        return list;
    }


}
