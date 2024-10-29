public class ComputeParityOfWord {

    /**
     * Bitwise AND Operation (x & 1):
     *
     * x & 1 extracts the least significant bit of x. This will yield 1 if the least significant bit is 1, and 0 if it is 0.
     * XOR Operation (result ^= (x & 1)):
     *
     * result is updated with the XOR (^) of its current value and the extracted bit (x & 1).
     * XOR (^) has the property that:
     * 0 ^ 1 = 1
     * 1 ^ 1 = 0
     * 0 ^ 0 = 0
     * 1 ^ 0 = 1
     * Essentially, this XOR operation toggles result each time it encounters a 1 bit in x.
     * Right Shift (x >>>= 1):
     *
     * x is right-shifted by one position, using the unsigned right shift operator (>>>), which shifts in zeros from the left. This effectively drops the least significant bit that was just processed.
     */

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */


    public static int bruteForce(long x){
        int result=0;
        while (x != 0) {
            result ^= (x & 1);
            x >>>= 1;
        }
        return result;
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(k) where k is the number of set bit in x
     */
    public static int eraseLowestSetBit(long x){
        int result=0;
        while (x != 0) {
            result ^= 1;
            x &= (x - 1);
        }

        return result;
    }

}