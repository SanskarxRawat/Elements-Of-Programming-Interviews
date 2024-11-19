public class CheckBinaryTreeHeightBalanced {


    /**
     * Time Complexity: O(n) : n is number of nodes
     * Space Complexity: O(h) : height of binary tree
     */

    public int maxDepth(TreeNode<Integer> root,boolean[] result) {
        if (root == null)
            return 0;

        int l = maxDepth(root.left,result);

        int r = maxDepth(root.right,result);

        if (Math.abs(l - r) > 1)
            result[0] = false;

        return 1 + Math.max(l, r);
    }
}
