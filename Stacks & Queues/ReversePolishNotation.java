import java.util.Deque;
import java.util.LinkedList;

public class ReversePolishNotation {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public static int evaluate(String expression){
        String[] symbols=expression.split(",");

        Deque<Integer> intermediateValues=new LinkedList<>();

        for(String symbol:symbols){
            if(symbol.length()==1 && "+-*/".contains(symbol)){
                final int y=intermediateValues.removeFirst();
                final int x=intermediateValues.removeFirst();
                switch (symbol.charAt(0)){

                    case '+':
                        intermediateValues.addFirst(x+y);
                        break;
                    case '-':
                        intermediateValues.addFirst(x-y);
                        break;
                    case '*':
                        intermediateValues.addFirst(x*y);
                        break;
                    case '/':
                        intermediateValues.addFirst(x/y);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid token :"+symbol.charAt(0));
                }
            }else{
                intermediateValues.addFirst(Integer.parseInt(symbol));
            }
        }

        return intermediateValues.removeFirst();

    }
}
