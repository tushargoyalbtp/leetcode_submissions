import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);  // Sort greed factors
        Arrays.sort(s);  // Sort cookie sizes

        int i = 0; // Pointer for children
        int j = 0; // Pointer for cookies

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                // Assign cookie j to child i
                i++;
            }
            j++; // Move to next cookie
        }

        return i; // Number of content children
    }
}