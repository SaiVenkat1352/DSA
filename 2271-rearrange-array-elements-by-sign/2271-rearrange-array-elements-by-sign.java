class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> positive=new ArrayList<>();
        List<Integer> negative=new ArrayList<>();
        for(int ele:nums)
        {
            if(ele<0)negative.add(ele);
            else positive.add(ele);
        }
        for(int i=0;i<nums.length/2;i++)
        {
            nums[2*i]=positive.removeFirst();
             nums[2*i+1]=negative.removeFirst();
        }
        return nums;

        

        
        
    }
   
}