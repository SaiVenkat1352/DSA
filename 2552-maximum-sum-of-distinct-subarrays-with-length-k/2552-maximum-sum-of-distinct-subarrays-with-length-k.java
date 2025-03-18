class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int r=0;
        int l=0;
        long sum=0;
        long res=0;
        while(r<k)
        {
            sum=sum+nums[r];
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            r++;
        }
        if(map.size()==k)res=Math.max(res,sum);
        while(r<nums.length)
        {
            sum=sum+nums[r];
            sum=sum-nums[l];
            map.put(nums[l],map.get(nums[l])-1);
            if(map.get(nums[l])==0)map.remove(nums[l]);
            l++;
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            if(map.size()==k)res=Math.max(res,sum);
            r++;
        }
        return res;

        
        

        
    }
}