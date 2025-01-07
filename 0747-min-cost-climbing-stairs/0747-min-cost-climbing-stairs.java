class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[]=new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(helper(0,cost,dp),helper(1,cost,dp));
        
        
        
    }
    public static int helper(int ind,int[] cost,int dp[])
    {
        if(ind>=cost.length)
        {
            return 0;
        }
        if(dp[ind]!=-1)return dp[ind];
        int left=cost[ind]+helper(ind+1,cost,dp);
        int right=Integer.MAX_VALUE;
        if(ind<=cost.length-1)right=cost[ind]+helper(ind+2,cost,dp);
        return dp[ind]= Math.min(left,right);
        
    }
}