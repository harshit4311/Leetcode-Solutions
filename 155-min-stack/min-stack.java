class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minQueue;
    
    public MinStack() {
        stack = new ArrayDeque<>();
        minQueue = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);

        if(minQueue.isEmpty() || !minQueue.isEmpty() && val <= minQueue.getFirst()) {
            minQueue.push(val);
        }
    }
    
    public void pop() {
        if(!minQueue.isEmpty() && stack.peek() <= minQueue.getFirst()) {
            minQueue.pop();
        }

        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minQueue.getFirst();
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