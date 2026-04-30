class MinStack {

    Stack<Integer> st = new Stack<>(), min = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        st.add(val);
        if(min.isEmpty() || val<min.peek()){
            min.add(val);
        } else{
            min.add(min.peek());
        }
    }
    
    public void pop() {
        if(!st.isEmpty()) {
            st.pop();
            min.pop();
        }
    }
    
    public int top() {
        if(!st.isEmpty()) return st.peek();
        return -1;
    }
    
    public int getMin() {
        if(min.isEmpty()==false) return min.peek();
        return -1;
    }
}
