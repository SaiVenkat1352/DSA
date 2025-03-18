class Solution {
    public int maxProduct(int[] nums) { 
       int preffix=1;
       int suffix=1;
       int maxi=Integer.MIN_VALUE;
       for(int i=0;i<nums.length;i++)
       {
           if(preffix==0)preffix=1;
           if(suffix==0)suffix=1;
           preffix=preffix*nums[i];
           suffix=suffix*nums[nums.length-i-1];
           maxi=Math.max(maxi,Math.max(preffix,suffix));

       }
       return maxi;
    }
}