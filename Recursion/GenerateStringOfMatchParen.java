import java.util.ArrayList;
import java.util.List;

public class GenerateStringOfMatchParen {

    /**
     * Write a program that takes as input a number and returns all the strings with that
     * number of matched pairs of parens.
     */


    /**
     * Approach: Recursive
     * 1. For each pair of parentheses, there are two possibilities, either open or close.
     * 2. Recursively generate parentheses for the remaining pairs.
     * 3. Repeat the above steps until all pairs are open/closed.
     *
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     */

    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        String s="";
        dfs(s,0,n,ans);
        return ans;
    }

    private void dfs(String s,int score,int len,List<String> ans){
        if(score<0) return;
        if(s.length()>(2*len)) return;
        if(s.length()==(2*len) && score==0) ans.add(s);

        dfs(s+"(",score+1,len,ans);
        dfs(s+")",score-1,len,ans);
    }

}
