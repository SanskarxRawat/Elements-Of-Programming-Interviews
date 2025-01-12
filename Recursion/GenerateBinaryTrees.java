import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryTrees {

    /**
     * Write a program which returns all distinct binary trees with a specified number of
     * nodes.
     *
     *
     * Approach: Recursive
     * 1. For each node, there are two possibilities, either left or right.
     *
     * The number of distinct binary trees with n nodes is the nth Catalan number.
     * Time Complexity: O(4^n/n^(3/2))
     * Space Complexity: O(n*4^n/n^(3/2))
     *
     */

    public static List<BinaryTreeNode<Integer>> generateAllBinaryTrees(int numNodes) {
        List<BinaryTreeNode<Integer>> result = new ArrayList<>();
        if (numNodes == 0) {
            result.add(null);
        }
        for (int numLeftTreeNodes = 0; numLeftTreeNodes < numNodes; numLeftTreeNodes++) {
            int numRightTreeNodes = numNodes - 1 - numLeftTreeNodes;
            List<BinaryTreeNode<Integer>> leftSubtrees = generateAllBinaryTrees(numLeftTreeNodes);
            List<BinaryTreeNode<Integer>> rightSubtrees = generateAllBinaryTrees(numRightTreeNodes);
            for (BinaryTreeNode<Integer> left : leftSubtrees) {
                for (BinaryTreeNode<Integer> right : rightSubtrees) {
                    result.add(new BinaryTreeNode<>(0, left, right));
                }
            }
        }
        return result;
    }

}
