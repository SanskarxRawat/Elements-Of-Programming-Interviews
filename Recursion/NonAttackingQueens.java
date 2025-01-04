import java.util.ArrayList;
import java.util.List;

public class NonAttackingQueens {

    /**
     * Write a program which returns all distinct non-attacking placements of n queens on
     * an nxn chessboard, where n is an input to the program.
     */


    public static List<List<Integer>> nQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> colPlacements = new ArrayList<>();
        solveNQueens(n, 0, colPlacements, result);
        return result;
    }


    public static void solveNQueens(int n, int row, List<Integer> colPlacements, List<List<Integer>> result) {
        if (row == n) {
            result.add(new ArrayList<>(colPlacements));
        } else {
            for (int col = 0; col < n; col++) {
                colPlacements.add(col);
                if (isValid(colPlacements)) {
                    solveNQueens(n, row + 1, colPlacements, result);
                }
                colPlacements.remove(colPlacements.size() - 1);
            }
        }
    }

    private static boolean isValid(List<Integer> colPlacements) {
        int rowId = colPlacements.size() - 1;
        for (int i = 0; i < rowId; i++) {
            int diff = Math.abs(colPlacements.get(i) - colPlacements.get(rowId));
            if (diff == 0 || diff == rowId - i) {
                return false;
            }
        }
        return true;
    }

    /**
     * Compute the number of non-attacking placements of n queens on an n X
     * n chessboard.
     */


    public static int solveNQueens(int n) {
        int[][] board = new int[n][n];
        return solveNQueensUtil(board, 0, n);
    }

    private static int solveNQueensUtil(int[][] board, int col, int n) {
        if (col >= n) {
            return 1; // Found a solution
        }

        int count = 0;
        // Try placing queen in each row of this column
        for (int row = 0; row < n; row++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;
                count += solveNQueensUtil(board, col + 1, n);
                board[row][col] = 0; // backtrack
            }
        }

        return count;
    }

    private static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check row on left side
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 1) {
                return false;
            }
        }

        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on left side
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}
