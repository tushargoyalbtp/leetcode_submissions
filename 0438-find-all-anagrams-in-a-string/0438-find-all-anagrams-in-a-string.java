class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        
        int m = s.length(), n = p.length();
        
        if(m < n) return result;
        
        int[] pHashTable = new int[26], sHashTable = new int[26];
        
        for(int i = 0; i < n; i++){
            pHashTable[p.charAt(i) - 'a']++;
            sHashTable[s.charAt(i) - 'a']++;
        }
        for(int i = n; i <= m; i++){
            if(compare(pHashTable, sHashTable)) result.add(i - n);
            sHashTable[s.charAt(i - n) - 'a']--;
            if(i < m) sHashTable[s.charAt(i) - 'a']++;
        }
    
        return result;
    }

    public static boolean compare(int[] a, int[] b){
        for(int i = 0; i < 26; i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
}