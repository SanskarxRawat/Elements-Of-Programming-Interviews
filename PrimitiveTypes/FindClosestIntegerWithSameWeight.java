public class FindClosestIntegerWithSameWeight {

    static final int NUM_UNSIGN_BITS=63;


    /**
     *Time Complexity: O(n)
     * Space Complexity : O(1)
     */
    public static long closestIntegerWithSameWeight(int number) {


        for(int bit=0; bit<NUM_UNSIGN_BITS-1; bit++) {

            if((((number >> bit) & 1)!=((number>>(bit+1))&1))){

                number^=(1L<<bit) | (1L<<(bit+1));
                return number;
            }
        }
        throw new IllegalArgumentException("Invalid number");
    }
}
