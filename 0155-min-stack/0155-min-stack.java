class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    //If both stacks empty then push to both
    //Else Compare minstack peek and new val for push in minstack
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()) {
            minStack.push(val);
        } else {
            int min = Math.min(minStack.peek(), val);
            minStack.push(min);
        }
    }
    //Remove the top from both stacks
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
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