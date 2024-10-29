public class ReverseDigits {


    /**
     * Time Complexity: O(k) where k is the number of digits in number
     * Space Complexity: O(1)
     */
    public static long reverse(int number) {
        long result=0;
        long xRemaining=Math.abs(number);

        while(xRemaining !=0) {
            result=result*10+xRemaining%10;
            xRemaining/=10;
        }
        return number<0?-result:result;
    }
}
