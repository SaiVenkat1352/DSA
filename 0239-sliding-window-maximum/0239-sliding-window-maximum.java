import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) return new int[0];
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int index = 0;
        int r=0;
        int l=0;
        while(r<nums.length)
        {
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[r]) {
                dq.pollLast();
            }
            dq.addLast(r);
            if (r-l+1==k) {
                result[index++] = nums[dq.peekFirst()];
                if(nums[dq.peekFirst()]==nums[l])
                {
                    dq.removeFirst();

                }
                l++;
            }
            r++;
        }
        return result;

    }
}
