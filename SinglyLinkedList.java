public class SinglyLinkedList<T> {
    public int length;
    private Node<T> head;
    SinglyLinkedList() {
        this.head = null;
        this.length = 0;
    }

    public void prepend(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void insertAt(T item, int index) {

        if (index == 0){
            prepend(item);
            return;
        }

        Node<T> newNode = new Node<>(item);
        Node<T> currentNode = head;

        for(int i = 0; i < index - 1; i++){
            currentNode = currentNode.next;
            if (currentNode.next == null) {
                throw new IndexOutOfBoundsException();
            }
        }

        newNode.next = currentNode.next;
        currentNode.next = newNode;
        length++;
    }

    public void append(T item) {

        if (head == null) {
            prepend(item);
            return;
        }

        Node<T> currentNode = head;
        Node<T> newNode = new Node<>(item);

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
        length++;

}

    public T remove(T item) {

        if (head.data.equals(item)) {
            Node<T> removedNode = head;
            head = head.next;
            return removedNode.data;
        }

        Node<T> currentNode = head;

        while (currentNode.next != null && !currentNode.next.data.equals(item)) {
            currentNode = currentNode.next;
        }

        if (currentNode.next == null) {
            throw new IllegalArgumentException("Item not found in the list");
        }

        Node<T> removedNode = currentNode.next;
        currentNode.next = currentNode.next.next;

        length--;
        return removedNode.data;
    }


    public T get(int index) {

        Node<T> currentNode = head;
        for(int i = 0; i < index; i++){
            if (currentNode.next == null) {
                throw new IndexOutOfBoundsException("Index is out of bounds");
            }
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }

    public T removeAt(int index) {

        if (index == 0){
            Node<T> removedNode = head;
            head = head.next;
            return removedNode.data;
        }

        Node <T> currentNode = head;

        for(int i = 0; i < index - 1; i ++) {
            if (currentNode.next == null){
                throw new IndexOutOfBoundsException("Index is out of bounds");
            }
            currentNode = currentNode.next;
        }

        Node <T> removedNode = currentNode.next;
        currentNode.next = currentNode.next.next;

        length--;
        return removedNode.data;
    }

}
