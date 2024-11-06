import java.util.ArrayList;
import java.util.List;

public class ComputePascalTriangle {


    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     */

    public static List<List<Integer>> computePascalTriangle(int numberOfRows){

        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for(int i = 0; i < numberOfRows; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <=i; j++){
                row.add((0<j && j<i)?pascalTriangle.get(i-1).get(j-1)+pascalTriangle.get(i-1).get(j):1);
            }
            pascalTriangle.add(row);
        }

        return pascalTriangle;
    }
}
