import java.util.Arrays;

class Solution {
    public boolean checkValidString(String s) {
        boolean[] flag = new boolean[1];
        flag[0] = false;
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        helper(0, s, 0, flag, dp);
        return flag[0];
    }

    private void helper(int i, String s, int count, boolean[] flag, int[][] dp) {
        if (count < 0) return;  // Too many closing brackets
        if (i == s.length()) {
            if (count == 0) flag[0] = true;
            return;
        }
        if (flag[0]) return;  // Early exit if valid string is already found

        if (dp[i][count] != -1) return;  // Memoization check
        dp[i][count] = 0;  // Mark as visited

        if (s.charAt(i) == '(') {
            helper(i + 1, s, count + 1, flag, dp);
        } else if (s.charAt(i) == ')') {
            helper(i + 1, s, count - 1, flag, dp);
        } else {  // s.charAt(i) == '*'
            helper(i + 1, s, count, flag, dp);      // Treat '*' as empty
            helper(i + 1, s, count + 1, flag, dp);  // Treat '*' as '('
            helper(i + 1, s, count - 1, flag, dp);  // Treat '*' as ')'
        }
    }

    
}
