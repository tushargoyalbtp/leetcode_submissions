class Solution {
    public int numDecodings(String s) {

        Integer[] dp = new Integer[s.length()];
        
        return helper(dp,0,s);
    }

    public int helper(Integer[] dp, int i, String s){
    
        if (i == s.length())

            return 1;

        // Cannot decode a number starting with 0
        if (s.charAt(i) == '0')
        {
            return 0;
        }


        if(dp[i]!=null){
            return dp[i];
        }

        int ways =  helper(dp,i+1,s);
        
        if(i+1 < s.length()){
            int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if (num >= 10 && num <= 26){
                ways += helper(dp,i + 2, s);
            }
        }
        dp[i] = ways;

        return dp[i];
    }
}


// s = "12"

// "1" -> 'A'
// "2" -> 'B'
// "3" -> 'C'
// .
// .
// .
// .
// .
// .
// .
// .
// .
// "26" -> "z"

// 11106

// 226
