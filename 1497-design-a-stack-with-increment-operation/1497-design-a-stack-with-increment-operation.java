class CustomStack {
    List<Integer> stack;
    int size = 0;

    public CustomStack(int maxSize) {
        this.stack = new ArrayList<>();
        this.size = maxSize;
    }

    public void push(int x) {
        if (stack.size() < size) {
            stack.add(x);
        }
    }

    public int pop() {
        if(!stack.isEmpty()){
            return stack.remove(stack.size() - 1);
        }
        return -1;
    }

    public void increment(int k, int val) {
        int limit = Math.min(k, stack.size());
        for (int i = 0; i < limit; i++) {
            stack.set(i, stack.get(i) + val);
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