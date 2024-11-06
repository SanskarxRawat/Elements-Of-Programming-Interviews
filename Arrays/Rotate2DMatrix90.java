import java.util.List;

public class Rotate2DMatrix90 {


    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     */

    public static void rotateMatrix(List<List<Integer>> squareMatrix){

        final int matrixSize = squareMatrix.size()-1;

        for(int i=0;i<(squareMatrix.size()/2);i++){
            for(int j=0;j<matrixSize-i;j++){
                int tempi = squareMatrix.get(matrixSize - j).get(i);
                int temp2 = squareMatrix.get(matrixSize - i).get(matrixSize - j);
                int temp3 = squareMatrix.get(j).get(matrixSize - i);
                int temp4 = squareMatrix.get(i).get(j);
                squareMatrix.get(i).set(j, tempi);
                squareMatrix.get(matrixSize - j).set(i, temp2);
                squareMatrix.get(matrixSize - i).set(matrixSize - j, temp3);
                squareMatrix.get(j).set(matrixSize - i, temp4);
            }
        }
    }
}
