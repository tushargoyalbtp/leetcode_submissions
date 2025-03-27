import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        
        int i = 0, j = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;

        while (j < s.length()) {
            char ch = s.charAt(j);


            if (charMap.containsKey(ch)) {
                i = Math.max(charMap.get(ch) + 1, i);
            }

 
            charMap.put(ch, j);
            maxLength = Math.max(maxLength, j - i + 1);

            j++;
        }

        return maxLength;
    }
}
