class Solution {
    public int longestStrChain(String[] words) {
        //sort the array
        int dp[][]=new int[words.length+1][words.length];
        for(int arr[]:dp)Arrays.fill(arr,-1);
        Arrays.sort(words,(String a,String b)->a.length()-b.length());
        return helper(0,-1,words,dp);

        
        
    }
    public int helper(int ind,int prev,String[] words,int dp[][])
    {
        //base case
        if(ind>=words.length)return 0;
        if(dp[ind][prev+1]!=-1)return dp[ind][prev+1];
        //take

        int take=Integer.MIN_VALUE;
        if(prev==-1 || check(words[ind],words[prev]))
        {
            take=1+helper(ind+1,ind,words,dp);
        }
        int notTake=helper(ind+1,prev,words,dp);
        return dp[ind][prev+1]=Math.max(take,notTake);
    }
    public boolean check(String str1,String str2)
    {
        if(str1.length()==str2.length() || Math.abs(str1.length()-str2.length())>1)return false;
        
        int l=0;
        int r=0;
        while(l<str1.length() && r<str2.length())
        {
            if(str1.charAt(l)==str2.charAt(r))
            {
                l++;
                r++;
            }
            else{
                l++;
            }
        }
        if(r<str2.length())return false;
        return true;
    }
}