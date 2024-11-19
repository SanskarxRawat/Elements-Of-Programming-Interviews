public class LCABinaryTree {

    /**
     *
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */

    public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> n1, TreeNode<Integer> n2) {
        if(root==null) return root;

        if(root.data==n1.data || root.data==n2.data) return root;

        TreeNode<Integer> leftSide=lowestCommonAncestor(root.left,n1,n2);
        TreeNode<Integer> rightSide=lowestCommonAncestor(root.right,n1,n2);

        if(leftSide!=null && rightSide!=null){
            return root;
        }
        else if(leftSide!=null) return leftSide;
        else return rightSide;
    }
}
