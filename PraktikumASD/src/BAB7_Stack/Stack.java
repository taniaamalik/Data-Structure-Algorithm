package BAB7_Stack;

public class Stack {

    private List stack;

    public Stack() {
        stack = new List("Infix");
    }

    public void push(Object data) {
        stack.addFirst(data);
    }

    public Object pop() {
        Object head = stack.getHead().data;
        stack.removeFirst();
        return head;
    }

    public Node top() {
        return stack.getHead();
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    public Object peek() {
        Object a = top().data;
        return a;
    }
}