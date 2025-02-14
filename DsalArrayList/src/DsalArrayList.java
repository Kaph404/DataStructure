/**
 * A generic implementation of an ArrayList-like data structure.
 * BE WARNED, for simplicity, there are no checks for common problems
 * such as out-of-bounds indexes or null values.
 * You should do independent study on Java Generics to understand the use of T.
 *
 * @param <T> the type of elements stored in the list
 */
public class DsalArrayList<T> {

    private int capacity; // Maximum capacity of the list
    private final float capacityMultiplier; // The multiplier used to increase the capacity of the list
    private int size; // Current number of elements in the list
    private Object[] elements; // Array to store elements

    /**
     * Constructs a DsalArrayList object.
     */
    public DsalArrayList() {
        this.capacity = 10;
        this.capacityMultiplier = 1.5f;
        this.size = 0;
        this.elements = new Object[capacity];
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to add
     */
    public void add(T element) {
        add(size, element); // Delegate to the overloaded add method
    }

    /**
     * Adds an element at the specified index in the list.
     * Shifts the existing elements to the right to make space.
     *
     * @param index   the position at which to insert the element
     * @param element the element to add
     */
    public void add(int index, T element) {
        if (size == capacity) { // Ensure the list has spare capacity
            increaseCapacity();
        }
        if (index != size) { // If necessary, shift elements to the right
            for (int i = size; i > index; i--) {
                elements[i] = elements[i - 1];
            }
        }
        elements[index] = element; // Insert the new element
        size++; // Increment the size
    }

    /**
     * Removes the last element from the list and returns it.
     *
     * @return the removed element
     */
    public T remove() {
        return remove(size - 1); // Delegate to the overloaded remove method
    }

    /**
     * Removes the element at the specified index and shifts remaining elements left.
     *
     * @param index the position of the element to remove
     * @return the removed element
     */
    public T remove(int index) {
        T removedElement = (T) elements[index]; // Create a reference to the removed element
        for (int i = index; i < size - 1; i++) { // Shift elements to the left
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null; // Remove the duplicate value from the array
        size--; // Decrement the size
        return removedElement;
    }

    /**
     * Returns the element at the specified index.
     *
     * @param index the position of the element to return
     * @return the element at the specified index
     */
    public T get(int index) {
        return (T) elements[index];
    }

    /**
     * Returns the index of the first occurrence of the specified element in the list.
     * Performs a linear search from the beginning of the list.
     *
     * @param element the element to search for
     * @return the index of the first occurrence of the element, or -1 if not found
     */
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return i; // Return index of element
            }
        }
        return -1; // Element not found
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
     * Increases the capacity of the list when it becomes full.
     */
    private void increaseCapacity() {
        capacity = (int) (capacity * capacityMultiplier);
        Object[] newElements = new Object[capacity];
        // Copy elements to the new array using a loop
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements; // Update the reference to the new array
    }

    /**
     * Returns a string representation of the list.
     * The format follows the pattern: [element1, element2, ..., elementN].
     *
     * @return a string containing all elements in the list, separated by commas
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}