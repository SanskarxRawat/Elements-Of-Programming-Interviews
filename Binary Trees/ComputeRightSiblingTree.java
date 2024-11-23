public class ComputeRightSiblingTree {

    /**
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     *
     */

    public static void constructRightSiblingTree(BinaryTreeNode <Integer> tree){
        BinaryTreeNode<Integer> leftStart=tree;

        while (leftStart!=null && leftStart.left!=null){
            populateLowerNextLevelField(leftStart);
            leftStart=leftStart.left;
        }
    }


    private static void populateLowerNextLevelField(BinaryTreeNode<Integer> startNode) {

        BinaryTreeNode<Integer> iter = startNode;
        while (iter != null) {
            // Populate left child’s next field.
            iter.left.next = iter.right;
            // Populate right child’s next field if iter is not the last node of this
            // level .
            if (iter.next != null) {
                iter.right.next = iter.next.left;
            }
            iter = iter.next;

        }
    }

    /**
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     *
     */
    public static void constructRightSiblingTreeWithoutNextPointer(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        BinaryTreeNode<Integer> currentLevelStart = root;

        // Process each level
        while (currentLevelStart != null) {
            BinaryTreeNode<Integer> current = currentLevelStart;

            // Traverse nodes at the current level
            while (current != null) {
                // Connect left child's right pointer to the right child
                if (current.left != null) {
                    current.left.right = current.right;
                }

                // Connect right child's right pointer to the next node's left child
                if (current.right != null && current.right != null) {
                    if (current.right != null) {
                        current.right.right = (current.right != null) ? current.right.left : null;
                    }
                }

                // Move to the next node in the current level
                current = current.right;
            }

            // Move to the next level
            currentLevelStart = currentLevelStart.left;
        }
    }
}

