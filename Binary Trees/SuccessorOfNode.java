public class SuccessorOfNode {

    /**
     * Design an algorithm that computes the successor of a node in a binary tree. Assume
     * that each node stores its parent.
     */

    /**
     *
     * Time Complexity: O(h)
     */
    public static TreeNodeP<Integer> findSuccessor(TreeNodeP<Integer> node){

        TreeNodeP<Integer> iter=node;

        while(iter!=null){
            // Find the leftmost element in node’s right subtree.
            iter = iter.right ;
            while (iter.left != null) {
                iter = iter.left;
            }
            return iter;
        }
        // Find the closest ancestor whose left subtree contains node.
        while (iter. parent != null && iter . parent . right == iter) {
            iter = iter. parent;
        }
        // A return value of null means node does not have successor , i.e., it is
        // the rightmost node in the tree.
        return iter. parent;
    }


    /**
     * No Parent Node
     */
    // Function to find leftmost node in
    // subtree with given root.
    static TreeNode<Integer> leftMost(TreeNode<Integer> node) {
        TreeNode<Integer> curr = node;
        while (curr.left != null)
            curr = curr.left;
        return curr;
    }

    static TreeNode<Integer> getSucc(TreeNode<Integer> root, int target) {

        // Base Case 1: No Inorder Successor
        if (root == null)
            return null;

        // Base Case 2: root is same as target and
        // right child is not empty
        if (root.data == target && root.right != null)
            return leftMost(root.right);

        // Use BST properties to search for
        // target and successor
        TreeNode<Integer> succ = null;
        TreeNode<Integer> curr = root;
        while (curr != null) {

            // If curr node is greater, then it
            // is a potential successor
            if (target < curr.data) {
                succ = curr;
                curr = curr.left;
            }

            // If smaller, then successor must
            // be in the right child
            else if (target >= curr.data)
                curr = curr.right;

                // If same, the last visited
                // greater value is the successor
            else
                break;
        }

        return succ;
    }
}
