public class SwapBits {


    /**
     *
     * Time complexity : O(1)
     * Space Complexity: O(1)
     */
    public static long swapBits(long x,int i,int j){
        //Extract the i-th and j-th bit and see if they differ

        if((((x>>>i))&1)!=((x>>>j)&1)){

            long bitMask=(1L<<i) | (1L<<j);
            x^=bitMask;
        }

        return x;
    }
}
