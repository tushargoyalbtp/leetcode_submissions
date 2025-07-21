class CustomStack {
    private int[] stack;
    private int size;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        size = 0;
    }
    
    public void push(int x) {
        if (size < stack.length) {
            stack[size++] = x;
        }
    }
    
    public int pop() {
        if (size == 0) {
            return -1;
        }
        return stack[--size];
    }
    
    public void increment(int k, int val) {
        int limit = Math.min(k, size);
        for (int i = 0; i < limit; i++) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */