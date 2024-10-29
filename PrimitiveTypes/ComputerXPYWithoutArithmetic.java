public class ComputerXPYWithoutArithmetic {

    /**
     *  Time Complexity: O(log(y))
     *  Space Complexity: O(1)
     *
     */
    public static double power(double x, int y) {

        double result = 1.0;

        long power=y;

        while (y<0) {
            power=-power;
            x=1.0/x;
        }


        while(power!=0){
            if((power&1)!=0){
                result=result*x;
            }
            x*=x;
            power>>>=1L;
        }

        return result;
    }
}
