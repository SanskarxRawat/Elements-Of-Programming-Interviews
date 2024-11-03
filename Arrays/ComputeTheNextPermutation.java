import java.util.Collections;
import java.util.List;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ComputeTheNextPermutation {

    public static List<Integer> nextPermutation(List<Integer> permutation) {
        int k=permutation.size()-2;


        while(k>=0 && permutation.get(k)>=permutation.get(k+1)){
            k--;
        }

        if(k==-1){
            return Collections.emptyList();
        }


        for(int i=permutation.size()-1;i>k;i--){
            if(permutation.get(i)>permutation.get(i+1)){
                Collections.swap(permutation,k,i);
                break;
            }
        }

        Collections.reverse(permutation.subList(k+1,permutation.size()));

        return permutation;
    }
}
