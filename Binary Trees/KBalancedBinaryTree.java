public class KBalancedBinaryTree {


    /**
     * Definition: A node in a binary tree is k-balanced if the absolute difference between the number of nodes in its left and right subtrees is no more than k.
     */

    /**
     * Time Complexity: O(N)
     * Each node is visited once.
     * Constant work is done per node.
     *
     *
     * Space Complexity: O(H)
     * Space used by the recursion stack.
     * Depends on the height of the tree (H).
     */

    // Global variable to store the first unbalanced node found
    private TreeNode<Integer> unbalancedNode = null;
    private int k;

    public TreeNode<Integer> findUnbalancedNode(TreeNode<Integer> root, int k) {
        this.k = k;
        checkBalance(root);
        return unbalancedNode;
    }

    private int checkBalance(TreeNode<Integer> node) {
        if (node == null) {
            return 0;
        }

        int leftSize = checkBalance(node.left);
        int rightSize = checkBalance(node.right);

        int diff = Math.abs(leftSize - rightSize);

        // Check if current node is unbalanced and if we haven't found an unbalanced node yet
        if (diff > k && unbalancedNode == null) {
            // Ensure all descendants are k-balanced
            unbalancedNode = node;
        }

        // Return the size of the subtree rooted at this node
        return leftSize + rightSize + 1;
    }
}
