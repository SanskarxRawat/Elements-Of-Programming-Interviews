public class TargetSum {

    /**
     *
     * Space Complexity: O(h)
     * Time Complexity: O(n)
     */
    public static boolean hasPathSum(TreeNode<Integer> tree,
                                     int targetSum) {
        return hasPathSumHelper (tree , 0, targetSum);
    }
    private static boolean hasPathSumHelper (TreeNode<Integer> node,
                                             int partialPathSum , int targetSum) {
        if (node == null) {
            return false;
        }
        partialPathSum += node. data;
        if (node.left == null && node.right == null) { // Leaf.
            return partialPathSum == targetSum;
        }
        // Non-leaf .
        return hasPathSumHelper (node . left , partialPathSum, targetSum)
                || hasPathSumHelper (node . right , partialPathSum, targetSum);
    }
}
