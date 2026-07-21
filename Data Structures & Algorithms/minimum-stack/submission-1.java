class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack=new Stack<Integer>();
        minStack=new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty())
            minStack.push(val);
        else if(val<=minStack.peek())
           minStack.push(val);
        else
           minStack.push(minStack.peek());
    }
    
    public void pop() {
        minStack.pop();
        stack.pop();
    }
    
    public int top() {
       return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
