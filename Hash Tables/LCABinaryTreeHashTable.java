import java.util.HashSet;
import java.util.Set;

public class LCABinaryTreeHashTable {


    public static TreeNodeP<Integer> LCA(TreeNodeP<Integer> nodeOne,TreeNodeP<Integer> nodeTwo){

        Set<TreeNodeP<Integer>> visited=new HashSet<>();

        while(nodeOne!=null || nodeTwo!=null){
            //Ascend tree in tandem from these two nodes

            if(nodeOne!=null){
                if(!visited.add(nodeOne)){
                    return nodeOne;
                }
                nodeOne=nodeOne.parent;
            }

            if(nodeTwo!=null){
                if(!visited.add(nodeTwo)){
                    return nodeTwo;
                }
                nodeTwo=nodeTwo.parent;
            }
        }

        throw new IllegalArgumentException (
                "nodeOne and nodeTwo are not in the same tree");
    }
}
