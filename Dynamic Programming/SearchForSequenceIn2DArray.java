import java.util.List;

public class SearchForSequenceIn2DArray {

    /**
     * Write a program that takes as arguments a 2D array and a 1 D array, and checks
     * whether the ID array occurs in the 2D array.
     */

    /**
     * Time Complexity: O(n*m)
     * Space Complexity: O(1) Auxiliary Space
     */


    public static boolean isPatternContainedInGrid(int[][] grid, int[] pattern) {
        if(!areInputsValid(grid,pattern)){
            return false;
        }

        int rows=grid.length;
        int cols=grid[0].length;
        int iLength=pattern.length;

        if(iLength==0){
            return true;
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==pattern[0]){
                    if(checkSequenceInDirection(grid,i,j,pattern,0,1) || checkSequenceInDirection(grid,i,j,pattern,1,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkSequenceInDirection(int[][] grid, int startI,int startJ,int[] pattern,int deltaI,int deltaJ){
        int idLength = pattern.length;
        int rows = grid.length;
        int cols = grid[0].length;

        // Check if the sequence fits in the grid's bounds for this direction
        int endI = startI + (idLength - 1) * deltaI;
        int endJ = startJ + (idLength - 1) * deltaJ;
        if (endI >= rows || endJ >= cols || endI < 0 || endJ < 0) {
            return false;
        }

        // Check each element in the sequence
        for (int k = 0; k < idLength; k++) {
            int currentI = startI + k * deltaI;
            int currentJ = startJ + k * deltaJ;
            if (grid[currentI][currentJ] != pattern[k]) {
                return false;
            }
        }
        return true;
    }


    private static boolean areInputsValid(int[][] grid, int[] idArray) {
        if (grid == null || idArray == null) {
            return false;
        }
        if (grid.length == 0) {
            return false;
        }
        return true;
    }


    /**
     * Solve the same problem when you cannot visit an entry in A more than once.
     *
     * Approach:
     * 1. Backtracking with visited tracking : DFS Implementation
     *
     *
     */
    // DFS to check if the ID array can be matched starting at (i, j)
    private static boolean dfs(int[][] grid, int i, int j, int[] idArray, int index, boolean[][] visited) {
        // If the entire ID array is matched
        if (index == idArray.length) {
            return true;
        }

        // Check if the current cell is out of bounds or already visited
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]) {
            return false;
        }

        // Check if the current cell matches the current element in the ID array
        if (grid[i][j] != idArray[index]) {
            return false;
        }

        // Mark the current cell as visited
        visited[i][j] = true;

        // Check horizontal (right) and vertical (down) directions
        boolean result = dfs(grid, i, j + 1, idArray, index + 1, visited) || // Horizontal
                dfs(grid, i + 1, j, idArray, index + 1, visited);   // Vertical

        // Backtrack: Unmark the current cell as visited
        visited[i][j] = false;

        return result;
    }


    /**
     * Enumerate all solutions when you cannot visit an entry in A more than once
     */

    // DFS to check if the ID array can be matched starting at (i, j)
    private static void dfs(int[][] grid, int i, int j, int[] idArray, int index, boolean[][] visited, List<int[]> result) {
        // If the entire ID array is matched
        if (index == idArray.length) {
            // Store the starting position of the sequence
            result.add(new int[]{i - (index - 1), j - (index - 1)});
            return;
        }

        // Check if the current cell is out of bounds or already visited
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]) {
            return;
        }

        // Check if the current cell matches the current element in the ID array
        if (grid[i][j] != idArray[index]) {
            return;
        }

        // Mark the current cell as visited
        visited[i][j] = true;

        // Check horizontal (right) and vertical (down) directions
        dfs(grid, i, j + 1, idArray, index + 1, visited, result); // Horizontal
        dfs(grid, i + 1, j, idArray, index + 1, visited, result); // Vertical

        // Backtrack: Unmark the current cell as visited
        visited[i][j] = false;
    }
}
