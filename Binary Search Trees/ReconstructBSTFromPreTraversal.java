import java.util.List;

public class ReconstructBSTFromPreTraversal {

    /**
     * Reconstruct a BST from its pre-order traversal sequence.
     */

    /**
     * Approach:
     * 1. The first element in the pre-order traversal is the root of the BST.
     * 2. The next element greater than the root is the root of the right subtree.
     * 3. The next element greater than the root of the right subtree is the root of the right subtree.
     */

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public static BinaryTreeNode<Integer> reconstructBSTFromPreTraversal(List<Integer> preOrderSequence) {
        return reconstructBSTFromPreTraversalHelper(preOrderSequence, 0, preOrderSequence.size()-1);
    }


    private static BinaryTreeNode<Integer> reconstructBSTFromPreTraversalHelper(List<Integer> preOrderSequence, int start, int end) {
        if (start > end) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(preOrderSequence.get(start));
        if(start==end){
            return root;
        }
        int transitionPoint;
        for(transitionPoint=start+1; transitionPoint<=end; transitionPoint++){
            if(preOrderSequence.get(transitionPoint)>root.data){
                break;
            }
        }
        root.left=reconstructBSTFromPreTraversalHelper(preOrderSequence, start+1, transitionPoint-1);
        root.right=reconstructBSTFromPreTraversalHelper(preOrderSequence, transitionPoint, end);
        return root;
    }


    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    private static int index=0;

    private static BinaryTreeNode<Integer> constructTree(List<Integer> preOrderSequence) {
        return constructTreeHelper(preOrderSequence,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private static BinaryTreeNode<Integer> constructTreeHelper(List<Integer> preOrder,int min,int max){

        if(index>=preOrder.size()){
            return null;
        }
        int key=preOrder.get(index);
        if(key<=min || key>=max){
            return null;
        }

        // If current element of pre[] is in range,
        // then only it is part of the current subtree
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(key);
        index++;

        // All nodes in range {min .. key} go
        // to the left subtree
        root.left = constructTreeHelper(preOrder, min, key);

        // All nodes in range {key .. max} go
        // to the right subtree
        root.right = constructTreeHelper(preOrder, key, max);

        return root;
    }

}
