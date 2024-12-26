public class FirstKeyGreater {

    /**
     * Write a program that takes as input a BST and a value, and returns the first key that is greater
     * than the input value.
     */

    /**
     * Approach:  Brute Force do in order walk and find the first key greater than the input value.
     *
     * 1. If the root's value is less than or equal to the input value, then the first key greater than
     * the input value must be in the right subtree.
     * 2. If the root's value is greater than the input value, then the first key greater than the input
     * value must be in the left subtree.
     * 3. If the root's value is less than or equal to the input value, then the first key greater than
     * the input value must be in the right subtree.
     * 4. If the root's value is greater than the input value, then the first key greater than the input
     * value must be in the left subtree.
     * 5. If the root's value is equal to the input value, then the first key greater than the input value
     * must be in the right subtree.
     *
     * Time Complexity: O(h) where h is the height of the tree.
     * Space Complexity: O(1)
     */

    public static BinaryTreeNode<Integer> findFirstGreaterThanK(BinaryTreeNode<Integer> tree, Integer k) {
        BinaryTreeNode<Integer> subtree = tree, firstSoFar = null;
        while (subtree != null) {
            if (subtree.data > k) {
                firstSoFar = subtree;
                subtree = subtree.left;
            } else {
                subtree = subtree.right;
            }
        }
        return firstSoFar;
    }
}
