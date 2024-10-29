public class ComputeXDYWithoutArithmetic {

    /**
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static long divide(long x, long y) {
        long result=0;
        int power=32;

        long yPower=y<<power;

        while (x >= y) {

            while(yPower>x) {
                yPower>>>=1L;
                --power;
            }

            result+=(1L<<power);
            x-=yPower;
        }
        return result;
    }
}
