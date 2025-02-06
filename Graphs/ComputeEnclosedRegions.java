public class ComputeEnclosedRegions {


    /**
     * Let A be a 2D array whose entries are either W or B. Write a program that takes A,
     * and replaces all Ws that cannot reach the boundary with a B.
     *
     * Approach:
     * - The problem can be solved using a two-step process:
     * 1. Identify all 'W' regions that are connected to the boundary using BFS or DFS.
     * 2. Flip all remaining 'W' regions (those not connected to the boundary) to 'B'.
     * - Specifically:
     * a. Start from all 'W' cells on the boundary and mark all reachable 'W' cells as visited.
     * b. Iterate through the matrix, replacing all unvisited 'W' cells with 'B'.
     * c. Restore the visited 'W' cells back to 'W'.
     *
     * Time Complexity: O(n * m), where n is the number of rows and m is the number of columns in the matrix.
     * Each cell is visited at most once during BFS/DFS.
     * Space Complexity: O(n * m) in the worst case due to the recursion stack or the queue used by BFS.
     */


    public static void fillEnclosedRegions(char[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        // Step 1: Start DFS from boundary cells that are 'W'
        for (int i = 0; i < rows; i++) {
            if (A[i][0] == 'W') dfs(A, i, 0);
            if (A[i][cols - 1] == 'W') dfs(A, i, cols - 1);
        }
        for (int j = 0; j < cols; j++) {
            if (A[0][j] == 'W') dfs(A, 0, j);
            if (A[rows - 1][j] == 'W') dfs(A, rows - 1, j);
        }

        // Step 2: Replace all unvisited 'W' with 'B', and restore visited 'W' back to 'W'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A[i][j] == 'W') {
                    A[i][j] = 'B';
                } else if (A[i][j] == '#') {
                    A[i][j] = 'W';
                }
            }
        }
    }

    private static void dfs(char[][] A, int x, int y) {
        if (x < 0 || x >= A.length || y < 0 || y >= A[0].length || A[x][y] != 'W') {
            return;
        }

        A[x][y] = '#'; // Mark this cell as visited

        // Move in all 4 directions
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : directions) {
            dfs(A, x + dir[0], y + dir[1]);
        }
    }
}
