class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][]=new int[nums.length+1][nums.length];
        for(int arr[]:dp)
        {
            Arrays.fill(arr,-1);
        }
        return helper(0,-1,nums,dp);
        
      
        
    }
    public static int helper(int ind,int prev,int nums[],int dp[][])
    {
        //base case
        if(ind>=nums.length)return 0;


        if(dp[ind][prev+1]!=-1)return dp[ind][prev+1];
        int nottake=helper(ind+1,prev,nums,dp);
        int take=Integer.MIN_VALUE;
        if(prev==-1 || nums[ind]>nums[prev])
        {
            take=1+helper(ind+1,ind,nums,dp);
        }
        return dp[ind][prev+1]=Math.max(take,nottake);
    }
   
}