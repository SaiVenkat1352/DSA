class Solution {
    public int numDistinct(String s, String t) {
        int dp[][]=new int[s.length()][t.length()];
        for(int arr[] : dp)
        {
            Arrays.fill(arr,-1);
        }
        return helper(s,t,s.length()-1,t.length()-1,dp);
    }
    public int helper(String s,String t,int ind1,int ind2,int dp[][])
    {
        //base case
        if(ind2<0)return 1;
        if(ind1<0 )return 0;
        if(dp[ind1][ind2]!=-1)return dp[ind1][ind2];
        
        //equal case
        if(s.charAt(ind1)==t.charAt(ind2))
        {
            int left=helper(s,t,ind1-1,ind2-1,dp);
            int right=helper(s,t,ind1-1,ind2,dp);
            return dp[ind1][ind2]=left+right;
        }
        return dp[ind1][ind2]= helper(s,t,ind1-1,ind2,dp);
        
        
        
    }
}