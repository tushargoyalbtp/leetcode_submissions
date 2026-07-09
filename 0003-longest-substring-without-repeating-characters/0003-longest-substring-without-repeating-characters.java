class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int length = s.length();
        int ans = 0;

        HashMap<Character,Integer> mapChar = new HashMap<Character,Integer>();

        while(i < s.length()){
            char ch  = s.charAt(i);

            if(mapChar.containsKey(ch)){
                j = Math.max(j, mapChar.get(ch)+1);
            }
            mapChar.put(ch, i);
            ans = Math.max(ans, i-j+1);
            i++;
        }

        return ans;
    }
}