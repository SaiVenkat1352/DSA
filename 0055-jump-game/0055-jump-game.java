class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1)return true;
        int maxiIndex=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i>maxiIndex)return false;
            maxiIndex=Math.max(maxiIndex,i+nums[i]);
            
        }
        if(maxiIndex>=nums.length-1)return true;
        return false;
      

        
    }

    
}
