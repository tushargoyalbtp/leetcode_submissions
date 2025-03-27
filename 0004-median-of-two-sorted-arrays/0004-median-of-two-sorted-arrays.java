class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j =0;
        int k = 0;
        int[] ans = new int[nums1.length+nums2.length];

        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                ans[k]=nums1[i];
                i++;
                k++;
            }
            else if(nums1[i]>nums2[j]){
                ans[k]=nums2[j];
                j++;
                k++;
            }
            else{
                ans[k]=nums1[i];
                i++;
                k++;
                ans[k]=nums2[j];
                j++;
                k++;
            }
        }

        while(j<nums2.length){
            ans[k]=nums2[j];
            j++;
            k++;
        }

        while(i<nums1.length){
            ans[k]=nums1[i];
            i++;
            k++;
        }

        for(int p=0;p<ans.length;p++){
            System.out.print(ans[p]+ ", ");
        }

        int length = ans.length;
        System.out.println("length of final array: "+length);

        if(length%2!=0){
            System.out.println( (double)(ans[length/2]));
            return (double)(ans[length/2]);
        }
        else{
            double sum = (double)(ans[length/2] + ans[length/2 - 1]);
            // System.out.println(ans[length/2] + "" + ans[length/2 - 1]);
            return sum/2;
        }
    }
}