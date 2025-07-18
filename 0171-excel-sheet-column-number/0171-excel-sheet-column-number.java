class Solution {
    public int titleToNumber(String columnTitle) {
        int index = 0;
        

        int length = columnTitle.length();
        int ans = 0;

        for(int i = 0; i < length; i++){
            char ch = columnTitle.charAt(i);
            int value = ch - 'A' + 1;
            ans = ans * 26 + value;
        }

        return ans;
    }
}