import java.util.ArrayList;
import java.util.List;

public class ComputeRandomPermutation {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static List<Integer> computeRandomPermutations(int n){

        List<Integer> permutations = new ArrayList<>(n);

        for(int i = 0; i < n; i++){
            permutations.add(i);
        }

        SamplingOfflineData.randomSampling(permutations.size(),permutations);
        return permutations;
    }
}
