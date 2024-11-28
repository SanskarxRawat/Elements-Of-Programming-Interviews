import java.util.List;

public class SearchIn2DSortedMatrix {


    /**
     * Design an algorithm that takes a 2D sorted array and a number and checks whether
     * that number appears in the array. For example, if the input is the 2D sorted array
     * and checks if that number is present or not
     */


    /**
     * Approach:
     *
     * Brute Force: We can apply the binary search on every row
     * since they are sorted.
     *
     * Time Complexity: O(m*log(n))
     */

    /**
     * Time Complexity: O(m+n)
     * Space Complexity: O(1)
     */

    public static boolean matrixSearch(List<List<Integer>> A, int x){

        int row=0,col=A.get(0).size()-1; //start with top-right corner

        while(row<A.size() && col>=0){

            if(A.get(row).get(col).equals(x)){
                return true;
            }else if(A.get(row).get(col)<x){
                ++row;
            }else{
                ++col;
            }
        }

        return false;
    }
}
