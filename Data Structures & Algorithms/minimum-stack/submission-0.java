class MinStack {

    Stack<Integer> main;
    Stack<Integer> min;

    public MinStack() {
        main = new Stack();
        min = new Stack();
    }
    
    public void push(int val) {
        main.push(val);
        if(min.isEmpty()){
            min.push(val);
        }else{
            min.push(Math.min(min.peek(), val));
        }
    }
    
    public void pop() {
        min.pop();
        main.pop();
    }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
