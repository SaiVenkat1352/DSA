class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            
            if(s.charAt(i)=='(' && count++>=1)
            {
                sb.append(s.charAt(i));
            }
            else if(s.charAt(i)==')' && count-->=2)
            {
                sb.append(s.charAt(i));
            }
            
        }
        return sb.toString();
    }
}