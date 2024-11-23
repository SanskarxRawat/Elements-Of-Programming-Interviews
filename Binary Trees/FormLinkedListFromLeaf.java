import java.util.ArrayList;
import java.util.List;

public class FormLinkedListFromLeaf {

    /**
     *  Time Complexity: O(n)
     *  Space Complexity: O(n)
     */

    public static List<BinaryTreeNode<Integer>> createListOfLeaves(BinaryTreeNode<Integer> tree){
        List<BinaryTreeNode<Integer>> leaves=new ArrayList<>();
        addLeavesLeftToRight(tree,leaves);
        return leaves;
    }

    private static void addLeavesLeftToRight(BinaryTreeNode<Integer> tree,List<BinaryTreeNode<Integer>> leaves){
        if(tree!=null){
            if(tree.left==null && tree.right==null){
                leaves.add(tree);
            }else{
                addLeavesLeftToRight(tree.left,leaves);
                addLeavesLeftToRight(tree.right,leaves);
            }
        }
    }
}
