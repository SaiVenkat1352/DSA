class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // Initialize dp array with -1 (unvisited)
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        return helper(nums, 0, dp);
    }

    public int helper(int[] nums, int ind, int[] dp) {
        // Base case: If we reach or exceed the last index, no more jumps are needed
        if (ind >= nums.length - 1) {
            return 0;
        }

        // If already computed, return the stored result
        if (dp[ind] != -1) {
            return dp[ind];
        }

        int maxJump = ind + nums[ind];
        int minJumps = Integer.MAX_VALUE;

        // Try all possible jumps and find the minimum
        for (int i = ind + 1; i <= maxJump && i < nums.length; i++) {
            int jumps = helper(nums, i, dp);
            if (jumps != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, jumps + 1);
            }
        }

        // Store the result in dp array
        dp[ind] = minJumps;
        return dp[ind];
    }
}
