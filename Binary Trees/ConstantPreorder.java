import java.util.ArrayList;
import java.util.List;

public class ConstantPreorder {

    public static List<Integer> preorderTraversal(TreeNodeP<Integer> root) {
        TreeNodeP<Integer> current = root;

        List<Integer> result=new ArrayList<>();

        while (current != null) {
            // Visit the current node
            result.add(current.data);

            if (current.left != null) {
                current = current.left;
            } else if (current.right != null) {
                current = current.right;
            } else {
                // Backtrack to find an unvisited right child
                while (current.parent != null && (current == current.parent.right || current.parent.right == null)) {
                    current = current.parent;
                }

                // Move to the right child if available
                if (current.parent != null) {
                    current = current.parent.right;
                } else {
                    break;
                }
            }
        }
        return result;
    }

}
