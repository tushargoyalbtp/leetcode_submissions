// class Solution {
//     public int calculate(String s) {
        
//         Stack<Character> st = new Stack<>();

//         int ans = 0;

//         for(int i = s.length() - 1; i >= 0; i--){
//             char ch = s.charAt(i);
//             if(ch != '+' || ch != '*' || ch != '-' || ch != '/'){
                
//                 int digit = ch - '0';
//                 if(ans == 0){
//                     ans = digit;
//                 }
//                 else{
//                     if(!st.isEmpty() && st.peek() == '+'){
//                         ans = ans + digit;
//                         st.pop();
//                     }
//                     else if(!st.isEmpty() && st.peek() == '-'){
//                         ans = ans - digit;
//                         st.pop();
//                     }
//                     else if(!st.isEmpty() && st.peek() == '*'){
//                         ans = ans * digit;
//                         st.pop();
//                     }
//                     else{
//                         ans = ans / digit;
                        
//                     }
                    
//                 }
//             }
//             else{
//                 st.push(s.charAt(i));
//             }
//         }

//         return ans;
//     }
// }


class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char op = '+';
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)) {
                num = num * 10 + (ch - '0'); // handle multi-digit numbers
            }
            
            if((!Character.isDigit(ch) && ch != ' ') || i == s.length()-1) {
                if(op == '+') {
                    stack.push(num);
                } else if(op == '-') {
                    stack.push(-num);
                } else if(op == '*') {
                    stack.push(stack.pop() * num);
                } else if(op == '/') {
                    stack.push(stack.pop() / num);
                }
                
                op = ch; // update operator
                num = 0;
            }
        }
        
        int ans = 0;
        for(int n : stack) ans += n;
        return ans;
    }
}