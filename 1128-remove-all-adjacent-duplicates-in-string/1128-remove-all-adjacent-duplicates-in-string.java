class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> str = new Stack<Character>();
        for(int i = 0; i<s.length(); i++){
            if(str.isEmpty() || s.charAt(i) != str.peek())
		        str.push(s.charAt(i));
            else
		        str.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(str.isEmpty()!=true)
            sb.append(str.pop());
        return sb.reverse().toString();
    }
}