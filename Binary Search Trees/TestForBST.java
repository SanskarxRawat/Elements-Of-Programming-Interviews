public class TestForBST {

    /**
     * Write a program that takes as input a binary tree and checks if the tree satisfies the
     * BST property.
     */

    /**
     * Approach:
     * 1. Perform an inorder traversal of the tree and check if the elements are in sorted order.
     * 2. If the elements are in sorted order, then the tree is a BST.
     *
     */

    public static boolean isBST(BinaryTreeNode<Integer> tree) {
        return areKeysInRange(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean areKeysInRange(BinaryTreeNode<Integer> tree, int lower, int upper) {
        if (tree == null) {
            return true;
        } else if (Integer.compare(tree.data, lower) < 0 || Integer.compare(tree.data, upper) > 0) {
            return false;
        }
        return areKeysInRange(tree.left, lower, tree.data) && areKeysInRange(tree.right, tree.data, upper);
    }
}
