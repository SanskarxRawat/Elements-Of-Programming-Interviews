import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultiplyTwoPrecisionInteger {


    /**
     *
     * Time Complexity: O(n*m)
     * Space Complexity: O(1)
     */
    public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
        int isNegative=(num1.get(0)<0 || num2.get(0)<0)?-1:1;

        num1.set(0,Math.abs(num1.get(0)));
        num2.set(0,Math.abs(num2.get(0)));

        List<Integer> result=new ArrayList<>(Collections.nCopies(num1.size()+num2.size(), 0));


        for(int i=num1.size()-1; i>=0; i--){

            for(int j=num2.size()-1; j>=0; j--){
                result.set(i+j+1,result.get(i+j+1)+num1.get(i)*num2.get(j));

                result.set(i+j,result.get(i+j)+result.get(i+j+1)/10);
                result.set(i+j+1,result.get(i+j+1)%10);
            }
        }

        int first_non_zero=0;

        while(first_non_zero<result.size() && result.get(first_non_zero)==0){
            first_non_zero++;
        }

        result.subList(first_non_zero, result.size());

        result.set(0,result.get(0)*isNegative);
        return result;
    }
}
