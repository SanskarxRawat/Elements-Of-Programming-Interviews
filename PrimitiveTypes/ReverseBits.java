public class ReverseBits {

    /**
     * No Leading Zeros are considered
     *
     * Time Complexity: O(32)
     * Space Complexity: O(1)
     */
    public static int reverseBits(int n){

        int result=0;

        while(n>0){
            result<<=1;
            if((n&1)>0){
                result^=1;
            }
            result>>>=1;
        }

        return result;
    }

    /**
     * Leading Zeros are considered
     *Time Complexity: O(32)
     *  Space Complexity: O(1)
     */
    static int reverseBits2(int n) {
        int newN = 0;
        for(int i = 0; i < Integer.SIZE; i++) {
            newN = newN << 1;
            if((n & 1) > 0) {
                newN = newN ^ 1;
            }
            n = n >> 1;
        }
        return newN;
    }
}


