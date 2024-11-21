import java.util.Stack;

public class MaxTree {

    /**
     * Let A be an array of n distinct integers. Let the index of the maximum
     * element of A be m. Define the max-tree on A to be the binary tree on the entries of A
     * in which the root contains the maximum element of A, the left child is the max-tree
     * on A[0 : m -1] and the right child is the max-tree on A[m +1: n —1]. Design an 0(n)
     * algorithm for building the max-tree of A.
     */


    public static TreeNode<Integer> buildMaxTree(int[] A) {
        Stack<TreeNode<Integer>> stack = new Stack<>();

        for (int value : A) {
            TreeNode<Integer> current = new TreeNode<Integer>(value);

            // Maintain the stack such that elements are in decreasing order
            while (!stack.isEmpty() && stack.peek().data < value) {
                TreeNode<Integer> node = stack.pop();
                current.left = node;
            }

            // If the stack is not empty, the current node should be the right child
            if (!stack.isEmpty()) {
                stack.peek().right = current;
            }

            // Push the current node onto the stack
            stack.push(current);
        }

        // The root of the max-tree is at the bottom of the stack
        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.peek();
    }
}
