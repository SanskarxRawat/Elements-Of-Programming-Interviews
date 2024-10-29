public class CheckIfDecimalIntegerPalindrome {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }

        final int digits=(int)(Math.floor(Math.log10(number)))+1;
        int msdMask=(int)(Math.pow(10,digits-1));

        for(int i=0;i<(msdMask/2);i++){
            if(number/msdMask!=number%10){
                return false;
            }

            number%=msdMask;
            number/=10;
            msdMask/=100;
        }

        return true;
    }
}
