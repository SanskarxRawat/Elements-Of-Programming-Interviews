import java.util.ArrayList;
import java.util.List;

public class ComputeSpiralOf2D {

    /**
     * Brute Force
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */

    public static List<Integer> matrixInSpiralOrder(List<List<Integer>> squareMatrix){
        List<Integer> spiralOrdering=new ArrayList<>();

        for(int offset=0; offset<Math.ceil(0.5* squareMatrix.size()); offset++){

            matrixLayerInClockwise(squareMatrix,offset,spiralOrdering);
        }

        return spiralOrdering;
    }

    private static void matrixLayerInClockwise(List<List<Integer>> squareMatrix, int offset, List<Integer> spiralOrdering) {

        if(offset==squareMatrix.size()-offset-1){
            spiralOrdering.add(squareMatrix.get(offset).get(offset));
            return;
        }

        for(int j=offset; j<squareMatrix.size()-offset-1; j++){
            spiralOrdering.add(squareMatrix.get(offset).get(j));
        }

        for(int i=offset; i<squareMatrix.size()-offset-1; i++){
            spiralOrdering.add(squareMatrix.get(i).get(squareMatrix.size()-offset-1));
        }

        for (int j = squareMatrix.size() - offset - 1; j > offset; --j) {
            spiralOrdering.add(
                    squareMatrix.get(squareMatrix.size() - offset - 1).get(j));
        }
        for (int i = squareMatrix.size() - offset - 1; i > offset; --i) {
            spiralOrdering.add(squareMatrix.get(i).get(offset));
        }
    }


    /**
     * Optimal Approach
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */

    public static List<Integer> matrixInSpiralOrderOptimal(List<List<Integer>> squareMatrix){

        final int[][] SHIFT={{0,1},{1,0},{0,-1},{-1,0}};

        int dir=0,x=0,y=0;

        List<Integer> spiralOrdering=new ArrayList<>();


        for(int i=0;i<squareMatrix.size();i++){
            spiralOrdering.add(squareMatrix.get(x).get(y));

            squareMatrix.get(x).set(y, 0);

            int nextX=x+SHIFT[dir][0],nextY=y+SHIFT[dir][1];
            if (nextX < 0 || nextX >= squareMatrix.size()|| nextY < 0 | nextY >= squareMatrix.size() || squareMatrix.get(nextX).get(nextY) == 0) {
                dir=(dir+1)%4;
                nextX=x+SHIFT[dir][0];
                nextY=y+SHIFT[dir][1];
            }
            x=nextX;
            y=nextY;
        }
        return spiralOrdering;
     }
}
