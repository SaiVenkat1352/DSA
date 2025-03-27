class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];

        int dp[]=new int[nums.length+1];
        Arrays.fill(dp,-1);
        int a1=helper(0,nums.length-1,nums,dp);
        Arrays.fill(dp,-1);
        int a2=helper(1,nums.length,nums,dp);
        return Math.max(a1,a2);
    }
    public static int helper( int ind,int last, int nums[],int dp[]) {
        //base case
        if(ind>=last)return 0;
        if(dp[ind]!=-1)return dp[ind];
        int maxi=Integer.MIN_VALUE;
        for(int i=ind;i<last;i++)
        {
            int take=nums[i]+helper(i+2,last,nums,dp);
            maxi=Math.max(maxi,take);
            
        }
        return dp[ind]=maxi;
        
    }
    
    
    
    
}