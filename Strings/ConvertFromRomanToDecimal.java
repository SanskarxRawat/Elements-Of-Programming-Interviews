import java.util.HashMap;
import java.util.Map;

public class ConvertFromRomanToDecimal {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private static final Map<Character,Integer> romanValues =new HashMap<Character,Integer>(){
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private static int romanToDecimal(String roman) {
            int sum= romanValues.get(roman.charAt(roman.length()-1));
            for(int i=roman.length()-2;i>=0;i--){
                if(romanValues.get(roman.charAt(i))<= romanValues.get(roman.charAt(i+1))){
                    sum-= romanValues.get(roman.charAt(i));
                }else{
                    sum+= romanValues.get(roman.charAt(i));
                }
            }

            return sum;
    }

    public static boolean isValidRoman(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        // Check for invalid characters
        for (char c : s.toCharArray()) {
            if (!romanValues.containsKey(c)) {
                return false;
            }
        }

        // Check for valid Roman numeral rules
        int prevValue = Integer.MAX_VALUE;
        int repeatCount = 1;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            int currentValue = romanValues.get(current);

            // If the current value is greater than the previous value, it should be a valid subtractive combination
            if (currentValue > prevValue) {
                if (!isValidSubtractiveCombination(s.charAt(i - 1), current)) {
                    return false;
                }
                repeatCount = 1; // Reset repeat count after a subtractive combination
            } else if (currentValue == prevValue) {
                // Only 'I', 'X', 'C', and 'M' can be repeated up to three times consecutively
                if (current == 'V' || current == 'L' || current == 'D') {
                    return false;
                }
                repeatCount++;
                if (repeatCount > 3) {
                    return false;
                }
            } else {
                repeatCount = 1;
            }

            prevValue = currentValue;
        }

        return true;
    }

    private static boolean isValidSubtractiveCombination(char smaller, char larger) {
        return (smaller == 'I' && (larger == 'V' || larger == 'X')) ||
                (smaller == 'X' && (larger == 'L' || larger == 'C')) ||
                (smaller == 'C' && (larger == 'D' || larger == 'M'));
    }

    public static String intToRoman(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (n >= values[i]) {
                sb.append(symbols[i]);
                n -= values[i];
            }
        }
        return sb.toString();
    }
}
