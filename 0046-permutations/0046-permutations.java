class Solution {
    static List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        helper(-1,nums,ds);
        
        return ans;
        
    }
    public static void helper(int ind,int[] nums,List<Integer> ds)
    {
        // base case
        if(ds.size()==nums.length)
        {
            ans.add(new ArrayList<>(ds));
           return;
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(i!=ind && !ds.contains(nums[i]))
            {
                ds.add(nums[i]);
                helper(i,nums,ds);
                ds.remove(ds.size()-1);
            }
        }
    }
    
}