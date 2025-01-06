class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length]; // Track visited indices
        return helper(arr, start, visited);
    }

    public boolean helper(int[] arr, int start, boolean[] visited) {
        // Base cases
        if (start < 0 || start >= arr.length || visited[start]) {
            return false; // Out of bounds or already visited
        }
        if (arr[start] == 0) {
            return true; // Found a zero
        }

        visited[start] = true; // Mark current index as visited

        // Recurse to the left and right
        boolean left = helper(arr, start - arr[start], visited);
        boolean right = helper(arr, start + arr[start], visited);

        return left || right;
    }
}
