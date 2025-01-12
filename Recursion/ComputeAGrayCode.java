import java.util.ArrayList;
import java.util.List;

public class ComputeAGrayCode {

    /**
     * Write a program which takes n as input and returns an n-bit Gray code
     */

    /**
     * Time Complexity: O(2^n)
     * Space Complexity: O(2n)
     */


    public static List<String> grayCode(int n) {

        List<String> ans=new ArrayList<>();
        // power of 2
        for (int i = 0; i < (1 << n); i++){

            // Generating the decimal
            // values of gray code then using
            // bitset to convert them to binary form
            int val = (i ^ (i >> 1));

            // Converting to binary string
            String s = Integer.toBinaryString(val);
        }
        return ans;
    }


}
