class MinStack {
    public Stack<Integer> stack;
    public Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();    
    }
    
    public void push(int val) {

        // Push val in 'stack'
        stack.push(val); 

        // Push val in 'minStack'
        if(minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }

    }
    
    public void pop() {

        if(stack.isEmpty()) {
            return;
        }

        int removedElement = stack.pop();
        if(removedElement == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {

        if (stack.isEmpty()) {
            return -1; // No elements to show the top-most element in the stack
        }

        return stack.peek();
    }
    
    public int getMin() {
         if (minStack.isEmpty()) {
            return -1; // No elements to show the minimum element of the stack
        }
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */