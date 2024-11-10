public class TextEncoding {
    public static void telexEncode(char[] C) {
        // Step 1: Calculate the required length after encoding
        int originalLength = C.length;
        int newLength = 0;
        for (char ch : C) {
            switch (ch) {
                case '.':
                    newLength += 3; // "DOT"
                    break;
                case ',':
                    newLength += 5; // "COMMA"
                    break;
                case '?':
                    newLength += 13; // "QUESTION MARK"
                    break;
                case '!':
                    newLength += 15; // "EXCLAMATION MARK"
                    break;
                default:
                    newLength += 1;
                    break;
            }
        }

        // Step 2: Create a new array with the new length
        char[] result = new char[newLength];
        int writeIndex = newLength - 1;
        int readIndex = originalLength - 1;

        // Step 3: Traverse from right to left and replace accordingly
        while (readIndex >= 0) {
            switch (C[readIndex]) {
                case '.':
                    result[writeIndex--] = 'T';
                    result[writeIndex--] = 'O';
                    result[writeIndex--] = 'D';
                    break;
                case ',':
                    result[writeIndex--] = 'A';
                    result[writeIndex--] = 'M';
                    result[writeIndex--] = 'M';
                    result[writeIndex--] = 'O';
                    result[writeIndex--] = 'C';
                    break;
                case '?':
                    String questionMark = "QUESTION MARK";
                    for (int i = questionMark.length() - 1; i >= 0; i--) {
                        result[writeIndex--] = questionMark.charAt(i);
                    }
                    break;
                case '!':
                    String exclamationMark = "EXCLAMATION MARK";
                    for (int i = exclamationMark.length() - 1; i >= 0; i--) {
                        result[writeIndex--] = exclamationMark.charAt(i);
                    }
                    break;
                default:
                    result[writeIndex--] = C[readIndex];
                    break;
            }
            readIndex--;
        }

        // Print the result
        System.out.println(new String(result));
    }

    public static void main(String[] args) {
        char[] C = "Hello, world!".toCharArray();
        telexEncode(C);
        // Output: "HelloCOMMA worldEXCLAMATION MARK"
    }
}
