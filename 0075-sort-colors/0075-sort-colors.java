class Solution {
    public void sortColors(int[] nums) {
        int l=0;
        int h=nums.length-1;
        int mid=0;
        while(mid<=h)
        {
            if(nums[mid]==0)
            {
                int temp=nums[l];
                nums[l]=nums[mid];
                nums[mid]=temp;
                l++;
                mid++;
            }
            else if(nums[mid]==1)
            {
                mid++;
            }
            else{
                int temp=nums[h];

                nums[h]=nums[mid];
                nums[mid]=temp;
                h--;
            }
        }
        
    }
}