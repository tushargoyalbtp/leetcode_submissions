class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> ans=new ArrayList<>();
        
        
        
        int n=nums.length;
        
        helper(nums,n,0,ans);
        
        return ans;
    }
    
    public void helper(int[] nums,int n,int index, List<List<Integer>> ans){
        
        if(index==n){
            
            List<Integer> list=new ArrayList<>();
            
            for(int i=0;i<nums.length;i++){
                list.add(nums[i]);
            }
            
            ans.add(new ArrayList<>(list));
            
            return;
            
        }
        for(int i=index;i<nums.length;i++){
            swap(i,index,nums);
            helper(nums,n,index+1,ans);
            swap(i,index,nums);
        }
        
    }
    
    public void swap(int i, int j, int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}