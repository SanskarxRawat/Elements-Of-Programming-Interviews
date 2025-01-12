public class ImplementSudokuSolver {

    /**
     * Implement a Sudoku solver
     */

    /**
     * Time Complexity: O(9^(n*n))
     * Space Complexity: O(n*n)
     */


    public static boolean solveSudoku(char[][] board) {
        return solveSudokuUtil(board, 0, 0);
    }

    public static boolean solveSudokuUtil(char[][] board, int row, int col) {
        if (row == board.length) {
            return true;
        }
        if (col == board[0].length) {
            return solveSudokuUtil(board, row + 1, 0);
        }
        if (board[row][col] != '.') {
            return solveSudokuUtil(board, row, col + 1);
        }
        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, row, col, c)) {
                board[row][col] = c;
                if (solveSudokuUtil(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    public static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c || board[i][col] == c || board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
