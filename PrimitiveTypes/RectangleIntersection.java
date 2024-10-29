public class RectangleIntersection {


    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public static class Rectangle {
        int x, y, width, height;

        public Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public static Rectangle intersectRectangle(Rectangle R1, Rectangle R2) {
            if (!islntersect(R1, R2)) {
                return new Rectangle(0, 0, -1, -1); // No intersection.
            }
            return new Rectangle(
                    Math.max(R1.x, R2.x), Math.max(R1.y, R2.y),
                    Math.min(R1.x + R1.width, R2.x + R2.width) - Math.max(R1.x, R2.x),
                    Math.min(R1.y + R1.height, R2.y + R2.height) - Math.max(R1.y, R2.y));
        }

        public static boolean islntersect(Rectangle Rl, Rectangle R2) {
            return Rl.x <= R2.x + R2.width && Rl.x + Rl.width >= R2.x
                    && Rl.y <= R2.y + R2.height && Rl.y + Rl.height >= R2.y;
        }
    }
}
