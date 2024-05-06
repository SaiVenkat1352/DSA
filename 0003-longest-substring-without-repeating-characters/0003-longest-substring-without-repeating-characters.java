class Solution {
    public int lengthOfLongestSubstring(String s) {
       Map<Character,Integer> map=new HashMap<Character,Integer>();
        int l=0;
        int r=0;
        int maxi=0;
        while(r<s.length())
        {
            if(map.containsKey(s.charAt(r)) && map.get(s.charAt(r))>=l)
            {
              l=map.get(s.charAt(r))+1; 
                
            }
            map.put(s.charAt(r),r);
        
            
            maxi=Math.max(maxi,r-l+1);
            r++;
        }
        return maxi;
        
    }
}