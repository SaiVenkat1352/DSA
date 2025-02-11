class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
        
    }
    public int helper(int[] nums,int goal)
    {
        if(goal<0)return 0;
        int l=0;
        int r=0;
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
       
        while(r<nums.length)
        {
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>goal)
            {
                int val=map.get(nums[l]);
                if(val-1==0)map.remove(nums[l]);
                else map.put(nums[l],val-1);
                l++;
            }
            count+=r-l+1;
            r++;
            
            
        }
        return count;
    }
}