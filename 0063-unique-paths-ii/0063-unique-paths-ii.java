class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //row
        int m=obstacleGrid.length;
        //col
        int n=obstacleGrid[0].length;
        int dp[][]=new int[m][n];
        for(int arr[]:dp)
        {
            Arrays.fill(arr,-1);
        }
        return helper(obstacleGrid,m-1,n-1,dp);
        
    }
    public int helper(int[][] grid,int m,int n,int dp[][])
    {
        if(m<0 || n<0)return 0;
        if(grid[m][n]==1)return 0;
        if(m==0 && n==0)return 1;
        if(dp[m][n]!=-1)return dp[m][n];
        int left=helper(grid,m-1,n,dp);
        int right=helper(grid,m,n-1,dp);
        return dp[m][n]=left+right;
    }
    
}