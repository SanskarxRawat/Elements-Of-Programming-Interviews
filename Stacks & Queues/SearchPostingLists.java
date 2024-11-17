import java.util.Deque;
import java.util.LinkedList;

public class SearchPostingLists {

    /**
     * Jump Order In Single LinkedList
     */

    /**
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    private static void setJumpOrder(PostingLists<Integer> l){
        setJumpOrderHelper(l,0);
    }


    private static int setJumpOrderHelper(PostingLists<Integer> l,int order){
        if (l != null && l.order == -1) {
            l.order = order++;
            order = setJumpOrderHelper(l.jump , order);
            order = setJumpOrderHelper(l.next , order);
        }
        return order;
    }


    static class PostingLists<T>{
        T data;
        PostingLists<T> next;
        PostingLists<T> jump;
        int order;

    }


    private static void setJumpOrder2(PostingLists<Integer> L){
        Deque<PostingLists<Integer>> s = new LinkedList<>();
        int order = 0;
        s.addFirst(L);
        while(!s.isEmpty()){
            PostingLists<Integer> curr = s.removeFirst();
            if (curr != null && curr.order == -1) {
                curr.order = order++;
                // Stack is last-in, first -out, and we want to process
                // the jump node first, so push next, then push jump.
                s.addFirst(curr.next);
                s.addFirst(curr.jump);
            }
        }
    }
}
