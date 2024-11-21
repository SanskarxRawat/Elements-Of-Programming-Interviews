import java.util.ArrayList;
import java.util.List;

public class ImplementInOrderWithConstant {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    private static List<Integer> inorderTraversal(TreeNodeP<Integer> tree){
        TreeNodeP<Integer> prev=null,curr=tree;

        List<Integer> result=new ArrayList<>();

        while(curr!=null){
            TreeNodeP<Integer> next;
            if (curr. parent == prev) {
                // We came down to curr from prev.
                if (curr. left != null) { // Keep going left.
                    next = curr. left;
                } else {
                    result . add (curr .data) ;
                // Done with left, so go right if right is not empty.
                // Otherwise , go up.
                    next = (curr. right != null) ? curr. right : curr. parent;
                }
            } else if (curr. left == prev) {
                result . add(curr . data) ;
                // Done with left, so go right if right is not empty. Otherwise , go up.
                next = (curr. right != null) ? curr. right : curr. parent;
            } else { // Done with both children , so move up.
                next = curr. parent;
                prev = curr;
                curr = next;
            }
            return result;
        }

        return result;
    }
}
