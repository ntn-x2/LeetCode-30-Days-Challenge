// Exceptions are ignored.
class MinStack {

    private class StackNode<T extends Comparable<T>> {
        T value;
        T stackMin;
        
        StackNode(T value, T stackMin) {
            this.value = value;
            this.stackMin = stackMin;
        }
    }
    
    private Stack<StackNode<Integer>> elements;
    
    /** initialize your data structure here. */
    public MinStack() {
        this.elements = new Stack<>();
    }
    
    public void push(int x) {
        int newMinValue = this.elements.isEmpty() ? x : Math.min(x, this.elements.peek().stackMin);
        elements.push(new StackNode<Integer>(x, newMinValue));
    }
    
    public void pop() {
        this.elements.pop();
    }
    
    public int top() {
        return this.elements.peek().value;
    }
    
    public int getMin() {
        return this.elements.peek().stackMin;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */