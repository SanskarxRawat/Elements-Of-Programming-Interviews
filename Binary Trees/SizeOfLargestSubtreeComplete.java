public class SizeOfLargestSubtreeComplete {

    /**
     *Time Complexity: O(N)

     * Each node is visited once.
     * Constant work per node.
     * Space Complexity: O(H)
     *
     * Space used by recursion stack.
     * H= height of the tree.
     * Worst Case: O(N)
     * Best/Average Case: O(log N)
     */

    static class Result {
        boolean isComplete;
        boolean isFull;
        int height;
        int size;

        Result(boolean isComplete, boolean isFull, int height, int size) {
            this.isComplete = isComplete;
            this.isFull = isFull;
            this.height = height;
            this.size = size;
        }
    }

    // Variables to keep track of the largest complete subtree
    private int maxSize = 0;
    private TreeNode<Integer> largestCompleteSubtreeRoot = null;

    public TreeNode<Integer> findLargestCompleteSubtree(TreeNode<Integer> root) {
        helper(root);
        return largestCompleteSubtreeRoot;
    }

    private Result helper(TreeNode<Integer> node) {
        if (node == null) {
            return new Result(true, true, 0, 0);
        }

        Result left = helper(node.left);
        Result right = helper(node.right);

        int height = Math.max(left.height, right.height) + 1;
        int size = left.size + right.size + 1;

        // Determine if current subtree is full
        boolean isFull = left.isFull && right.isFull && left.height == right.height;

        // Determine if current subtree is complete
        boolean isComplete = false;
        if (left.isFull && right.isComplete && left.height == right.height) {
            isComplete = true;
        } else if (left.isComplete && right.isFull && left.height == right.height + 1) {
            isComplete = true;
        }

        // Update largest complete subtree
        if (isComplete && size > maxSize) {
            maxSize = size;
            largestCompleteSubtreeRoot = node;
        }

        return new Result(isComplete, isFull, height, size);
    }

}
