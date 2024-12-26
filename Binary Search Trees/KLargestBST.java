import java.util.ArrayList;
import java.util.List;

public class KLargestBST {

    /**
     * A BST is a sorted data structure, which suggests that it should be possible to find the
     * k largest keys easily.
     * Write a program that takes as input a BST and an integer k, and returns the k largest
     * elements in the BST in decreasing order.
     */

    /**
     * Approach:
     * 1.Perform a reverse in-order traversal of the tree.
     * 2. The reverse in-order traversal visits the nodes in decreasing order.
     * 3. Keep track of the number of nodes visited so far.
     * 4. If the number of nodes visited so far is less than k, add the current node to the result.
     *
     * Time Complexity: O(h + k) where h is the height of the tree.
     * Space Complexity: O(k)
     */

    public static List<Integer> findKLargestInBST(BinaryTreeNode<Integer> tree, int k) {
        List<Integer> kLargestElements = new ArrayList<>();
        findKLargestInBSTHelper(tree, k, kLargestElements);
        return kLargestElements;
    }

    private static void findKLargestInBSTHelper(BinaryTreeNode<Integer> tree, int k, List<Integer> kLargestElements) {
        if (tree != null && kLargestElements.size() < k) {
            findKLargestInBSTHelper(tree.right, k, kLargestElements);
            if (kLargestElements.size() < k) {
                kLargestElements.add(tree.data);
                findKLargestInBSTHelper(tree.left, k, kLargestElements);
            }
        }
    }
}
