    //Runtime: 3 ms, faster than 99.87% of Java online submissions for Find K Closest Elements.
    //Memory Usage: 44.2 MB, less than 93.40% of Java online submissions for Find K Closest Elements.
    //Slide Window + Binary Search
    //Time: O( lg(N-K) + K); Space: O(1)
class Pair{
    int diff;
    int val;
    Pair(int diff,int val)
    {
        this.diff=diff;
        this.val=val;
    }
}
class Solution{
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        List<Integer> list=new ArrayList<>();
        int left=0;
        int right=nums.length-1;
        while(right-left>=k)
        {
            if(Math.abs(nums[left]-x)>Math.abs(nums[right]-x))
            {
                left++;
                
            }
            else if(Math.abs(nums[left]-x)==Math.abs(nums[right]-x))
            {
                if(nums[left]>nums[right])
                {
                    left++;
                }
                else{
                    right--;
                }


            }
            else{
                right--;
            }
            

        }
        while(left<=right)
        {
            list.add(nums[left]);
            left++;
        }
        return list;


        
    }
   
}