class Solution {
    // public void swaps(int i , int index, char[] chars){
    //     char ch = chars[i];
    //     chars[i] = chars[index];
    //     chars[index] = ch;
    // }

    // public void helper(char[] chars, int index, List<String> ansList){

    //     if(index == chars.length){
    //         String str = new String(chars);
    //         ansList.add(str);
    //         return;
    //     }

    //     for(int i = index; i < chars.length; i++){
    //         swaps(i, index, chars);
    //         helper(chars, index+1, ansList);
    //         swaps(i, index, chars);
    //     }
    // }
    public String getPermutation(int n, int k) {
        List<Integer> ansList = new ArrayList<Integer>();

        int fact = 1;

        for(int i = 1 ; i <= n; i++){
            fact = fact*i;
            ansList.add(i);
        }

        k--;
        StringBuilder sb = new StringBuilder();
        fact = fact/n;

        for(int i = n-1; i>=1; i--){
            int curr = k/fact;
            sb.append(String.valueOf(ansList.get(curr)));
            ansList.remove(curr);
            k %= fact;
            fact = fact/i;
        }

        sb.append(String.valueOf(ansList.get(0)));
        return sb.toString();

        // String str = "";
        // for(int i = 1; i <= n; i++){
        //     str = str + i;
        // }


        // helper(str.toCharArray(), 0, ansList);
        // Collections.sort(ansList);
        // return ansList.get(k-1);
    }
}




// STRING 123 -> 
// 1 3 2,

// 2 1 3,
// 2 3 1