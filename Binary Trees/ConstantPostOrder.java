public class ConstantPostOrder {

    public static void postorderTraversal(TreeNodeP<Integer> root) {
        TreeNodeP<Integer> current = root;
        TreeNodeP<Integer> prev = null; // Track the previously visited node

        while (current != null) {
            if (prev == null || prev.left == current || prev.right == current) {
                // Traversing down the tree
                if (current.left != null) {
                    prev = current;
                    current = current.left;
                } else if (current.right != null) {
                    prev = current;
                    current = current.right;
                } else {
                    // No children, visit the node
                    System.out.print(current.data + " ");
                    prev = current;
                    current = current.parent;
                }
            } else if (current.left == prev) {
                // Coming up from the left child
                if (current.right != null) {
                    prev = current;
                    current = current.right;
                } else {
                    // No right child, visit the node
                    System.out.print(current.data + " ");
                    prev = current;
                    current = current.parent;
                }
            } else if (current.right == prev) {
                // Coming up from the right child
                System.out.print(current.data + " ");
                prev = current;
                current = current.parent;
            }
        }
    }
}
