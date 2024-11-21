public class ComputeKthNodeInOrder {

    static class Node<T>{
        Node<T> left;
        Node<T> right;
        T data;
        int size;
    }

    /**
     * Morris Traversal Algorithm – O(h) Time and O(1) Space
     */
    private static Node<Integer> findKthNodeBinaryTree(Node<Integer> tree,int k){
        Node<Integer> iter=tree;

        while(iter!=null){
            int leftSize= iter.left!=null?iter.left.size:0;
            if(leftSize+1<k){ // k-th node must be in right subtree of iter
                k-=(leftSize+1);
                iter=iter.right;
            }else if(leftSize==k-1){ // k-th is iter itself.
                return iter;
            }else{ // k-th node must be in left subtree of iter.
                iter=iter.left;
            }
        }

        return null;
    }
    /**
     * Morris Traversal Algorithm – O(n) Time and O(1) Space
     */
    private static int computeInorderTraversal(TreeNode<Integer> tree,int k){
        TreeNode<Integer> curr=tree;

        while (curr != null) {

            // if left child is null, check
            // curr node and move to right node.
            if (curr.left == null) {
                if (k == 1) return curr.data;
                k--;
                curr = curr.right;
            } else {

                // Find the inorder predecessor of curr
                TreeNode<Integer> pre = curr.left;
                while (pre.right != null && pre.right != curr)
                    pre = pre.right;

                // Make curr as the right child of its
                // inorder predecessor and move to
                // left node.
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                }

                // Revert the changes made in the 'if' part to
                // restore the original tree i.e., fix the right
                // child of predecessor
                else {
                    pre.right = null;
                    if (k == 1) return curr.data;
                    k--;
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
}
