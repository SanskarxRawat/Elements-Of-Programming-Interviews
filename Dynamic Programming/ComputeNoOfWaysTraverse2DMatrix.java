public class ComputeNoOfWaysTraverse2DMatrix {


    /**
     * Write a program that counts how many ways you can go from the top-left to the
     * bottom-right in a 2D array
     */


    /**
     * Approach :
     *  Brute Force
     * 1. Enumerate All Possible Ways Using Recursion
     *
     *
     * Key Observation : Since we're going down path must advance down or right
     *
     * No of ways to get bottom right entry = No Of ways entry above it + No Of ways entry
     *
     * This is the basis for a recursive algorithm
     *
     */

    /**
     * Time Complexity: O(n*m)
     * Space Complexity: O(n*m)
     */

    public static int numberOfWays(int n,int m) {
        return noOfWaysXandY(n-1,m-1,new int[n][m]);
    }

    private static int noOfWaysXandY(int x,int y,int[][] matrix) {

        if(x==0 || y==0){
            return 1;
        }

        if(matrix[x][y]==0){
            int waysTop = x==0?0:noOfWaysXandY(x-1,y,matrix);
            int waysLeft=y==0?0:noOfWaysXandY(x,y-1,matrix);
            matrix[x][y]=waysTop+waysLeft;
        }
        return matrix[x][y];
    }
}
