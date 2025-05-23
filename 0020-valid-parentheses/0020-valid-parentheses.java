class Solution {
    public boolean isValid(String str) {
        Stack<Character> sc = new Stack<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                sc.push(ch);
            } else {
                if (sc.isEmpty()) return false;
                char top = sc.pop();
                if ((ch == ')' && top != '(') || 
                    (ch == '}' && top != '{') || 
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return sc.isEmpty();
    }
}