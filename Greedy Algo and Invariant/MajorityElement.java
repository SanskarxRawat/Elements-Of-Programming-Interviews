import java.util.Iterator;

public class MajorityElement {


    /**
     * You are reading a sequence of strings. You know a priori that more than half the
     * strings are repetitions of a single string (the "majority element") but the positions
     * where the majority element occurs are unknown. Write a program that makes a
     * single pass over the sequence and identifies the majority element. For example, if the
     * input is (b,a,c,a,a,b,a,a,c,a), then a is the majority element (it appears in 6 out of the
     * 10 places).
     *
     *
     * Time Complexity: O(n)
     * Space Complexity: Space Complexity: O(1)
     */


    /**
     * Approach:
     * The algorithm leverages the Boyer-Moore Voting Algorithm to identify the majority element in a 
     * single pass over the sequence:
     *
     * 1. Maintain a candidate element and a count for that candidate.
     * 2. Traverse through the sequence:
     *    - If the count is zero, assign the current element as the candidate and set the count to 1.
     *    - If the current element matches the candidate, increment the count.
     *    - If the current element does not match the candidate, decrement the count.
     * 3. By the end of the traversal, the candidate holds the majority element since it appears in more 
     *    than half the positions of the sequence.
     *
     * Time Complexity: O(n) - Single traversal of the sequence.
     * Space Complexity: O(1) - Only a few variables are used for computation.
     */

    public static String majorityElement(Iterator<String> integer){

        String candidate="";
        String iter;
        int cadidateCount=0;

        while(integer.hasNext()){
            iter=integer.next();
            if(cadidateCount==0){
                candidate=iter;
                cadidateCount=1;
            }else if (candidate.equals(iter)){
                cadidateCount++;
            }else{
                cadidateCount--;
            }
        }
        return candidate;
    }
}
