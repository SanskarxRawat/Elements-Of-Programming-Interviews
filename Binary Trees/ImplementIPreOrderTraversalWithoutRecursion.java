import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ImplementIPreOrderTraversalWithoutRecursion {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */

    public static List<Integer> BSTInSortedOrder (TreeNode<Integer> tree) {
        Deque<TreeNode< Integer>> path= new LinkedList<>();
        path.addFirst(tree);

        List<Integer> result=new ArrayList<>();

        while(!path.isEmpty()){
            TreeNode<Integer> curr=path.removeFirst();
            if(curr!=null){
                result.add(curr.data);
                path.addFirst(curr.right);
                path.addFirst(curr.left);
            }
        }

        return result;
    }
}
