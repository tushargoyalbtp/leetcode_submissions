class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String nums=countAndSay(n-1);
        StringBuilder res=new StringBuilder();
        int count=0;
        //String res="";
        for(int i=0;i<nums.length();i++){
            count++;
            if(i==nums.length()-1||nums.charAt(i)!=nums.charAt(i+1)){
                res.append(count).append(nums.charAt(i));
                count=0;
            }
        }
        return res.toString();
    }
}