class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int l = 0;
        int r = 0;

        int maxlen = 0;
        int maxf = 0;

        while (r < s.length()) {
            map[s.charAt(r) - 'A']++;
            maxf = Math.max(maxf, map[s.charAt(r) - 'A']);

            // shrink window if more than k replacements are needed
            if ((r - l + 1) - maxf > k) {
                map[s.charAt(l) - 'A']--;
                l++;
            }

            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }

        return maxlen;
    }
}