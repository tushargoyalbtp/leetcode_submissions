 class Solution {
    //                                             // not the optimised approach 178/200 test cases pass only

    // public void swap(char[] s, int i, int index){
    //     char ch=s[i];
    //     s[i]=s[index];
    //     s[index]=ch;
    // }    
    // public void helper(char[] s, int ind, ArrayList<String> res){
    //      if(ind==s.length){
    //          String str=new String(s);
    //          res.add(str);
    //          return;
    //      }

    //      for(int i=ind;i<s.length;i++){
    //         swap(s, i , ind);
    //         helper(s,ind+1,res);
    //         swap(s, i, ind);
    //      }
    // }
    // public String getPermutation(int n, int k) {
    //     String s="";
    //     int fact=1;
       
    //     ArrayList<String> res=new ArrayList<>();
    //     for(int i=1;i<=n;i++){
    //         s=s+i;
    //     }

    //     helper(s.toCharArray(), 0, res);
    //     Collections.sort(res);
    //     return res.get(k-1);
    // }

    public String getPermutation(int n, int k) {
        List<Integer> num=new ArrayList<Integer>();
        int fact=1;
        for(int i=1;i<=n;i++){
            fact*=i;
            num.add(i);
        }
        k--;
        fact /=n;
        StringBuilder sb=new StringBuilder();
        for(int i=n-1;i>=1;i--){
            int curr=k/fact;
            sb.append(String.valueOf(num.get(curr)));
            num.remove(curr);
            k %= fact;
            fact /= i;

        }
        sb.append(String.valueOf(num.get(0)));

        return sb.toString();
    }

    
}
