public class DeleteNodeFromList {

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */

    public static void deleteFromList(LinkedList<Integer> nodeToDelete){
        nodeToDelete.setData(nodeToDelete.getNext().getData());
        nodeToDelete.setNext(nodeToDelete.getNext().getNext());
    }
}
