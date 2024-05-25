class Solution {
    public boolean canJump(int[] nums) {
      int maxIndex=0;
      for(int i=0;i<nums.length-1;i++)
      {
          if(i>maxIndex)return false;
          if(maxIndex<nums[i]+i)
          {
              maxIndex=nums[i]+i;
          }
          
      }
      if(maxIndex<nums.length-1)return false;
      return true;
        
    }
}