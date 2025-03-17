class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;

        // Frequency array to store character counts
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Identify the splitting character
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] < k) {
                // Split around this character and recurse
                int maxLen = 0;
                for (String subStr : s.split(String.valueOf(s.charAt(i)))) {
                    maxLen = Math.max(maxLen, longestSubstring(subStr, k));
                }
                return maxLen;
            }
        }

        // All characters satisfy the frequency condition
        return s.length();
    }
}
