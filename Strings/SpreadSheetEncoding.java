public class SpreadSheetEncoding {


    /**
     * Time Complexity: O(
     */
    private static int ssDecodeColId(final String s){
        int result=0;

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            result=result*26+c-'A'+1;
        }
        return result;
    }

    private static void printString(int columnNumber) {
        // To store result (Excel column name)
        StringBuilder columnName = new StringBuilder();

        while (columnNumber > 0) {
            // Find remainder
            int rem = columnNumber % 26;

            // If remainder is 0, then a
            // 'Z' must be there in output
            if (rem == 0) {
                columnName.append("Z");
                columnNumber = (columnNumber / 26) - 1;
            }
            else // If remainder is non-zero
            {
                columnName.append((char)((rem - 1) + 'A'));
                columnNumber = columnNumber / 26;
            }
        }

        // Reverse the string and print result
        System.out.println(columnName.reverse());
    }
}
