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

        return ans;
    }
}