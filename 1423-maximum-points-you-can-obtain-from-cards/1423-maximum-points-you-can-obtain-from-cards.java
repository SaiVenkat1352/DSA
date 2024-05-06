class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum=0;
        int maxi=0;
        for(int i=0;i<k;i++)
        {
            sum=sum+cardPoints[i];
        }
        int end=cardPoints.length-1;
        maxi=Math.max(maxi,sum);
        k=k-1;
        while(end>=0 && k>=0)
        {
            sum=sum-cardPoints[k];
            sum=sum+cardPoints[end];
            k--;
            end--;
            maxi=Math.max(maxi,sum);
        }
        return maxi; 
       

    }
        
}