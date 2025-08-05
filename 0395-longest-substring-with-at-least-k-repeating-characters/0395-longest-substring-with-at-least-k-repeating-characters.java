class Solution {
    public int longestSubstring(String s, int k) {
        
        // HashMap<Character,Integer> map = new HashMap<>();
        // int maxLength  = 0;
        // for(int i = 0; i < s.length(); i++){
        //     char ch = s.charAt(i);

        //     if(map.containsKey(ch) && map.get(ch) >= k){
        //         maxLength = Math.max(maxLength, map.get(ch));
        //     }

        //     map.put(ch, map.getOrDefault(ch,0)+1);
        // }

        // return maxLength;
        int n = s.length();

        if(k == 0 || n < k){
            return 0;
        }

        if(k == 1){
            return n;
        }

        Map<Character,Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int l = 0;

        while(l < n && map.get(s.charAt(l)) >= k){
            l++;
        }

        if(l >= n-1){
            return l;
        }

        int ls1 = longestSubstring(s.substring(0,l), k);

        while(l < n && map.get(s.charAt(l)) < k){
            l++;
        }

        int ls2 = (l<n) ? longestSubstring(s.substring(l), k) : 0;
        return Math.max(ls1,ls2); 

    }
}