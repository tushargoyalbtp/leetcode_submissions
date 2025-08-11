class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        // Filter only alphanumeric characters and make lowercase
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }

        int i = 0;
        int j = sb.length() - 1;

        while (i <= j) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
