public class Stack{
    DsalLinkedList<Integer> stack = new DsalLinkedList<>();

    public void push(int x){
        stack.add(x);
    }

    public int pop(){
        stack.remove(stack.size()-1);
        return stack.get(stack.size()-1);
    }

    public int top(){
        return stack.get(stack.size()-1);
    }


}
