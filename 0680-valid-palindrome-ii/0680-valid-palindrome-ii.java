// class Solution {
//     public boolean validPalindrome(String s) {
//         int n = s.length();

//         for (int i = 0; i < n; i++) {
//             String a = s.substring(0, i) + s.substring(i + 1, n); // remove char at i
//             if (isPalindrome(a)) {
//                 return true;
//             }
//         }
//         return false;
//     }

//     public boolean isPalindrome(String str) {
//         int i = 0;
//         int j = str.length() - 1;

//         while (i < j) { // fix: stop when i >= j
//             if (str.charAt(i) != str.charAt(j)) {
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         return true;
//     }
// }


class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Try skipping either left or right char
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}