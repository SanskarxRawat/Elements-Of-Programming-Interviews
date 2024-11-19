public class LCABinaryTreeParentPointer {

    /**
     * Time Complexity: O(h)
     * Space Complexity: O(1)
     */


    // This method finds the lowest common ancestor (LCA) of two nodes in a binary tree where nodes have parent pointers.
    public Node lowestCommonAncestor(Node firstNode, Node secondNode) {
        // Initialize two pointers for traversing the ancestors of the given nodes.
        Node pointerA = firstNode;
        Node pointerB = secondNode;

        // Traverse the ancestor chain of both nodes until they meet.
        while (pointerA != pointerB) {
            // If pointerA has reached the root (parent is null), start it at secondNode,
            // otherwise, move it to its parent.
            pointerA = pointerA.parent == null ? secondNode : pointerA.parent;

            // If pointerB has reached the root (parent is null), start it at firstNode,
            // otherwise, move it to its parent.
            pointerB = pointerB.parent == null ? firstNode : pointerB.parent;
        }

        // When pointerA and pointerB meet, we have found the LCA.
        return pointerA;
    }

    static class Node<T>{
        Node<T> left;
        Node<T> right2;
        Node<T> parent;
    }
}
