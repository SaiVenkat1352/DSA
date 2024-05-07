class Solution {
    public int longestOnes(int[] nums, int k) {
        // sliding windpow approach
        int l=0;
        int r=0;
        int maxLength=0;
        int zeros=0;
        while(r<nums.length)
        {
            // condition
            if(nums[r]==0)zeros++;
            if(zeros>k)
            {
                if(nums[l]==0)zeros--;
                l++;
            }
           
            maxLength=Math.max(maxLength,r-l+1);
            r++;
            
        }
        return maxLength;
          
        
    }
}