class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int arr[]:dp)
        {
            Arrays.fill(arr,-1);
        }
        return helper(m-1,n-1,dp,grid);
    }
    public int helper(int m,int n,int dp[][],int grid[][])
    {
        if(m==0 && n==0)return grid[0][0];
        if(m<0 || n<0)return (int)1e8;
        if(dp[m][n]!=-1)return dp[m][n];
        int left=grid[m][n]+helper(m-1,n,dp,grid);
        int right=grid[m][n]+helper(m,n-1,dp,grid);
        return dp[m][n]=Math.min(left,right);
        
    
    }
    
}