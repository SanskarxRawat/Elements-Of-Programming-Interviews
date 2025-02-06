import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchMaze {

    /**
     * Given a 2D array of black and white entries representing a maze with designated
     * entrance and exit points, find a path from the entrance to the exit, if one exists.
     * <p>
     * Intuition:
     * We can use Depth-First Search (DFS) to explore the maze starting from the entrance.
     * The maze is represented as a grid where '0' indicates a path and '1' indicates a wall.
     * We recursively visit each cell, marking visited cells to avoid re-visiting.
     * If we reach the exit point, return the path. If not, backtrack and try other directions.
     * <p>
     * Time Complexity: O(V + E), where V is the number of cells in the maze,
     * and E is the total number of edges (in this case up to 4 per cell).
     * Space Complexity: O(V) due to recursion stack and visited array.
     */
    public static List<int[]> searchMaze(int[][] maze, int[] start, int[] end) {
        List<int[]> path = new ArrayList<>();
        if (dfs(maze, start[0], start[1], end, path)) {
            return path;
        }
        return Collections.emptyList();
    }

    private static boolean dfs(int[][] maze, int x, int y, int[] end, List<int[]> path) {
        // Check if out of bounds or on a wall or already visited
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length || maze[x][y] == 1) {
            return false;
        }

        path.add(new int[]{x, y});
        maze[x][y] = 1; // Mark as visited

        // Check if we've reached the end
        if (x == end[0] && y == end[1]) {
            return true;
        }

        // Move in all 4 directions
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : directions) {
            if (dfs(maze, x + dir[0], y + dir[1], end, path)) {
                return true;
            }
        }

        path.remove(path.size() - 1); // Backtrack
        return false;
    }
}
