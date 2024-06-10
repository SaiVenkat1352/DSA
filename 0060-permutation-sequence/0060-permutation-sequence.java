class Solution {
    
    public String getPermutation(int n, int k) {
        int fact=1;
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<n;i++)
        {
            list.add(i);
            fact=fact*i;
        }
        list.add(n);
        String ans="";
        k=k-1;
        while(true)
        {
            ans=ans+Integer.toString(list.get(k/fact));
            list.remove(list.get(k/fact));
            if(list.size()==0)break;
            k=k%fact;
            fact=fact/list.size();
            
        }
        return ans;
    }
   
    
}