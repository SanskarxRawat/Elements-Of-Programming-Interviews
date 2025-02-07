import java.util.ArrayList;
import java.util.List;

public class EnumerateFistNPairsInSpiralOrder {


    /**
     * Intuition:
     * - Begin at the origin (0, 0) and move in a spiral pattern.
     * - Use a direction matrix (SHIFT) to facilitate movement in the right direction:
     * right, up, left, and down.
     * - For each step, calculate the next coordinates.
     * - Check if the next coordinates have already been visited to prevent revisiting.
     * - If a conflict is detected (coordinates already visited), change the direction by rotating clockwise.
     * - Continue this process until `n` pairs are enumerated in the spiral order.
     * <p>
     * Time Complexity: O(n^2) for conflict checking due to the use of `anyMatch` on the result list.
     * Space Complexity: O(n) to store the resulting pairs.
     *
     * Variant 2: Enumerate the first n pairs of integers in spiral order
     */
    public static List<int[]> enumerateSpiralPairs(int n) {
        List<int[]> result = new ArrayList<>();
        int x = 0, y = 0, dir = 0;
        int[][] SHIFT = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        result.add(new int[]{x, y});

        for (int i = 1; i < n; i++) {
            int nextX = x + SHIFT[dir][0];
            int nextY = y + SHIFT[dir][1];

            final int finalNextX = nextX;
            final int finalNextY = nextY;
            if (result.stream().anyMatch(pair -> pair[0] == finalNextX && pair[1] == finalNextY)) {
                dir = (dir + 1) % 4;
                nextX = x + SHIFT[dir][0];
                nextY = y + SHIFT[dir][1];
            }
            result.add(new int[]{nextX, nextY});
            x = nextX;
            y = nextY;
        }
        return result;
    }
}
