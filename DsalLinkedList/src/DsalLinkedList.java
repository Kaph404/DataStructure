/**
 * A generic implementation of a Doubly Linked List.
 * BE WARNED, for simplicity, there are no checks for common problems
 * such as out-of-bounds indexes or null values.
 * You should do independent study on Java Generics to understand the use of T.
 *
 * @param <T> the type of elements stored in the list
 */
public class DsalLinkedList<T> {

    private class Node {
        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head; // First element of the list
    private Node tail; // Last element of the list
    private int size;  // Number of elements in the list

    /**
     * Constructs an empty DsalLinkedList.
     */
    public DsalLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to add
     */
    public void add(T element) {
        add(size, element);
    }

    /**
     * Adds an element at the specified index in the list.
     *
     * @param index   the position at which to insert the element
     * @param element the element to add
     */
    public void add(int index, T element) {
        Node newNode = new Node(element);
        if (head != null) {
            if (index == 0) { // Insert at the head
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else if (index == size) { // Insert at the tail
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } else { // Insert in the middle
                Node current = getNode(index);
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
            size++;
        }

    }

    /**
     * Removes the last element from the list and returns it.
     *
     * @return the removed element
     */
    public T remove() {
        return remove(size - 1);
    }

    /**
     * Removes the element at the specified index.
     *
     * @param index the position of the element to remove
     * @return the removed element
     */
    public T remove(int index) {
        Node elementToRemove = getNode(index);
        if (head == null) {
            return null;
        } else if (size == 1) {
            head = tail = null;
        } else if (index == 0) {
            elementToRemove.next.prev = null;
            head = elementToRemove.next;
        } else if (index == size - 1) {
            elementToRemove.prev.next = null;
            tail = elementToRemove.prev;
        } else {
            elementToRemove.prev.next = elementToRemove.next;
            elementToRemove.next.prev = elementToRemove.prev;
        }
        size--;
        return elementToRemove.data;
    }

    /**
     * Returns the element at the specified index.
     *
     * @param index the position of the element to return
     * @return the element at the specified index
     */
    public T get(int index) {
        if (index < size / 2) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        } else {
            Node current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
            return current.data;
        }
    }

    /**
     * Returns the index of the first occurrence of the specified element in the list.
     *
     * @param element the element to search for
     * @return the index of the first occurrence, or -1 if not found
     */
    public int indexOf(T element) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the current number of elements in the list.
     *
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Retrieves the node at a specified index.
     *
     * @param index the index of the node to retrieve
     * @return the node at the given index
     */
    private Node getNode(int index) {
        if (index < size / 2) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        } else {
            Node current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
            return current;
        }
    }

    /**
     * Returns a string representation of the list.
     *
     * @return a string containing all elements in the list, separated by commas
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}