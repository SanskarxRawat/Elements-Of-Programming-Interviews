import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneratePermutations {

    /**
     * Write a program which takes as input an array of distinct integers and generates all
     * permutations of that array. No permutation of the array may appear more than once.
     */


    /**
     * Approach: Recursive
     * 1. Swap each element with every other element in the array.
     * 2. Recursively generate permutations for the remaining elements.
     * 3. Repeat the above steps until all elements are swapped.
     *
     * Time Complexity: O(n*n!)
     * Space Complexity: O(n)
     */


    public static List<List<Integer>> permutations(List<Integer> A){
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(A, 0, result);
        return result;
    }

    public static void generatePermutations(List<Integer> A, int index, List<List<Integer>> result){
        if(index == A.size()-1){
            result.add(new ArrayList<>(A));
            return;
        }
        for(int i=index; i<A.size(); i++){
            Collections.swap(A, index, i);
            generatePermutations(A, index+1, result);
            Collections.swap(A, index, i);
        }
    }
}
