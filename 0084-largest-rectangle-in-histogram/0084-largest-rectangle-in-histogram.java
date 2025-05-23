class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();

        int length = heights.length;
        int area = 0;

        for(int i = 0; i<length; i++){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                int bar = st.pop(); // index of the bar
                int pse = st.empty() ? -1 : st.peek(); // previous smaller element
                int nse = i; // current index is the next smaller elkement

                area = Math.max(area, heights[bar] * (nse - pse - 1));
            }

            st.push(i);
        }


        // process remaining bars in stack

        while(!st.isEmpty()){
            int bar = st.pop();

            int pse = st.empty() ? -1 : st.peek();
            int nse = length;
            area = Math.max(area, heights[bar] * (nse - pse - 1));
        }

        return area;
    }
}
