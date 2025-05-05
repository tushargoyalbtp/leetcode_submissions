class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int ans = 0;

        HashMap<Character,Integer> map = new HashMap<>();
        while (i < s.length()) {
            char ch = s.charAt(i);

            if (map.containsKey(ch) && map.get(ch) >= j) {
                // Move start pointer j to right of last occurrence of ch
                j = map.get(ch) + 1;
            }

            map.put(ch, i);
            ans = Math.max(ans, i - j + 1);
            i++;
        }

        return ans;
    }
}