class Solution {
    public int numberOfSubstrings(String s) {
        int a=-1;
        int b=-1;
        int c=-1;
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(a!=-1 && b!=-1 && c!=-1)
            {
                count+=1+Math.min(Math.min(a,b),c);
                
            }
            if(s.charAt(i)=='a')
            {
                a=i;
            }
            else if(s.charAt(i)=='b')
            {
                b=i;
            }
            else if(s.charAt(i)=='c')
            {
                c=i;
            }
            
        }
        if(a!=-1 && b!=-1 && c!=-1)
        {
            count+=1+Math.min(Math.min(a,b),c);
                
        }
        return count;
        
    }
}