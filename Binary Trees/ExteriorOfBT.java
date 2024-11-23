import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExteriorOfBT {


    /**
     * Brute Force
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    static List<Integer> boundary(BinaryTreeNode<Integer> root){

        if(root==null){
            return new ArrayList<>();
        }

        List<Integer> result=new ArrayList<>();
        if(!isLeaf(root)){
            result.add(root.data);
        }

        addLeftBoundary(root,result);
        addLeaves(root,result);
        addRightBoundary(root,result);
        return result;
    }

    static boolean isLeaf(BinaryTreeNode<Integer> node){
        return node.left == null && node.right == null;
    }

    static void addLeaves(BinaryTreeNode<Integer> node,List<Integer> result){

        if(node==null){
            return;
        }

        if(isLeaf(node)){
            result.add(node.data);
        }
        addLeaves(node.left,result);
        addLeaves(node.right,result);
    }
    static void addLeftBoundary(BinaryTreeNode<Integer> node,List<Integer> result){
        node=node.left;

        while(node!=null){
            if(!isLeaf(node)){
                result.add(node.data);
            }
            if(node.left!=null){
                node=node.left;
            }else{
                node=node.right;
            }
        }
    }

    static void addRightBoundary(BinaryTreeNode<Integer> node,List<Integer> result){
        // Go right right and no right then left but again
        // check from right
        node = node.right;
        // As we need the reverse of this for Anticlockwise
        Stack<Integer> stk = new Stack<>();
        while (node != null) {
            if (!isLeaf(node)) {
                stk.push(node.data);
            }
            if (node.right != null) {
                node = node.right;
            }
            else {
                node = node.left;
            }
        }

        while (!stk.isEmpty()) {
            result.add(stk.peek());
            stk.pop();
        }
    }

    /**
     *  Morris Traversal
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     */
    static void printLeftBoundary(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        if (root.left != null || root.right != null) {
            System.out.print(root.data + " ");
        }
        if (root.left != null) {
            printLeftBoundary(root.left);
        } else {
            printLeftBoundary(root.right);
        }
    }

    // Function to print the right boundary nodes of a binary tree
    static void printRightBoundary(BinaryTreeNode<Integer> root ) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            printRightBoundary(root.right);
        } else {
            printRightBoundary(root.left);
        }
        if (root.left != null || root.right != null) {
            System.out.print(root.data + " ");
        }
    }

    // Function to print the leaves of a binary tree
    static void printLeaves(BinaryTreeNode<Integer> root ) {
        if (root == null) {
            return;
        }
        printLeaves(root.left);
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }
        printLeaves(root.right);
    }

    // Function to print the boundary nodes of a binary tree in anticlockwise order
    static void printBoundary(BinaryTreeNode<Integer> root ) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printLeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);
    }
}
