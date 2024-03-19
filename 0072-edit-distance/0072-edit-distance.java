class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][]=new int[word1.length()][word2.length()];
        for(int arr[]:dp)
        {
            Arrays.fill(arr,-1);
        }
        return helper(word1,word2,word1.length()-1,word2.length()-1,dp);
        
    }
    public int helper(String word1,String word2,int ind1,int ind2,int dp[][])
    {
        if(ind1<0)return ind2+1;
        if(ind2<0)return ind1+1;
        if(dp[ind1][ind2]!=-1)return dp[ind1][ind2];
        if(word1.charAt(ind1)==word2.charAt(ind2))return 0+helper(word1,word2,ind1-1,ind2-1,dp);
        int insert=1+helper(word1,word2,ind1,ind2-1,dp);
        int delete=1+helper(word1,word2,ind1-1,ind2,dp);
        int replace=1+helper(word1,word2,ind1-1,ind2-1,dp);
        return dp[ind1][ind2]=Math.min(insert,Math.min(delete,replace));
        
        
    }
}