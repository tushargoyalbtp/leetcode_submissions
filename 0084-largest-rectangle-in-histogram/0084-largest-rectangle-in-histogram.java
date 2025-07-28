class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack<>();

        int maxArea =  0;
        int n  = heights.length;


        for(int i = 0 ; i <= n; i++){
            int currentheight = (i == n) ? 0 : heights[i];

            while(!st.isEmpty() && heights[st.peek()] > currentheight){
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxArea = Math.max(maxArea, height*width);
            }

            st.push(i);

        }

        return maxArea;
        // if(heights.length == 0 ){
        //     return 0;
        // }

        // if( heights.length == 1 ){
        //     return heights[0];
        // }
        
        // HashMap<Integer,Integer> map = new HashMap<>();
        // int max1 = Integer.MIN_VALUE;
        // int max2 = Integer.MIN_VALUE;

        // for(int i = 0 ; i < heights.length; i++) {
        //     map.put(heights[i], i);
        //     max1 = Math.max(max1, heights[i]);
        // }

        // for(int i = 0; i < heights.length; i++){
        //     if(heights[i] == max1){
        //         heights[i] = -1;
        //         break;
        //     }
        // }

        // for(int i = 0 ; i < heights.length; i++) {
        //     max2 = Math.max(max2, heights[i]);
        // }

        // int maxAreaa = Integer.MIN_VALUE;
        // System.out.println(max1+ " " + max2);



        // System.out.println(map.get(max1)+ " ----  indexs  ---- " + map.get(max2));

        // int breadth = Math.abs(map.get(max1) - map.get(max2))  + 1;

        // System.out.println(breadth);

        // int length = Math.min(max1, max2);
        // return breadth * length;

    }
}