public class LinkedList<T> {
    private T data;
    private LinkedList<T> next;

    public LinkedList(T data){
        this.data=data;
    }

    public LinkedList(T data,LinkedList<T> next){
        this.data=data;
        this.next=next;
    }

    public LinkedList<T> search(LinkedList<T> list, T key){
        while(list!=null && list.data!=key){
            list=list.next;
        }

        return list;
    }

    // Method to insert data at the end of the linked list
    public void insertAtEnd(T data) {
        LinkedList<T> newNode = new LinkedList<>(data);
        if (this.data == null) { // If the current list is empty
            this.data = data;
            this.next = null;
            return;
        }

        LinkedList<T> current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Method to delete a node by key
    public void delete(T key) {
        LinkedList<T> current = this;
        LinkedList<T> previous = null;

        // If the key is in the head node
        if (current != null && current.data.equals(key)) {
            if (current.next != null) {
                this.data = current.next.data;
                this.next = current.next.next;
            } else {
                // If there is no other element in the list, just clear the data
                this.data = null;
                this.next = null;
            }
            return;
        }

        // Traverse the list to find the key to be deleted
        while (current != null && !current.data.equals(key)) {
            previous = current;
            current = current.next;
        }

        // If the key was not found
        if (current == null) {
            return;
        }

        // Remove the node
        previous.next = current.next;
    }

    // Method to get the size of the linked list
    public int size() {
        int count = 0;
        LinkedList<T> current = this;

        while (current != null && current.data != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Method to check if the linked list is empty
    public boolean isEmpty() {
        return this.data == null;
    }

    // Method to print the linked list
    public void printList() {
        LinkedList<T> current = this;
        while (current != null && current.data != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedList<T> getNext() {
        return next;
    }

    public void setNext(LinkedList<T> next) {
        this.next = next;
    }
}
