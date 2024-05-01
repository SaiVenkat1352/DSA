class Solution {
    public int maxDepth(String s) {
        int count=0;
        int maxCount=0;
       char arr[]=s.toCharArray();
        for(char c:arr)
        {
            if(c=='(')
            {
                count++;
                if(maxCount<count)
                {
                    maxCount++;
                }
            }
            else if(c==')')
            {
                count--;
            }
        }
        return maxCount;
    }
}