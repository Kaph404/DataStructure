/**
 * A generic deque (double-ended queue) implementation using a circular array.
 * Supports adding and removing elements from both ends in constant time.
 *
 * @param <T> the type of elements stored in the deque
 */
public class DsalArrayDeque<T> {
    private int capacity; // Maximum capacity of the deque
    private final float capacityMultiplier; // Multiplier used for resizing
    private int size; // Number of elements in the deque
    private int front; // Index of the front element
    private int rear; // Index of the rear element
    private Object[] elements; // Circular array to store elements

    /**
     * Constructs an empty deque with an initial capacity of 16.
     */
    public DsalArrayDeque() {
        this.capacity = 16;
        this.capacityMultiplier = 1.5f;
        this.size = 0;
        this.front = 0;
        this.rear = -1;
        this.elements = new Object[capacity];
    }

    /**
     * Adds an element at the front of the deque.
     *
     * @param element the element to add
     */
    public void addFirst(T element) {
        if (size == capacity) {
            increaseCapacity();
        }
        front = (front - 1 + capacity) % capacity;
        elements[front] = element;
        size++;
    }

    /**
     * Adds an element at the rear of the deque.
     *
     * @param element the element to add
     */
    public void addLast(T element) {
        if (size == capacity) {
            increaseCapacity();
        }
        rear = (rear + 1) % capacity;
        elements[rear] = element;
        size++;
    }

    /**
     * Removes and returns the first element from the deque.
     *
     * @return the removed element
     * @throws IllegalStateException if the deque is empty
     */
    public T removeFirst() {
        if (size == 0) {
            throw new IllegalStateException("Deque is empty");
        }
        T removedElement = (T) elements[front];
        elements[front] = null; // Avoid memory leak
        front = (front + 1) % capacity;
        size--;
        return removedElement;
    }

    /**
     * Removes and returns the last element from the deque.
     *
     * @return the removed element
     * @throws IllegalStateException if the deque is empty
     */
    public T removeLast() {
        if (size == 0) {
            throw new IllegalStateException("Deque is empty");
        }
        T removedElement = (T) elements[rear];
        elements[rear] = null; // Avoid memory leak
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return removedElement;
    }

    /**
     * Returns the first element without removing it.
     *
     * @return the first element
     * @throws IllegalStateException if the deque is empty
     */
    public T getFirst() {
        if (size == 0) {
            throw new IllegalStateException("Deque is empty");
        }
        return (T) elements[front];
    }

    /**
     * Returns the last element without removing it.
     *
     * @return the last element
     * @throws IllegalStateException if the deque is empty
     */
    public T getLast() {
        if (size == 0) {
            throw new IllegalStateException("Deque is empty");
        }
        return (T) elements[rear];
    }

    /**
     * Returns the current number of elements in the deque.
     *
     * @return the size of the deque
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the deque is empty.
     *
     * @return true if the deque is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Increases the capacity of the deque when it becomes full.
     */
    private void increaseCapacity() {
        int newCapacity = (int) (capacity * capacityMultiplier);
        Object[] newElements = new Object[newCapacity];

        // Copy elements to new array while maintaining order
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[(front + i) % capacity];
        }

        elements = newElements;
        capacity = newCapacity;
        front = 0;
        rear = size - 1;
    }

    /**
     * Returns a string representation of the deque.
     *
     * @return a string containing all elements in the deque
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[(front + i) % capacity]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}