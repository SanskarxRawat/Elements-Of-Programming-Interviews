import java.util.ArrayList;
import java.util.List;

public class IntersectionTwoSortedArrays {


    /**
     * Write a program which takes as input two sorted arrays, and returns a new array
     * containing elements that are present in both of the input arrays. The input arrays
     * may have duplicate entries, but the returned array should be free of duplicates. For
     * example, the input is (2,3,3,5,5,6, 7, 7,8,12} and (5,5,6,8,8,9,10,10), your output
     * should be (5,6,8).
     */

    /**
     * Time Complexity: O(N+M)
     * Space Complexity: O(1)
     */

    public static List<Integer> intersectTwoSortedArrays(List<Integer> A, List<Integer> B) {

        List<Integer> result = new ArrayList<>();
        int i=0, j=0;

        while(i < A.size() && j < B.size()){

            if(A.get(i) == B.get(j) && (i == 0 || A.get(i) != A.get(i-1))){
                result.add(A.get(i));
                i++;
                j++;
            }else if(A.get(i) < B.get(j)){
                i++;
            }else{
                j++;
            }
        }
        return result;
    }
}
