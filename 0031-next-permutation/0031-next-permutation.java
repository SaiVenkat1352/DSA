class Solution {
    public void nextPermutation(int[] nums) {
        //1) get the break point
        int j=nums.length-2;
        while(j>=0)
        {
            if(nums[j]>=nums[j+1])
            {
                j--;
            }
            else{
                break;
            }
        }
        //2) swap the last and break point
        if(j<0){
            reverse(nums,j+1,nums.length-1);
            return;

        }
        int i=nums.length-1;
        while(i>j)
        {
            if(nums[i]>nums[j]){
                swap(nums,j,i);
                reverse(nums,j+1,nums.length-1);
                break;
            }
            else{
                i--;
            }
        }
        

        
    }
    public void reverse(int nums[],int i,int j)
    {
        while(i<=j)
        {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
    public void swap(int nums[],int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

     

     
     //2) swap the last and break point
     //3)reverse from break point to last



    

}