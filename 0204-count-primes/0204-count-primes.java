class Solution {
    public int countPrimes(int n) {
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=2;i<n;i++)
        {
            if(visited[i]==false)
            {
                count++;
                for(int j=2;j*i<n;j++)
                {
                    visited[j*i]=true;
                }
            }
        }
        return count;
        
        
        
       
        
    }
}