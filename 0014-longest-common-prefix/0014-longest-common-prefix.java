class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            prefix = helper(prefix, strs[i]);
            if (prefix.isEmpty()) // If prefix becomes empty, no need to continue
                break;
        }

        return prefix;
    }

    private String helper(String s1, String s2) {
        StringBuilder commonPrefix = new StringBuilder();
        int minLength = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                break;
            commonPrefix.append(s1.charAt(i));
        }
        return commonPrefix.toString();
    }
}
