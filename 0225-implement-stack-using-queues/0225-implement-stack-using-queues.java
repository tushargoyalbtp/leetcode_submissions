class MyStack {

    Queue<Integer> pq1;
    Queue<Integer> pq2;

    public MyStack() {
        pq1 = new LinkedList<>();
        pq2 = new LinkedList<>();
    }
    
    public void push(int x) {
        // Step 1: Add to pq2
        pq2.offer(x);

        // Step 2: Transfer all from pq1 to pq2
        while(!pq1.isEmpty()) {
            pq2.offer(pq1.poll());
        }

        // Step 3: Swap pq1 and pq2
        Queue<Integer> temp = pq1;
        pq1 = pq2;
        pq2 = temp;
    }
    
    public int pop() {
        return pq1.isEmpty() ? -1 : pq1.poll();
    }
    
    public int top() {
        return pq1.isEmpty() ? -1 : pq1.peek();
    }
    
    public boolean empty() {
        return pq1.isEmpty();
    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */