import java.util.HashMap;
import java.util.Map;

public class TestForPalindromicPermutations {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(c) , no of distinct characters
     *
     */


    /**
     * Write a program to test whether the letters forming a string can be permuted to form
     * a palindrome. For example, "edified" can be permuted to form "deified".
     */
    public static boolean canFormPalindrome(String str){

        Map<Character,Integer> map=new HashMap<>();

        for(char c: str.toCharArray()){
            map.merge(c,1,Integer::sum);
        }

        int oddCount=0;

        for(int e: map.values()){
            if(e%2!=0 && ++oddCount>1) return false;
        }

        return true;
    }
}
