import java.util.List;

public class ReconstructBinaryTreePreorderMarkers {

    /**
     * Time Complexity: O(
     */
    // Global variable , tracks current subtree.
    private static Integer subtreeldx;


    public static BinaryTreeNode <Integer> reconstructPreorder (List<Integer> preorder) {
        subtreeldx = 0;
        return reconstructPreorderSubtree (preorder) ;
    }
    // Reconstructs the subtree that is rooted at subtreeldx .
    private static BinaryTreeNode<Integer> reconstructPreorderSubtree (List<Integer> preorder) {
        Integer subtreeKey = preorder.get(subtreeldx);
        ++subtreeldx;
        if (subtreeKey == null) {
            return null;
        }
        // Note that reconstructPreorderSubtree updates subtreeldx. So the order of
        // following two calls are critical.
        BinaryTreeNode<Integer> leftSubtree = reconstructPreorderSubtree(preorder);
        BinaryTreeNode<Integer> rightSubtree = reconstructPreorderSubtree(preorder);
        return new BinaryTreeNode<Integer>(subtreeKey, leftSubtree, rightSubtree);
    }


}
