import java.util.HashMap;

public class Solution {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        int start = 0, minLen = Integer.MAX_VALUE, minStart = 0;
        int counter = tMap.size();
        HashMap<Character, Integer> window = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (tMap.containsKey(ch) && window.get(ch).intValue() == tMap.get(ch).intValue()) {
                counter--;
            }

            while (counter == 0) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }

                char startChar = s.charAt(start);
                window.put(startChar, window.get(startChar) - 1);
                if (tMap.containsKey(startChar) && window.get(startChar) < tMap.get(startChar)) {
                    counter++;
                }
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}