class Solution {
    public int numberOfSubstrings(String s) {
        
        return helper(s,3)-helper(s,2);
    }
    public int helper(String s,int k)
    {
        Map<Character,Integer> map=new HashMap<>();
        int r=0;
        int l=0;
        int count=0;
        while(r<s.length())
        {
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            while(map.size()>k)
            {
                map.put(s.charAt(l),map.getOrDefault(s.charAt(l),0)-1);
                if(map.get(s.charAt(l))==0)map.remove(s.charAt(l));
                l++;

            }
            count=count+(r-l+1);
            r++;

        }
        return count;
    }
}