class Solution {
    public int strongPasswordChecker(String password) {
        
        int n = password.length();

        boolean hasupper = false, haslower = false, hasdigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c))
                haslower = true;
            if (Character.isUpperCase(c))
                hasupper = true;
            if (Character.isDigit(c))
                hasdigit = true;
        }

        int missingtypes = 0;

        if (!haslower) {
            missingtypes++;
        }
        if (!hasupper) {
            missingtypes++;
        }
        if (!hasdigit) {
            missingtypes++;
        }

        int replace = 0;
        int oneMod = 0;
        int twoMod = 0;
        // for(int i = 2; i < n; i++){
        //     if(password.charAt(i) == password.charAt(i-1) && password.charAt(i-1) == password.charAt(i-2)){
        //         int length = 2;
        //         while(i < n && password.charAt(i) == password.charAt(i-1)){
        //             i++;
        //             length++;
        //         }
        //         replace += length / 3;
        //         if(length % 3 == 0){
        //             oneMod++;
        //         }
        //         else if(length % 3 == 1){
        //             twoMod++;
        //         }
        //     }
        //     else{
        //         i++;
        //     }
        // }

        for(int i = 0; i<n; ){
            int j = i;
           while(i < n && password.charAt(i) == password.charAt(j)){
                i++;
            }

            int length = i-j;
            if(length >= 3){
                replace += length/3;

                if(length%3 == 0){
                    oneMod++;
                }
                else if(length%3 == 1){
                    twoMod++;
                }
            }
        }

        if(n < 6){
            return Math.max(missingtypes, 6-n);
        }
        else if( n <= 20 ){
            return Math.max(missingtypes, replace);
        }
        else{
            int delete = n - 20;
            int reduce = delete;
            

            int used = Math.min(oneMod, reduce);
            replace -= used;
            reduce -= used;

            used = Math.min(twoMod * 2, reduce);
            replace -= used/2;
            reduce -= used;

            replace -= reduce/3;

            return delete + Math.max(missingtypes, replace);
        }

    }
}