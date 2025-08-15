class Solution {
    public String reverseWords(String s) {
        
        List<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                int j = i;
                String str = "";
                while (j < s.length() && s.charAt(j) != ' ') {
                    str += s.charAt(j);
                    j++;
                }
                list.add(str);
                i = j; // skip to end of this word
            }
        }

        String ans = "";
        for (int i = list.size() - 1; i >= 0; i--) {
            ans += list.get(i);
            if (i > 0) ans += " ";
        }

        return ans;
    }
}