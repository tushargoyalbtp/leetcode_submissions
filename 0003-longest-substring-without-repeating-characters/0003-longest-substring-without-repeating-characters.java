class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int ans = 0;

        HashMap<Character,Integer> map = new HashMap<>();
        while (i < s.length()) {
            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                // Move start pointer j to right of last occurrence of ch
                j = Math.max(map.get(ch) + 1, j);
            }

            map.put(ch, i);
            ans = Math.max(ans, i - j + 1);
            i++;
        }

        return ans;
    }
}