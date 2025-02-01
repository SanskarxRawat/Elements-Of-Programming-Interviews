public class EditDistance {

    /**
     * Write a program that takes two strings and computes the minimum number of edits
     * needed to transform the first string into the second string.
     */

    /**
     * Approach: Recursive
     * 1. Process the both the sting either from left or right side
     * 2. There are two possibility either character can match or don't match
     * 3. If they match recursively calculate for the remaining part
     * 4. If last character don't match . We try all the three operations on it
     *
     *
     *  Time Complexity: O(3^M)
     *  Space Complexity: O(M)
     */

    public static int editDistance(String s1,String s2,int n,int m){

        //If first string is empty then the only option is to
        // insert all characters of second string into first
        if(n==0) return m;
        if(m==0) return n;

        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return editDistance(s1,s2,n-1,m-1);
        }

        return Math.min(Math.min(editDistance(s1,s2,n,m-1),editDistance(s1,s2,n-1,m)),editDistance(s1,s2,n-1,m-1));
    }


    /**
     * Using Memoization
     *
     *  Time Complexity: O(m*n)
     *  Space Complexity: O(m*n)
     */


    public static int editDistance(String s1,String s2,int n,int m,int[][] memo) {

        if(n==0) return m;
        if(m==0) return n;
        if(memo[n][m]!=-1) return memo[n][m];

        if(s1.charAt(n-1)==s2.charAt(m-1)){
            memo[n][m] = editDistance(s1,s2,n-1,m-1,memo);
        }else{

            int insert = editDistance(s1,s2,n,m-1,memo);
            int delete = editDistance(s1,s2,n-1,m-1,memo);
            int replace = editDistance(s1,s2,n-1,m,memo);
            memo[n][m] = Math.min(Math.min(insert,delete),replace);
        }

        return memo[n][m];
    }

    /**
     * Bottom-Up
     *
     * Time Complexity: O(m*n)
     * Space Complexity: O(m*)
     */


    public static int editDistDP(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Fill the known entries in dp[][]
        // If one string is empty, then answer
        // is length of the other string
        for (int i = 0; i <= m; i++){
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Fill the rest of dp[][]
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }

        return dp[m][n];
    }
}
