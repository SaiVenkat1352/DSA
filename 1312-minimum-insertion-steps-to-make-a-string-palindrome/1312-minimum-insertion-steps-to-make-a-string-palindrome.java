class Solution {
    public int minInsertions(String s) {
        
    
         String s2=reverse(s);
        int dp[][]=new int[s.length()][s2.length()];
        for(int arr[]:dp)
        {
            Arrays.fill(arr,-1);
        }
        int ans= helper(s,s2,s.length()-1,s2.length()-1,dp);
        return s.length()-ans;
        
       
    }
    public int helper(String s1,String s2,int ind1,int ind2,int dp[][])
    {
        //base case
        if(ind1<0 || ind2<0)return 0;
        if(dp[ind1][ind2]!=-1)return dp[ind1][ind2];
        
        if(s1.charAt(ind1)==s2.charAt(ind2))
        {
            return 1+helper(s1,s2,ind1-1,ind2-1,dp);
        }
        int left=helper(s1,s2,ind1-1,ind2,dp);
        int right=helper(s1,s2,ind1,ind2-1,dp);
        return dp[ind1][ind2]=Math.max(left,right);
    }
    public String reverse(String s)
    {
        String ans="";
        for(int i=s.length()-1;i>=0;i--)
        {
            ans=ans+s.charAt(i);
        }
        return ans;
    }
    
    
}