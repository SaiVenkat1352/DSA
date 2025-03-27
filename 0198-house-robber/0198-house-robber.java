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
        int maxi=Integer.MIN_VALUE;
        for(int i=ind;i<nums.length;i++)
        {
            int take=nums[i]+helper(i+2,nums,dp);
            maxi=Math.max(maxi,take);
            
        }
        return dp[ind]=maxi;
        
    }
}
