class Solution {


    public int rob(int[] nums) {
        int dp[]=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return helper(0,nums,dp);
    }

    public static int helper( int ind, int nums[],int dp[]) {
        //base case
        if(ind>=nums.length)return 0;
        if(dp[ind]!=-1)return dp[ind];
        int take1=Integer.MIN_VALUE;
        if(ind<nums.length)
        {
            take1=nums[ind]+helper(ind+2,nums,dp);
        }
        int take2=helper(ind+1,nums,dp);
        return dp[ind]=Math.max(take1,take2);
        
    }
}
