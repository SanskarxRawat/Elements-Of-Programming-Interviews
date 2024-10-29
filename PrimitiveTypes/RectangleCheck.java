import java.util.Arrays;

public class RectangleCheck {

    /**
     *
     *The opposite sides should be equal in length.
     * The diagonals should intersect each other at a common point and be equal in length.
     * The angle between adjacent sides should be 90 degrees (this is a property of rectangles in a Euclidean plane).
     */
    // Helper method to calculate the squared distance between two points
    private static double distanceSquared(int x1, int y1, int x2, int y2) {
        return Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
    }

    public static boolean areVerticesOfRectangle(int[][] points) {
        // Sort the points based on their coordinates (lexicographically)
        Arrays.sort(points, (a, b) -> (a[0] == b[0]) ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        // Check if the distances satisfy the rectangle properties
        double d1 = distanceSquared(points[0][0], points[0][1], points[1][0], points[1][1]);
        double d2 = distanceSquared(points[1][0], points[1][1], points[3][0], points[3][1]);
        double d3 = distanceSquared(points[3][0], points[3][1], points[2][0], points[2][1]);
        double d4 = distanceSquared(points[2][0], points[2][1], points[0][0], points[0][1]);
        double diag1 = distanceSquared(points[0][0], points[0][1], points[3][0], points[3][1]);
        double diag2 = distanceSquared(points[1][0], points[1][1], points[2][0], points[2][1]);

        // Check if all opposite sides and diagonals are equal
        return d1 == d3 && d2 == d4 && diag1 == diag2 && d1 > 0 && d2 > 0;
    }
}
