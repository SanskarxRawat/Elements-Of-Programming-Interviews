import java.util.ArrayList;
import java.util.List;

public class ComputeMnemonics {

    /**
     * Time Complexity: O(4^n*n)
     * Space Complexity: O(1)
     */

    private static final String[] MAPPINGS = {
            "0","1","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ",
    };


    public static List<String> phoneMnemonics(String phoneNumber) {
        char[] partialMnemonics = new char[phoneNumber.length()];

        List<String> mnemonics = new ArrayList<>();
        phoneMnemonicsHelper(phoneNumber,0,partialMnemonics,mnemonics);
        return mnemonics;
    }

    private static void phoneMnemonicsHelper(String phoneNumber,int digit, char[] partialMnemonics,List<String> mnemonics) {

        if(phoneNumber.length() == digit) {
            mnemonics.add(new String(partialMnemonics));
        }else{
            for(int i=digit; i<MAPPINGS[phoneNumber.charAt(digit)-'0'].length(); i++) {
                char c=MAPPINGS[phoneNumber.charAt(digit)-'0'].charAt(i);
                partialMnemonics[digit]=c;
                phoneMnemonicsHelper(phoneNumber,digit+1,partialMnemonics,mnemonics);
            }
        }
    }

}
