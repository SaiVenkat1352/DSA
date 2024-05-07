class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2==0)
            {
                nums[i]=0;
            }
            else{
                nums[i]=1;
            }
        }
        return helper(nums,k)-helper(nums,k-1);
        
    }
    public int helper(int[] nums,int goal)
    {
        if(goal<0)return 0;
        int l=0;
        int r=0;
        int count=0;
        int sum=0;
        while(r<nums.length)
        {
            sum=sum+nums[r];
            while(sum>goal)
            {
                sum=sum-nums[l];
                l++;
            }
            count+=r-l+1;
            r++;
            
            
        }
        return count;
    }
}