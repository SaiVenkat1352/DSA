class Solution {
    public int maxProduct(int[] nums) {


        int maxi=Integer.MIN_VALUE;
        int curr_product=1;
        for(int i=0;i<nums.length;i++)
        {
            curr_product=curr_product*nums[i];
            maxi=Math.max(maxi,curr_product);
            if(curr_product==0)
            {
                curr_product=1;
            }
        }
        curr_product=1;
        for(int i=nums.length-1;i>=0;i--)
        {
            curr_product=curr_product*nums[i];
            maxi=Math.max(maxi,curr_product);
            if(curr_product==0)
            {
                curr_product=1;
            }
        }
        return maxi;

        
    }
}