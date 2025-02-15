

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        // this is for prefix sum
        long prefix[]=new long[nums.length+1];
        for(int i=0;i<nums.length;i++)
        {
            prefix[i+1]=prefix[i]+nums[i];
        }
        Deque<Integer> dq=new LinkedList<>();
        int minLength=Integer.MAX_VALUE;
        for(int i=0;i<=nums.length;i++)
        {
            while(!dq.isEmpty() && prefix[i]-prefix[dq.peekFirst()]>=k)
            {
                minLength=Math.min(minLength,i-dq.pollFirst());
                //dq.pollFirst();
            }
            while(!dq.isEmpty() && prefix[dq.peekLast()]>=prefix[i])
            {
                dq.pollLast();

            }
            dq.addLast(i);

        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
