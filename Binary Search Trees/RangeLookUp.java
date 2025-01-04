import java.util.ArrayList;
import java.util.List;

public class RangeLookUp {

    /**
     * Write a program that takes as input a BST and an interval and returns the BST keys
     * that lie in the interval. For example, for the tree in Figure 15.1 on Page 255, and
     * interval [16,31], you should return 17,19, 23, 29, 31.
     */


    /**
     * Approach:
     * 1. If the root lies in the interval, then recursively look for the keys in the left and right subtrees.
     * 2. If the root is less than the start of the interval, then the keys in the left subtree cannot lie in the interval.
     *
     *
     * Time Complexity: O(h+k) h is the height of the tree and k is the number of keys in the interval.
     * Space Complexity: O(h+k)
     *
     */


    static class Interval{
        int start;
        int end;
        Interval(int start, int end){
            this.start=start;
            this.end=end;
        }
    }


    public static List<Integer> rangeLookUp(BinaryTreeNode<Integer> root, Interval interval) {
        List<Integer> result = new ArrayList<>();
        rangeLookUpHelper(root, interval, result);
        return result;
    }


    private static void rangeLookUpHelper(BinaryTreeNode<Integer> root, Interval interval, List<Integer> result){
        if(root==null){
            return;
        }
        if(root.data>=interval.start && root.data<=interval.end){
            // tree.data lies in the interval
            rangeLookUpHelper(root.left, interval, result);
            result.add(root.data);
            rangeLookUpHelper(root.right, interval, result);
        }else if(interval.start>root.data){
            rangeLookUpHelper(root.right, interval, result);
        }else{ // interval.right >= tree.data
            rangeLookUpHelper(root.left, interval, result);
        }
    }
}
