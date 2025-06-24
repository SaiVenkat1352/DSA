public class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Compare current element with next element in a circular way
            int current = nums[i];
            int next = nums[(i + 1) % n]; // Wraps around to index 0 after last
            if (current > next) {
                count++;
            }
        }

        // If count > 1 → More than one decreasing point → Not sorted and rotated
        return count <= 1;
    }
}
