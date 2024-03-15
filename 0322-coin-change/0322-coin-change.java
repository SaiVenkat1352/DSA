class Solution {
    public int coinChange(int[] arr, int amount) {
        int dp[][]=new int[arr.length][amount+1];
        for(int ar[] : dp)
        {
            Arrays.fill(ar,-1);
        }
        int maxi=helper(arr,amount,arr.length-1,dp);
        if(maxi==(int)1e9)
        {
            return -1;
        }
        return maxi;
    }
    public int helper(int arr[],int amount,int ind,int dp[][])
    {
        if(amount==0)return 0;
        if(ind==0)
        {
            if(amount%arr[ind]==0)return amount/arr[ind];
            else return (int)1e9;
        }
        if(dp[ind][amount]!=-1)return dp[ind][amount];
        int notPick=helper(arr,amount,ind-1,dp);
        int pick=(int)1e9;
        if(arr[ind]<=amount)
        {
            pick=1+helper(arr,amount-arr[ind],ind,dp);
        }
        return dp[ind][amount]=Math.min(pick,notPick);
        

    }
    
    
}