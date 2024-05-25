class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //greedy algorithm
        Arrays.sort(g);
        Arrays.sort(s);
        int m=g.length;
        int l=0;
        int r=0;
        int ans=0;
        while(l<m && r<s.length)
        {
            if(g[l]<=s[r])
            {
                ans++;
                l++;
                r++;
                
            }
            else{
                r++;
            }
            
        }
        return ans;
        
        
    }
}