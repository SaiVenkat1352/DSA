class Solution {
    public int scoreOfParentheses(String s) {
            int score=0;
            Stack<Integer> st=new Stack<Integer>();
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)=='(')st.add(0);
                else{
                    int value=0;
                    while(st.peek()!=0)
                    {
                        value=value+st.pop();
                    }
                    st.pop();
                    st.add(Math.max(2*value,1));
                }
            }
            int ans=0;
            while(!st.isEmpty())
            {
                ans=ans+st.pop();
            }
            return ans;
                                                                    
    }
}