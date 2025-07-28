class Solution {
    public String longestWord(String[] words) {
         Set<String> wordSet = new HashSet<>(Arrays.asList(words));

        // Sort by length descending, and then lexicographically ascending
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length(); // longer first
            }
            return a.compareTo(b); // lexicographically smaller first
        });

        for (String word : words) {
            boolean isValid = true;
            for (int i = 1; i < word.length(); i++) {
                String prefix = word.substring(0, i);
                if (!wordSet.contains(prefix)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                return word;
            }
        }

        return "";
    }
}