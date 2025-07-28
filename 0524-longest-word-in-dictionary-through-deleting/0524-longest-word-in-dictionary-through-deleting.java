class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";

        for (String word : dictionary) {
            if (isSubsequence(s, word)) {
                // If longer OR same length but lexicographically smaller
                if (word.length() > result.length() ||
                   (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }

        return result;
        
    }
    private boolean isSubsequence(String s, String word) {
        int i = 0, j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) == word.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == word.length();
    }

}