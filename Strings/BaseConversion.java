public class BaseConversion {

    /**
     * Time Complexity: O(n(1+log(base-b2)b1)
     *
     * Space Complexity: O(1)
     */
    /**
     * Write a program that performs base conversion. The input isa string,an integer b2,and
     * another integer b2. The string represents be an integer in base b2. The output should
     * be the string representing the integer in base b2. Assume 2 < b\,b2 < 16. Use "A" to
     * represent 10, "B" for 11, ..., and "F" for 15. (For example, if the string is "615", bx is 7
     * and b2 is13, then the result should be"1A7", since 6x72+1x7+5 = 1X132+10X13+7.)
     */
    public static String convertBase(String numberAsString, int b1, int b2) {
        boolean isNegative = numberAsString.startsWith("-");
        int numAsInt = 0;

        for (int i = (isNegative ? 1 : 0); i < numberAsString.length(); i++) {
            numAsInt *= b1;
            numAsInt += Character.isDigit(numberAsString.charAt(i))
                    ? numberAsString.charAt(i) - '0'
                    : numberAsString.charAt(i) - 'A' + 10;
        }

        return (isNegative ? "-" : "")
                + (numAsInt == 0 ? "0" : constructFromBase(numAsInt, b2));
    }

    private static String constructFromBase(int numAsInt, int b) {
        return numAsInt == 0 ? " " : constructFromBase(numAsInt/b, b)+(char)(numAsInt % b >= 10 ? 'A' + numAsInt % b - 10
: '0' + numAsInt % b);
    }

}
