public class NonAlignedRectangleIntersection {

    /**
     * For each rectangle, find the axes of projection (which are the edges of each rectangle).
     * Project both rectangles onto these axes.
     * Check if there’s a gap on any axis between the projections.
     */
    // Helper class to represent a point
    public static class Point {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    // Helper class to represent a rectangle with four points
    public static class Rectangle {
        Point[] points;

        public Rectangle(Point p1, Point p2, Point p3, Point p4) {
            points = new Point[]{p1, p2, p3, p4};
        }
    }

    // Method to find the dot product of two vectors
    private static double dotProduct(Point p1, Point p2) {
        return p1.x * p2.x + p1.y * p2.y;
    }

    // Method to find the vector between two points
    private static Point vector(Point p1, Point p2) {
        return new Point(p2.x - p1.x, p2.y - p1.y);
    }

    // Method to find the projection of a point on a given axis
    private static double projectPoint(Point point, Point axis) {
        double dotProduct = dotProduct(point, axis);
        double axisLengthSquared = dotProduct(axis, axis);
        return dotProduct / axisLengthSquared;
    }

    // Method to find if two rectangles intersect based on the SAT
    public static boolean isIntersect(Rectangle r1, Rectangle r2) {
        // Check both rectangles' edges as possible axes of separation
        Point[] axes = {
                vector(r1.points[0], r1.points[1]),
                vector(r1.points[1], r1.points[2]),
                vector(r2.points[0], r2.points[1]),
                vector(r2.points[1], r2.points[2])
        };

        // For each axis, project all points of both rectangles onto it
        for (Point axis : axes) {
            double min1 = Double.MAX_VALUE, max1 = Double.MIN_VALUE;
            double min2 = Double.MAX_VALUE, max2 = Double.MIN_VALUE;

            // Project rectangle 1
            for (Point p : r1.points) {
                double projection = projectPoint(p, axis);
                min1 = Math.min(min1, projection);
                max1 = Math.max(max1, projection);
            }

            // Project rectangle 2
            for (Point p : r2.points) {
                double projection = projectPoint(p, axis);
                min2 = Math.min(min2, projection);
                max2 = Math.max(max2, projection);
            }

            // Check if there's a gap between the projections
            if (max1 < min2 || max2 < min1) {
                return false; // No intersection found on this axis
            }
        }

        // No gap found on any axis, rectangles intersect
        return true;
    }
}
