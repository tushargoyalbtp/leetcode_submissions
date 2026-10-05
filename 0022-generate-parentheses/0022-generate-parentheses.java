class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        helperFunction(ans, 0, 0, n, "");
        return ans;
    }

    public void helperFunction(List<String> ans, int open, int close , int n, String str){
        if(open == n && close == n){
            ans.add(str);
            return;
        }

        if(open<n){
            helperFunction(ans, open+1, close, n, str+"(");
        }

        if(close<open){
            helperFunction(ans, open, close+1, n, str+")");
        }

    }
}