class Solution {
    public int longestStrChain(String[] words) {
         Arrays.sort(words, Comparator.comparing(s->s.length()));
        int dp[][]=new int[words.length][words.length+1];
        for(int arr[]:dp)
        {
            Arrays.fill(arr,-1);
        }
        return helper(words,0,-1,dp);
        
    }
    public int helper(String[] words,int ind,int prev,int dp[][])
    {
        // base case
        if(ind==words.length)return 0;
        // left case
        if(dp[ind][prev+1]!=-1)return dp[ind][prev+1];
        int left=0;
        if(prev==-1 || comparator(words[ind],words[prev]))
        {
            left=1+helper(words,ind+1,ind,dp);
            
        }
        // right case
        int right=helper(words,ind+1,prev,dp);
        // return 
        return dp[ind][prev+1]=Math.max(left,right);
    }
    public boolean comparator(String word1,String word2)
    {
        if(word1.length()==word2.length())return false;
        int heighCount=(word1.length()>word2.length())?word1.length():word2.length();
        int count =0;
        String s1=(word1.length()>word2.length())?word1:word2;
        String s2=(word1.length()<word2.length())?word1:word2;
        int i=0;
        int j=0;
        while(i<s1.length() && j<s2.length())
        {
            if(s1.charAt(i)==s2.charAt(j))
            {
                count++;
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
        if(heighCount-count==1)return true;
        return false;
       
         
        
        
        
    }
}