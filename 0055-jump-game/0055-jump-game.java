class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        Boolean[] memo = new Boolean[n]; // Memoization array to store results for each index
        return helper(nums, 0, memo);
    }

    public static boolean helper(int[] nums, int ind, Boolean[] memo) {
        // Base case: if the current index reaches or exceeds the last index
        if (ind >= nums.length - 1) {
            return true;
        }

        // Check if this subproblem is already solved
        if (memo[ind] != null) {
            return memo[ind];
        }

        // Get the maximum position you can jump to from the current index
        int maxJump = nums[ind] + ind;

        // Try every possible jump from the current index
        for (int i = ind + 1; i <= maxJump && i < nums.length; i++) {
            if (helper(nums, i, memo)) {
                memo[ind] = true; // Store result for the current index
                return true;
            }
        }

        // If no jump leads to the end, store false in the memo array
        memo[ind] = false;
        return false;
    }
}
