public class ComputeLCAInBST  {

    /**
     * Design an algorithm that takes as input a BST and two nodes, and returns the LCA
     * of the two nodes.
     */

    /**
     * Approach:
     * 1. If the root's value is greater than both nodes' values, then the LCA must be in the left subtree.
     * 2. If the root's value is less than both nodes' values, then the LCA must be in the right subtree.
     * 3. If the root's value is between the two nodes' values, then the root is the LCA.
     *
     * Time Complexity: O(h) where h is the height of the tree.
     * Space Complexity: O(1)
     */

    public static BinaryTreeNode<Integer> findLCA(BinaryTreeNode<Integer> tree, BinaryTreeNode<Integer> node0, BinaryTreeNode<Integer> node1) {
        BinaryTreeNode<Integer> subtree = tree;


        while (subtree.data < node0.data || subtree.data> node1.data) {
            // Keep searching since p is outside of [s, b].
            while (subtree.data<node0.data) {
                subtree = subtree.right; // LCA must be in p’s right child
            }
            while (subtree.data>node1.data) {
                subtree = subtree.left; // LCA must be in p’s left child.
            }
        }
        return subtree;
    }
}
