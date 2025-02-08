import java.util.List;

public class Rotate2DMatrix90 {


    /**
     * Intuition:
     * - The rotation of a 2D matrix by 90 degrees clockwise can be done by moving elements in groups of four.
     * - Each layer of the matrix (outermost to innermost) is rotated independently.
     * - For a given layer, elements from four edges are moved in a circular manner.
     *   For example: Top -> Right -> Bottom -> Left -> Top.
     * - By iterating over each layer and swapping elements in groups of four, we achieve the desired rotation.
     *
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
