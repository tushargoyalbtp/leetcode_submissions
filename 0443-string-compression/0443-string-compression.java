class Solution {
    public int compress(char[] chars) {
        int i = 0;  // read pointer
        int index = 0; // write pointer

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count frequency of the current char
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            // Write the character
            chars[index++] = currentChar;

            // Write the count digits (if > 1)
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index; // new length
    }
}
