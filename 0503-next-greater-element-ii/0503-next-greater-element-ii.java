class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int total=nums.length+nums.length;
        int res[]=new int[nums.length];
        Stack<Integer> st=new Stack<Integer>();
        for(int i=total-1;i>=0;i--)
        {
            while(!st.isEmpty() && nums[i%nums.length]>=st.peek())
            {
                st.pop();

            }
            if(i<nums.length)
            {
                if(st.isEmpty())res[i]=-1;
                else res[i]=st.peek();
                

            }
            st.add(nums[i%nums.length]);

            

        }
        return res;
    }
}