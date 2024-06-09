
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    // Initializes the stack object
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Pushes the element val onto the stack
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // Removes the element on the top of the stack
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int removedElement = stack.pop();
        if (removedElement == minStack.peek()) {
            minStack.pop();
        }
    }

    // Gets the top element of the stack
    public int top() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.peek();
    }

    // Retrieves the minimum element in the stack
    public int getMin() {
        if (minStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return minStack.peek();
    }
}