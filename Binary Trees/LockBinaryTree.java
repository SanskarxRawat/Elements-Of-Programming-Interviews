public class LockBinaryTree<T> {

    /**
     * Time Complexity:
     *   1. Locking : O(h)
     *   2. Unlocking : O(h)
     *
     */
    private LockBinaryTree<T> left;
    private LockBinaryTree<T> right;
    private LockBinaryTree<T> parent;
    private boolean locked;
    private int numLockedDescendants;

    public boolean isLocked(){
        return locked;
    }

    public boolean lock(){
        // file cannot lock if any of this node’s descendants are locked.
        if(numLockedDescendants>0 || locked){
            return false;
        }
        // file cannot lock if any of this node’s descendants are locked.
        for(LockBinaryTree<T> iter=parent;iter!=null;iter=iter.parent){
            if(iter.isLocked()){
                return false;
            }
        }
        // Lock this node and increments all its ancestors’s descendant lock
        // counts.
        locked = true;
        for (LockBinaryTree<T> iter = parent; iter != null; iter = iter.parent) {
            ++iter.numLockedDescendants ;
        }
        return true ;
    }

    public void unlock(){
        if (locked) {
            // Unlocks itself and decrements its ancestors ’s descendant lock counts.
            locked = false;
            for (LockBinaryTree<T> iter = parent; iter != null; iter = iter.parent) {
                --iter.numLockedDescendants ;
            }
        }
    }

}
