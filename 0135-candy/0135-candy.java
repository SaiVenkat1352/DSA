class Solution {
    public int candy(int[] ratings) {
        int leftToRight[]=new int[ratings.length];
        int rightToLeft[]=new int[ratings.length];
        leftToRight[0]=1;
        rightToLeft[ratings.length-1]=1;
        for(int i=1;i<ratings.length;i++)
        {
            if(ratings[i]>ratings[i-1])
            {
                leftToRight[i]=leftToRight[i-1]+1;
            }
            else{
                leftToRight[i]=1;
            }
            
        }
        for(int j=ratings.length-2;j>=0;j--)
        {
            if(ratings[j]>ratings[j+1])
            {
                rightToLeft[j]=rightToLeft[j+1]+1;
            }
            else{
                rightToLeft[j]=1;
            }
        }
        int k=0;
        int ans=0;
        while(k<leftToRight.length)
        {
            ans+=Math.max(leftToRight[k],rightToLeft[k]);
            k++;
            
        }
        return ans;
        
        
        
    }
}