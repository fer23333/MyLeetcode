155. Min Stack 每次如果min 更新 将之前最小值和当前最小值入栈 并更新min, pop时 如果为最小值 pop两次, 并更新min值 也可以使用两个栈
// -2, 0, -3, -5 -> Integer.MAX_VALUE, -2,0,-2,-3, -3,-5

class MinStack {
    private Deque<Integer> stack;
    private int min;
    // -2 0 -3 -5 -6
    // maxval -2 0 -2 -3 -3 -5 
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if(stack.pop() == min){
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
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
