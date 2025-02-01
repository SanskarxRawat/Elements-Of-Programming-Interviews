public class ComputeBinomialCoefficient {

    /**
     * Design an efficient algorithm for computing (n choose k) which has the property that it never
     * overflows if the final result fits in the integer word size.
     */


    /**
     * Approach
     * Recursive
     *
     * Time Complexity: O(n*k)
     * Space Complexity: O(n*k)
     */


    public static int computeBinomialCoefficient(int n, int k) {
        return computeXChooseK(n,k,new int[n][k]);
    }

    private static int computeXChooseK(int n, int k, int[][] xChooseY) {

        if(k==0 || n==k){
            return 1;
        }

        if(xChooseY[n][k]==0){
            int withoutY=computeXChooseK(n-1,k,xChooseY);
            int withY=computeXChooseK(n-1,k-1,xChooseY);
            xChooseY[n][k]=withoutY+withY;
        }
        return xChooseY[n][k];
    }
}
