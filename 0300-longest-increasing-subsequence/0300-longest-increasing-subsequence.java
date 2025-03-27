class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][]=new int[nums.length+1][nums.length];
        for(int arr[]:dp)
        {
            Arrays.fill(arr,-1);
        }
        return helper(nums,0,-1,dp);
      
        
    }
    public static int helper(int nums[],int ind,int prev,int dp[][]){
        //base case
        if(ind>=nums.length)return 0;

        //take
        if(dp[prev+1][ind]!=-1)return dp[prev+1][ind];
        int take=Integer.MIN_VALUE;
        if(prev==-1 || nums[ind]>nums[prev])
        {
            take=1+helper(nums,ind+1,ind,dp);
        }

        //nottake
        int nottake=helper(nums,ind+1,prev,dp);

        //return 
        return dp[prev+1][ind]=Math.max(take,nottake);
    }
    
}