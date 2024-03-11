class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }
    public int helper(int[] nums,int ind,int dp[])
    {
        if(ind>=nums.length)return 0;
        //pick the element
        if(dp[ind]!=-1)return dp[ind];
        int left=nums[ind]+helper(nums,ind+2,dp);
        int right=helper(nums,ind+1,dp);
        return dp[ind]=Math.max(left,right);
        
    }
    
    
}