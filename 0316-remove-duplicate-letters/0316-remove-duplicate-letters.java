class Solution {
    public String removeDuplicateLetters(String s) {
        boolean visited[] = new boolean[26];  // Track if a character is in the result
        Stack<Character> st = new Stack<>();  // Stack to store the result in correct order
        int lastIndex[] = new int[26];  // Last occurrence of each character
        
        // Store last index of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If character is already in stack, skip
            if (visited[ch - 'a']) continue;

            // Maintain lexicographical order
            while (!st.isEmpty() && st.peek() > ch && lastIndex[st.peek() - 'a'] > i) {
                visited[st.pop() - 'a'] = false;
            }

            // Push current character and mark it as visited
            st.push(ch);
            visited[ch - 'a'] = true;
        }
         StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.insert(0, st.pop()); // Insert at beginning to maintain order
        }

        return ans.toString();
        
    }
}