class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int mini=Integer.MAX_VALUE;
        int dp[][]=new int[row][col];
        for(int arr[]:dp)Arrays.fill(arr,-1);
        for(int i=col-1;i>=0;i--)
        {
            int a=helper(matrix,row-1,i,dp);
            if(a<mini)mini=a;

        }
        return mini;

        
    }
    public int helper(int[][] grid,int row,int col,int dp[][])
    {
        if(col<0 || col>=grid[0].length)return (int)1e9;

        if(row==0)
        {
            return dp[row][col]=grid[0][col];

        }
        if(dp[row][col]!=-1)return dp[row][col];
        
        int l1=grid[row][col]+helper(grid,row-1,col,dp);
        int l2=grid[row][col]+helper(grid,row-1,col-1,dp);
    
        int l3=grid[row][col]+helper(grid,row-1,col+1,dp);
        
        return dp[row][col]=Math.min(l1,Math.min(l2,l3));
    }

        
        
        
    
}