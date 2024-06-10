class Solution {
    static List<List<String>> res;
    public List<List<String>> partition(String s) {
        res=new ArrayList<>();
        List<String> ds=new ArrayList<>();
        helper(0,s,ds);
        return res;
    }
    public static void helper(int ind,String s,List<String> ds){
          // base case
          if(ind==s.length())
          {
             res.add(new ArrayList<>(ds));
             return;
          }
          for(int i=ind;i<s.length();i++)
          {
              // check
              if(isPolindrome(s,ind,i))
              {
                  ds.add(s.substring(ind,i+1));
                  helper(i+1,s,ds);
                  ds.remove(ds.size()-1);
              }
              
          }
    }
    public static boolean isPolindrome(String s,int l,int r)
    {
        while(l<=r)
        {
            if(s.charAt(l)!=s.charAt(r))
            {
                return false;
                
            }
            l++;
            r--;
        }
        return true;
    }
}