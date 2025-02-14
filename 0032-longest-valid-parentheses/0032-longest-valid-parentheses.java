class Solution {
    public int longestValidParentheses(String s) {

        Stack<Integer> st=new Stack<>();
        st.add(-1);
        int maxi=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '(')
            {
                st.add(i);
            }
            else if(s.charAt(i) == ')')
            {
                st.pop();
                if(!st.isEmpty())maxi=Math.max(maxi,i-st.peek());
                else st.add(i);
            }
        }
        return maxi;
      
    }
}