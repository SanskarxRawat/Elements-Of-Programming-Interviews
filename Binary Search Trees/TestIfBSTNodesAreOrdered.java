public class TestIfBSTNodesAreOrdered {


    /**
     * Write a program which takes two nodes in a BST and a third node, the "middle"
     * node, and determines if one of the two nodes is a proper ancestor and the other a
     * proper descendant of the middle. (A proper ancestor of a node is an ancestor that
     * is not equal to the node; a proper descendant is defined similarly.)
     */

    /**
     * Approach:
     * 1. If the middle node is the root, then the other two nodes can be any two nodes in the BST.
     * 2. If the middle node is not the root, then one of the two nodes should be the ancestor of the middle node and the other should be the descendant of the middle node.
     * 3. If the middle node is not the root, then the ancestor of the middle node should be less than the middle node and the descendant of the middle node should be greater than the middle node.
     */

    /**
     * Time Complexity: O(d)
     * Space Complexity: O(h)
     */


    public static boolean testIfNodesAreOrdered(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2, BinaryTreeNode<Integer> middle) {
        if (root == null) {
            return false;
        }
        if (middle == root) {
            return true;
        }
        if (middle.data < root.data) {
            return testIfNodesAreOrdered(root.left, node1, node2, middle) || (root.data > node1.data && root.data < node2.data);
        } else {
            return testIfNodesAreOrdered(root.right, node1, node2, middle) || (root.data > node1.data && root.data < node2.data);
        }
    }
}
