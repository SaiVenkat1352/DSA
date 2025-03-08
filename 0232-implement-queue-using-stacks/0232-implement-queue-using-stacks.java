class MyQueue {
    Stack<Integer> st1=new Stack<Integer>();
    Stack<Integer> st2=new Stack<Integer>();
    public void push(int x) {
        if(!st1.isEmpty())copy(st1,st2);
        st1.add(x);
        if(!st2.isEmpty())copy(st2,st1);

       
    }
    public void copy(Stack<Integer> first,Stack<Integer> second)
    {
        while(!first.isEmpty())
        {
            second.add(first.pop());
        }
    }

    public int pop() {
        return st1.pop();
        
    }

    public int peek() {
        return st1.peek();
       
    }

    public boolean empty() {
        return st1.isEmpty();
       
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */