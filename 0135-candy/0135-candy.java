class Solution {
    public int candy(int[] ratings) {
        int leftToRight[]=new int[ratings.length];
        int rightToLeft[]=new int[ratings.length];
        leftToRight[0]=1;
        rightToLeft[ratings.length-1]=1;
        int i=1;
        int j=ratings.length-2;
        while(i<ratings.length && j>=0)
        {
            if(ratings[i]>ratings[i-1])
            {
                leftToRight[i]=leftToRight[i-1]+1;
            }
            if(ratings[j]>ratings[j+1])
            {
                rightToLeft[j]=rightToLeft[j+1]+1;
            }
            if(ratings[i]<=ratings[i-1]){
                leftToRight[i]=1;
                
            }
            if(ratings[j]<=ratings[j+1])
            {
                rightToLeft[j]=1;
            }
            i++;
            j--;
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