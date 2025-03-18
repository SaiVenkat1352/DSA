class Solution {
  public int numOfSubarrays(int[] nums) {
    int MOD = 1_000_000_007;
        int sum=0;
        int oddSum=0;
        int evenSum=1;
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];
            if(sum%2==0)
            {
               count=(count+oddSum)%MOD;
               evenSum++;
            }
            else
            {
               
                count=(count+evenSum)%MOD;
                oddSum++;
            }
        }
        return count;
  }  
        
        
}