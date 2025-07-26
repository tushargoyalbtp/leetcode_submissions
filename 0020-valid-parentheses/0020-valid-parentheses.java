class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < s.length(); i++){
            
            char ch = s.charAt(i);

            if(!st.isEmpty() && st.peek() == '[' && ch == ']'){
                st.pop();
            }
            else if(!st.isEmpty() && st.peek() == '{' && ch == '}'){
                st.pop();
            }
            else if(!st.isEmpty() && st.peek() == '(' && ch == ')'){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }

        return st.isEmpty() ? true : false;
    }
}