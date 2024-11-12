public class SinusoidallyString {

    /**
     * For example, the
     * snake-string string for "Hello World!" is "eÿlHloWrdlo!".
     */

    private static String snakeString(String s) {
        StringBuilder result = new StringBuilder();
        // Outputs the first row, i.e., s[l], s[5], s[9], ...
        for (int i = 1; i < s.length(); i += 4) {
            result.append(s.charAt(i));
        }
        // Outputs the second row, i.e., s[<9], s[2], s[4], ...
        for (int i = 0; i < s.length(); i += 2) {
            result.append(s.charAt(i));
        }
        // Outputs the third row, i.e., s[3], s[7], s[ll], ...
        for (int i = 3; i < s.length(); i += 4) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }

}
