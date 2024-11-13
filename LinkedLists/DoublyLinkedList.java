public class DoublyLinkedList<T extends Comparable<T>> {
    private T data;
    private DoublyLinkedList<T> next;
    private DoublyLinkedList<T> prev;

    public DoublyLinkedList(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public T getData() {
        return data;
    }

    public DoublyLinkedList<T> getNext() {
        return next;
    }

    public void setNext(DoublyLinkedList<T> next) {
        this.next = next;
    }

    public DoublyLinkedList<T> getPrev() {
        return prev;
    }

    public void setPrev(DoublyLinkedList<T> prev) {
        this.prev = prev;
    }

    // Method to print the doubly linked list
    public void printList() {
        DoublyLinkedList<T> current = this;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void setData(T data) {
        this.data = data;
    }
}
