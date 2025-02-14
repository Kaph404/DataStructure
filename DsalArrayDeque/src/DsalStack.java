public class DsalStack<T> {
    DsalArrayDeque<T> stack;

    public DsalStack() {
        stack = new DsalArrayDeque<>();
    }

    public void push(T t) {
        stack.addLast(t);
    }

    public T pop() {
        return stack.removeLast();
    }

    public T peek() {
        return stack.getLast();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
