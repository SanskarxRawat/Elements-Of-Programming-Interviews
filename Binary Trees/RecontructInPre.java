import java.util.HashMap;
import java.util.Map;

public class RecontructInPre {


    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n+h)
     */

    Map<Integer,Integer> m;
    public TreeNode<Integer> buildTree(int[] preorder, int[] inorder) {
        m=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            m.put(inorder[i],i);
        }

        TreeNode<Integer> root=buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return root;

    }
    public TreeNode<Integer> buildTree(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){

        if(preStart>preEnd || inStart>inEnd) return null;
        TreeNode<Integer> root=new TreeNode<Integer>(preorder[preStart]);

        int inRoot=m.get(root.data);
        int numsleft=inRoot-inStart;

        root.left=buildTree(preorder,preStart+1,preStart+numsleft,inorder,inStart,inRoot-1);
        root.right=buildTree(preorder,preStart+numsleft+1,preEnd,inorder,inRoot+1,inEnd);

        return root;

    }
}
