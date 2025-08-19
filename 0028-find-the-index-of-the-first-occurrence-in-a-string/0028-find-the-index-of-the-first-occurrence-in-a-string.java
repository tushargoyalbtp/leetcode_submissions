class Solution {
    public int strStr(String haystack, String needle) {
        int l = 0;
        int r = 0;
        int windowsize = needle.length();

        while (r < haystack.length()) {
            String str = haystack.substring(l, r + 1);

            if (str.length() == windowsize && str.equals(needle)) {  // FIXED == to .equals()
                return l;
            } 
            else if (str.length() < windowsize) {
                r++;
            } 
            else {  // when str.length() > windowsize
                l++;
            }
        }

        return -1;
    }
}