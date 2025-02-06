import java.util.Queue;

public class PaintABooleanMatrix {

    /**
     * Implement a routine that takes an n X m Boolean array A together with an entry (x, y)
     * and flips the color of the region associated with (x, y).
     * <p>
     * Intuition:
     * The problem is a classic flood-fill problem similar to the "bucket fill" in image editing programs.
     * Starting from the given (x, y) cell, we recursively visit all neighboring cells with the same color
     * and flip their color. To ensure we do not revisit cells, we use the 2D array itself as a marker.
     * This is done efficiently using DFS (Depth-First Search), visiting adjacent cells in the four
     * cardinal directions (up, down, left, right) within the matrix bounds.
     */


    /**
     * Time Complexity: O(n * m), where n is the number of rows and m is the number of columns in the matrix.
     * We visit each cell at most once.
     * <p>
     * Space Complexity: O(n * m), due to the recursive call stack for DFS, which in the worst case
     * can go as deep as the total number of cells in the region being flipped.
     */
    public static void flipColor(boolean[][] A, int x, int y) {
        boolean originalColor = A[x][y];
        // Perform DFS to flip the region
        dfsFlip(A, x, y, originalColor);
    }

    private static void dfsFlip(boolean[][] A, int x, int y, boolean originalColor) {
        // Check if out of bounds or color is not the same as the original
        if (x < 0 || x >= A.length || y < 0 || y >= A[0].length || A[x][y] != originalColor) {
            return;
        }

        // Flip the current cell
        A[x][y] = !originalColor;

        // Move in all 4 directions
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : directions) {
            dfsFlip(A, x + dir[0], y + dir[1], originalColor);
        }
    }

    /**
     * Time Complexity: O(n * m), where n is the number of rows and m is the number of columns in the matrix.
     * We visit each cell at most once.
     * <p>
     * Space Complexity: O(n * m), due to the queue used in BFS, which in the worst case
     * can contain all the cells in the region being flipped.
     */

    private static void bfsFlip(boolean[][] A, int x, int y, boolean originalColor) {
        // Use a queue for BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        // Flip the initial cell
        A[x][y] = !originalColor;

        // Move in all 4 directions
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] dir : directions) {
                int newX = current[0] + dir[0];
                int newY = current[1] + dir[1];
                if (newX >= 0 && newX < A.length && newY >= 0 && newY < A[0].length
                        && A[newX][newY] == originalColor) {
                    // Flip the color and enqueue the cell
                    A[newX][newY] = !originalColor;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
    }

    
}
