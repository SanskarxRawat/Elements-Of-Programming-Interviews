import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeDepthOrder {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    private static List<List<Integer>> binaryTreeDepthOrder(BinaryTreeNode<Integer> root){

        List<List<Integer>> result=new ArrayList<>();

        Deque<BinaryTreeNode<Integer>> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){

            int size=queue.size();

            List<Integer> level=new ArrayList<>();

            for(int i=0;i<size;i++){
                BinaryTreeNode<Integer> node=queue.poll();

                level.add(node.data);

                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }

        return result;
    }
}
