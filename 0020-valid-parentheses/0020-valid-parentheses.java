class Solution {
    public boolean isValid(String s) {
        if(s.length() <= 1){
            return false;
        }
        Stack<Character> st = new Stack<Character>();
        st.push(s.charAt(0));

        for(int i = 1; i < s.length(); i++){
            
            if(!st.isEmpty() && ((st.peek() == '(' && s.charAt(i) == ')') || (st.peek() == '{' && s.charAt(i) == '}')
                || (st.peek() == '[' && s.charAt(i) == ']'))){
                    st.pop();
            }
            else{
                st.push(s.charAt(i));
            } 
        }

        return st.isEmpty()? true : false;
    }
}