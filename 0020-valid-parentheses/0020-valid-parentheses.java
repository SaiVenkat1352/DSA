class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Push opening brackets to stack
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                // If stack is empty or top doesn't match, return false
                if (st.isEmpty()) return false;
                char top = st.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Stack should be empty at the end for a valid string
        return st.isEmpty();
    }
}
