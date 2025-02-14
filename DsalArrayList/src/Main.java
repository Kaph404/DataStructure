public class Main {
    public static void main(String[] args) {

        // Create a new list
        DsalArrayList<Integer> list = new DsalArrayList<>();
        System.out.println("Testing DsalLinkedList...");

        // Test adding elements
        System.out.println("Adding elements: 1 to 10 to end");
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        System.out.println("Current List: " + list);

        // Test adding at specific indices
        System.out.println("Adding 100 at start");
        list.add(0, 100);
        System.out.println("Current List: " + list);

        System.out.println("Adding 300 at end");
        list.add(list.size(), 300);
        System.out.println("Current List: " + list);

        System.out.println("Adding 200 at middle");
        list.add(list.size() / 2, 200);
        System.out.println("Current List: " + list);

        // Test retrieving elements
        System.out.println("Element at start: " + list.get(0));
        System.out.println("Element at middle: " + list.get(list.size() / 2));
        System.out.println("Element at end: " + list.get(list.size() - 1));

        // Test indexOf method
        System.out.println("Index of 100: " + list.indexOf(100));
        System.out.println("Index of 200: " + list.indexOf(200));
        System.out.println("Index of 300: " + list.indexOf(300));
        System.out.println("Index of 1000 (not in list): " + list.indexOf(1000));


        // Test removing first, last, and middle elements

        System.out.println("Removing element from the middle...");
        list.remove(list.size() / 2);
        System.out.println("Current List: " + list);

        System.out.println("Removing first element...");
        list.remove(0);
        System.out.println("Current List: " + list);

        System.out.println("Removing last element...");
        list.remove(list.size() - 1);
        System.out.println("Current List: " + list);

        // Test removing until empty
        while (list.size() > 0) {
            System.out.println("Removing: " + list.remove(0));
        }
        System.out.println("Final List (should be empty): " + list);
        System.out.println("Size: " + list.size());

        System.out.println("All tests completed successfully!");
    }
}
