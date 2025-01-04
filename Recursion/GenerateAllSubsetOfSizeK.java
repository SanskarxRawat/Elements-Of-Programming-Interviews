import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubsetOfSizeK {


    /**
     * Write a program which computes all size k subsets of {1, 2,..., n}, where k and n are
     * program inputs. For example, if k = 2 and n = 5, then the result is the following:
     * ((1, 2), (1,3), (1, 4), (1,5), (2,3), (2, 4), (2,5), (3, 4), (3,5), (4, 5))
     */


    /**
     * Approach: Recursive
     *
     * Time Complexity: O(n choose k)
     * Space Complexity: O(n choose k)
     */


    public static List<List<Integer>> generateAllSubsetOfSizeK(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        generateAllSubsetOfSizeK(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    public static void generateAllSubsetOfSizeK(int n, int k, int index, List<Integer> currentSet, List<List<Integer>> result){
        if(currentSet.size()==k){
            result.add(new ArrayList<>(currentSet));
            return;
        }
        final int numRemaining=k-currentSet.size();

        for(int i=index; i<=n && numRemaining<=n-i+1; i++){
            currentSet.add(i);
            generateAllSubsetOfSizeK(n, k, i+1, currentSet, result);
            currentSet.remove(currentSet.size()-1);
        }
    }
}
