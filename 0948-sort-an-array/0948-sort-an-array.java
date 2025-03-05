class Solution {
    public int[] sortArray(int[] nums) {
        helper(nums,0,nums.length-1);
        return nums;
    }
    public static void helper(int nums[],int left,int right)
    {
        if(left<right)
        {
            int mid=left+(right-left)/2;
            helper(nums,left,mid);
            helper(nums,mid+1,right);
            merge(nums,left,mid,right);
        }
    }
    public static void merge(int nums[],int left,int mid,int right)
    {
         int n1=mid-left+1;
         int n2=right-mid;
         int temp[]=new int[n1+n2];
         int p1=left;
         int p2=mid;
         int p3=mid+1;
         int p4=right;
         int k=0;
         while(p1<=p2 && p3<=p4)
         {
            if(nums[p1]<=nums[p3])
            {
                temp[k++]=nums[p1];
                p1++;
            }
            else{
                temp[k++]=nums[p3];
                p3++;
            }
         }
         while(p1<=p2 )
         {
            temp[k++]=nums[p1];
            p1++;

         }
         while(p3<=p4 )
         {
             temp[k++]=nums[p3];
            p3++;
            
         }
        
        for (int i = 0; i < k; i++) {
        nums[left + i] = temp[i];
    }



    }
    public static void swap(int nums[],int low,int high)
    {
        int temp=nums[low];
        nums[low]=nums[high];
        nums[high]=temp;

    }
   
    
   
    
}