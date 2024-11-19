import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ImplementInorderWithoutRecursion {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */

    public static List<Integer> BSTInSortedOrder (TreeNode<Integer> tree) {
        Deque<TreeNode< Integer>> s= new LinkedList<>();
        TreeNode<Integer> curr = tree;
        List<Integer> result = new ArrayList<>();
        while (!s.isEmpty() || curr != null) {
            if (curr != null) {
                s.addFirst(curr);
            // Going left.
                curr = curr.left;
            } else {
            // Going up .
                curr = s.removeFirst();
                result.add(curr.data);
            // Going right.
                curr = curr.right;
            }
        }
        return result;
    }
}
