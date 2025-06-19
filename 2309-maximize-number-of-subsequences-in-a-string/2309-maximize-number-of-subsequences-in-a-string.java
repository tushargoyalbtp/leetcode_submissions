class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        long countFirst = 0, countSecond = 0;
        long subseqCount = 0;

        // count pairs of pattern[0] followed by pattern[1]
        for (char c : text.toCharArray()) {
            if (c == pattern.charAt(1)) {
                subseqCount += countFirst;
                countSecond++;
            }
            if (c == pattern.charAt(0)) {
                countFirst++;
            }
        }

        // Option 1: add pattern[0] at beginning → matches with all pattern[1]
        long option1 = subseqCount + countSecond;
        // Option 2: add pattern[1] at end → matches with all pattern[0]
        long option2 = subseqCount + countFirst;

        return Math.max(option1, option2);
    }
}
