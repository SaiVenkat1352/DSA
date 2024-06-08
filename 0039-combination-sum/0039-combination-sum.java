class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        
        helper(res,candidates,target,new ArrayList<>(),0);
        return res;
        
    }
    public void helper(List<List<Integer>> res,int[] arr,int target,List<Integer> ds,int i)
    {
        if(target<0)return;
        if(i>=arr.length)
        {
            if(target==0)
            {
                 res.add(new ArrayList<>(ds));
            }
            return;
        }
        //take
        ds.add(arr[i]);
        helper(res,arr,target-arr[i],ds,i);
        ds.remove(ds.size()-1);
        helper(res,arr,target,ds,i+1);
        return;

    }
}