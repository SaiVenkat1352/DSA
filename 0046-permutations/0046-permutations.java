class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans=new ArrayList<>();
        Stack<Integer> ds=new Stack<>();
        boolean vis[]=new boolean[nums.length];
        helper(nums,vis,ds);
        return ans;
    }
    public void helper(int nums[],boolean vis[],Stack<Integer> ds)
    {
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(vis[i]==false)
            {
                vis[i]=true;
                ds.add(nums[i]);
                helper(nums,vis,ds);
                ds.pop();
                vis[i]=false;
            }
        }
        return;
    }
}