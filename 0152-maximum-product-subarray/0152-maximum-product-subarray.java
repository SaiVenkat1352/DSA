class Solution {
    public int maxProduct(int[] nums) { 
        int mul=1;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            mul=mul*nums[i];
            if(mul>ans)ans=mul;
            if(mul==0)mul=1;
        }
        mul=1;
        for(int i=nums.length-1;i>0;i--)
        {
            mul=mul*nums[i];
            if(mul>ans)ans=mul;
            if(mul==0)mul=1;
        }
        return ans;
        
    }
}