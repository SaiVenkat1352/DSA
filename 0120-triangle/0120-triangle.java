class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][]=new int[triangle.size()][triangle.size()];
        for(int arr[]:dp)Arrays.fill(arr,-1);
        return helper(triangle,0,0,dp);

        
    }
    public int helper(List<List<Integer>> triangle,int row,int col,int dp[][])
    {
        if(row==triangle.size()-1)return triangle.get(row).get(col);
        if(dp[row][col]!=-1)return dp[row][col];
        int left=triangle.get(row).get(col)+helper(triangle,row+1,col,dp);
        int right=triangle.get(row).get(col)+helper(triangle,row+1,col+1,dp);
        return dp[row][col]=Math.min(left,right);
    }
    
}