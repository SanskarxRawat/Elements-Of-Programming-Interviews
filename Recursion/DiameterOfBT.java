public class DiameterOfBT {

    /**
     * The diameter of a tree is defined to be the length of a longest path in the tree.
     */

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(log n) --> balanced tree
     * O(n) ----> skewed tree
     */

    /**
     * Approach:
     * 1. Diameter of a tree is the maximum of the following three quantities:
     *   a. Diameter of the left subtree
     *   b. Diameter of the right subtree
     *   c. Longest path between two nodes that passes through the root
     *
     *   Diameter of the left subtree + Diameter of the right subtree + 1
     *
     */


    private int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        height(root);

        return diameter;
    }

    int height(TreeNode node){
        if(node==null) return -1;

        int left=height(node.left);
        int right=height(node.right);

        diameter=Math.max(diameter,left+right+2);
        return 1+Math.max(left,right);
    }
}
