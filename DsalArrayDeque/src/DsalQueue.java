public class DsalQueue<T> {
    DsalArrayDeque<T> queue;

    public DsalQueue() {
        queue = new DsalArrayDeque<>();
    }

    public void enqueue(T input) {
        queue.addLast(input);
    }

    public T dequeue(){
        return queue.removeFirst();
    }

    public T peek(){
        return queue.getFirst();
    }

    public int size(){
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
