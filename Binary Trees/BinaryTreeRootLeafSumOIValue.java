public class BinaryTreeRootLeafSumOIValue {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */

    private static int sumToLeaf(TreeNode<Integer> tree){
        return sumToLeafHelper(tree,0);
    }


    private static int sumToLeafHelper(TreeNode<Integer> tree,int partialSum){
        if(tree==null){
            return 0;
        }

        partialSum=partialSum*2+ tree.data;

        if(tree.left==null && tree.right==null){
            return partialSum;
        }

        return sumToLeafHelper(tree.left,partialSum)+sumToLeafHelper(tree.right,partialSum);
    }
}
