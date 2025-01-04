import java.util.List;

public class BuildMinimumHeightBSTFromSortedArray {


    /**
     * Given a sorted array, the number of BSTs that can be built on the entries in the array
     * grows enormously with its size. Some of these trees are skewed, and are closer to
     * lists; others are more balanced.
     */

    /**
     * Approach:
     * 1. The root of a BST is the middle element of the array.
     * 2. The left subtree is the BST for the left subarray.
     * 3. The right subtree is the BST for the right subarray.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */


    public static BinaryTreeNode<Integer> buildMinimumHeightBST(List<Integer> sortedArray) {
        return buildMinimumHeightBSTHelper(sortedArray, 0, sortedArray.size() - 1);
    }

    private static BinaryTreeNode<Integer> buildMinimumHeightBSTHelper(List<Integer> sortedArray, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        return new BinaryTreeNode<>(sortedArray.get(mid),
                buildMinimumHeightBSTHelper(sortedArray, start, mid - 1),
                buildMinimumHeightBSTHelper(sortedArray, mid + 1, end));
    }
}
