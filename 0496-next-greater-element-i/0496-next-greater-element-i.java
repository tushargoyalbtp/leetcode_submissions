class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[n1];
        
        HashMap<Integer,Integer> nextGreaterElementMap = new HashMap<>();
        
        Stack<Integer> st = new Stack<>(); 
        for(int i=0;i<n2;i++){
            int current = nums2[i];

            while(!st.isEmpty() && current > st.peek()){
                nextGreaterElementMap.put(st.pop(), current);
            }
            st.push(current);
        }

        while(!st.isEmpty()){
            nextGreaterElementMap.put(st.pop(), -1);
        }

        for(int i=0; i<n1; i++){
            ans[i] = nextGreaterElementMap.get(nums1[i]);
        }
        
        // Stack<Integer> stack1 = new Stack<Integer>();
        
        // Stack<Integer> stack2 = new Stack<Integer>();
        
        // for(int i = n1-1 ; i>=0 ; i--){
        //     stack1.push(nums1[i]);
        // }
        // for(int i = n2-1 ; i>=0 ; i--){
        //     stack2.push(nums2[i]);
        // }

        // int k = 0;

        // while(!stack1.isEmpty() && !stack2.isEmpty()){
        //     int x = stack1.peek();
        //     int y = stack2.peek();
        //     if(x >= y){
        //         ans[k] = -1;
        //         k++;
        //         stack1.pop();
        //         stack2.pop();
        //     }
        //     else{

        //         int x2 =  0;
        //         int y2 = y;
        //         while(!stack2.isEmpty() && !stack1.isEmpty() && x<y){
        //             y2 = stack2.peek();
        //             x2 = Math.min(x2, stack2.pop());
        //         }

        //         ans[k] = x2;
        //         k++;
        //     }
        // }

        return ans;


    }
}