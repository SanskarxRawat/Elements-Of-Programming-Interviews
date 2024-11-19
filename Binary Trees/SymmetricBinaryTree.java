public class SymmetricBinaryTree {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public boolean isSymmetric(TreeNode<Integer> root) {
        return check(root,root);
    }

    public boolean check(TreeNode<Integer> root,TreeNode<Integer> root2){
        if(root==null && root2==null){
            return true;
        }

        if(root!=null && root2!=null && root.data==root2.data){
            return (check(root.left,root2.right) && check(root.right,root2.left));
        }
        return false;
    }
}
