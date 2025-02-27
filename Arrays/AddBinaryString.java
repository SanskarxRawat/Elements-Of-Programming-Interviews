public class AddBinaryString {

    /**
     * This method adds two binary strings and returns their sum as a binary string.
     *
     * Intuition:
     * - Binary addition follows the same rules as decimal addition, but with base 2.
     * - Starting from the least significant bit (rightmost), we sum corresponding bits
     * from both strings along with any carry from the previous addition.
     * - The carry is propagated to the next more significant bit, just like in decimal addition.
     * - The process continues until all bits from both strings are processed,
     * and any remaining carry is added to the result.
     *
     * Time complexity: O(max(N, M)) - N and M are the lengths of the binary strings.
     * Auxiliary space: O(max(N, M))
     *
     *
     * @param x the first binary string
     */

    public static String addBinary(String x, String y) {
        int i = x.length() - 1, j = y.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += x.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += y.charAt(j) - '0';
            }
            if (sum == 0 || sum == 1) {
                result.append(sum);
                carry = 0;
            } else if (sum == 2) {
                result.append("0");
                carry = 1;
            } else {
                result.append("1");
                carry = 1;
            }
            i--;
            j--;
        }
        if (carry == 1) {
            result.append("1");
        }
        return result.reverse().toString();
    }
}
