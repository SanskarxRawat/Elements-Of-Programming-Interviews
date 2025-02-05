import java.util.Stack;

public class ComputeLargestRectangle {

    /**
     * Design an algorithm to compute the area of the largest rectangle contained in this skyline.
     * <p>
     * Intuition:
     * - The problem can be efficiently solved using a stack-based approach.
     * - The key observation is that the largest rectangle for a specific bar in the skyline
     * is bounded by the first smaller height to its left and the first smaller height to its right.
     * - Traverse the array while using a stack to maintain indices of bars in increasing order of height.
     * - When a bar of smaller height is encountered, calculate the area of rectangles with bars
     * on top of the stack as the smallest height. Continue this process until the stack is empty.
     * - At the end, process any remaining indices in the stack.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int computeLargestRectangle(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }


    
}
