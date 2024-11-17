import java.util.Deque;
import java.util.LinkedList;

public class WellFormedParentheses {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    private static boolean isWellFormed(String s){

        Deque<Character> leftChars=new LinkedList<>();

        for(char c: s.toCharArray()){

            if(c=='(' || c=='[' || c=='{'){
                leftChars.addFirst(c);
            }else{
                if(leftChars.isEmpty()){
                    return false;
                }

                if((c==')' && leftChars.peekFirst()!='(') ||
                        (c==']' && leftChars.peekFirst()!='[') ||
                        (c=='}' && leftChars.peekFirst()!='{')
                ){
                    return false;
                }
                leftChars.removeFirst();
            }
        }

        return leftChars.isEmpty();
    }
}
