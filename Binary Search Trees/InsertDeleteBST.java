public class InsertDeleteBST {

    /**
     * Design efficient functions for inserting and removing keys in a BST. Assume that all
     * elements in the BST are unique, and that your insertion method must preserve this
     * property.
     */


    /**
     * Approach: INSERT: RECURSIVE
     * 1. To insert a key, we start at the root and compare the key to the root.
     * 2. If the key is less than the root, we move to the left child.
     * 3. If the key is greater than the root, we move to the right child.
     * 4. We continue this process until we reach a leaf node.
     *
     * Time Complexity: O(h) where h is the height of the tree
     * Space Complexity: O(n)
     */
    static BinaryTreeNode<Integer> insertRecursive(BinaryTreeNode<Integer> root, int key){

        // If the tree is empty, return a new node
        if (root == null)
            return new BinaryTreeNode<Integer>(key);

        // If the key is already present in the tree,
        // return the node
        if (root.data == key)
            return root;

        // Otherwise, recur down the tree
        if (key < root.data)
            root.left = insertRecursive(root.left, key);
        else
            root.right = insertRecursive(root.right, key);

        // Return the (unchanged) node pointer
        return root;
    }

    /**
     * ITERATIVE
     * Time Complexity: O(h) where h is the height of the tree
     * Space Complexity: O(1)
     */

    static BinaryTreeNode<Integer> insertIterative(BinaryTreeNode<Integer> root,int key){

        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(key);
        if(root==null){
            return newNode;
        }
        BinaryTreeNode<Integer> parent=null;
        BinaryTreeNode<Integer> current=root;
        while(current!=null){
            parent=current;
            if(key<current.data){
                current=current.left;
            }else if(key>current.data){
                current=current.right;
            }else{
                return root;
            }
        }
        if(key<parent.data){
            parent.left=newNode;
        }else{
            parent.right=newNode;
        }
        return root;
    }


    /**
     * Delete
     *
     * 1. Delete Leaf Node
     * 2. Delete Node with one child
     * 3. Delete Node with two children
     *
     * Approach:
     * 1. Find the node to be deleted
     * 2. If the node is a leaf node, delete it
     * 3. If the node has one child, replace the node with its child
     * 4. If the node has two children, find the inorder successor of the node. Copy the inorder successor's data to the node and delete the inorder successor
     *
     * Time Complexity: O(h) where h is the height of the tree
     * Space Complexity: O(h)
     */


    static BinaryTreeNode<Integer> deleteNode(BinaryTreeNode<Integer> root, int key) {
        if (root == null)
            return root;

        if (key < root.data)
            root.left = deleteNode(root.left, key);
        else if (key > root.data)
            root.right = deleteNode(root.right, key);
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = inOrderSuccessor(root.right);
            // Delete the inorder successor
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    static int inOrderSuccessor(BinaryTreeNode<Integer> root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

}
